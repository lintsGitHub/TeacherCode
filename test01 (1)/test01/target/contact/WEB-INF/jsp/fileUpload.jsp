<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>canvas + ajax</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
          integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>

    <style>
        #myimg {
            border: 3px solid gray;
            border-radius: 5px;
            position: absolute;
            top: 0;
            left: 0;
        }

        #mymask {
            position: absolute;
            top: 0;
            left: 0;
        }
    </style>
</head>
<body>


<div class="container">
    <div style="margin-top: 2em;">
        <input type="file" id="myfile" style="display: none"> <!-- 选择文件后，要预览 -->
        <button class="btn btn-primary" onclick="myfile.click()">选择图片</button>
        <button class="btn btn-primary" onclick="clickMe()">上传图片</button>
    </div>

    <div style="position: relative">
        <img src="" id="myimg" title="暂时没有上传" width="200" height="200"/>
        <canvas id="mymask" width="200" height="200">不支持canvas</canvas>
    </div>
</div>


<script>

    var ctx;

    myfile.onchange = () => { // 预览图片
        var imgUrl = URL.createObjectURL(event.target.files[0]);
        myimg.src = imgUrl;
        myimg.onload = () => URL.revokeObjectURL(imgUrl);
    };

    function clickMe() {
        compressImgWithCanvas(myfile.files[0], uploadWithAxios);
        // uploadWithAJAX(myfile.files[0]);

    }

    /**
     * 压缩图片，然后执行某些任务
     */
    function compressImgWithCanvas(blob, taskCallback) {
        console.log("bbb");
        var rat = 2;
        var w = myimg.naturalWidth / rat, h = myimg.naturalHeight / rat;

        var canvas = document.createElement("canvas");
        canvas.width = w;
        canvas.height = h;

        var ctx = canvas.getContext('2d');
        ctx.drawImage(myimg, 0, 0, w, h);
        ctx.fillText("nf147", w - 20, h - 20);

        canvas.toBlob(taskCallback, "image/jpeg");
    }

    /**
     * 更新预览进度
     */
    function refreshProgress(r) {
        if (!ctx) ctx = mymask.getContext('2d');
        ctx.save();
        ctx.clearRect(0, 0, 200, 200);
        ctx.globalAlpha = 0.6;
        ctx.fillRect(0, (1 - r) * 200, 200, 200);
        ctx.globalAlpha = 1;
        ctx.fillStyle = "white";
        ctx.font = "20px 微软雅黑";
        ctx.textAlign = 'center';
        ctx.fillText(Math.round(r * 100) + '%', 100, 100);
        ctx.restore();
    }

    /**
     * 通过 AJAX 上传 blob 类型的文件
     * @param blob
     */
    function uploadWithAJAX(blob) {
        var fd = new FormData();
        fd.append("fff", blob);

        $.ajax({
            method: 'post',
            url: "/myupload",
            cache: false,
            contentType: false,
            data: fd,
            processData: false,
            xhr: () => {
                var xhr = $.ajaxSettings.xhr();
                xhr.upload.onprogress = (ev) => {
                    refreshProgress(ev.loaded / ev.total);
                };
                return xhr;
            }
        }).done(console.log)
            .fail((xhr, staus, err) => console.error(xhr, staus, err));
    }

    function uploadWithAxios(blob) {
        var fd = new FormData();
        fd.append("fff", blob);

        axios({
            method: 'post',
            url: '/myupload',
            data: fd,
            onUploadProgress: (ev) => refreshProgress(ev.loaded / ev.total),
        }).then(console.log).catch(console.error);
    }

</script>


<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
        integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
        crossorigin="anonymous"></script>
</body>
</html>