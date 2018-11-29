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
    <style>
        #preview {
            border: 3px solid gray;
            border-radius: 5px;
        }
    </style>
</head>
<body>


<div class="container">

    <div>
        <canvas id="preview" width="200" height="200">不支持canvas</canvas>
        <%--<img src="" id="myimg" title="暂时没有上传" width="200" height="200" />--%>
    </div>

    <div style="margin-top: 2em;">
        <input type="file" id="myfile" style="display: none"> <!-- 选择文件后，要预览 -->
        <button class="btn btn-primary" onclick="myfile.click()">选择图片</button>
        <button class="btn btn-primary" onclick="clickMe()">上传图片</button>
    </div>
</div>


<script>

    var ctx;

    myfile.onchange = () => {
        if (!ctx) {
            ctx = preview.getContext('2d');
        }
        ctx.clearRect(0, 0, 200, 200);
        loadImgFromFile(myfile.files[0]);
    };

    function loadImgFromFile(file, callback) {
        var imgUrl = URL.createObjectURL(file);
        var img = new Image();
        img.src = imgUrl;
        img.onload = (ev) => {
            ctx.drawImage(img, 0, 0, 200, 200);
            if (callback) callback();
            URL.revokeObjectURL(imgUrl);
        };
    }

    function clickMe() {
       // compressImgWithCanvas(myfile.files[0], uploadWithAJAX);
        uploadWithAJAX(myfile.files[0]);
    }

    /**
     * 压缩图片，然后执行某些任务
     */
    function compressImgWithCanvas(blob, taskCallback) {
        var image = new Image();
        var imgUrl = URL.createObjectURL(blob);
        image.src = imgUrl;
        image.onload = (ev)=> {
            URL.revokeObjectURL(imgUrl);

            var canvas = document.createElement("canvas");
            canvas.width = image.width / 2;
            canvas.height = image.height / 2;

            var ctx = canvas.getContext('2d');
            ctx.drawImage(image, 0, 0, image.width / 2, image.height / 2);
            ctx.fillText("nf147", image.width / 2 - 20, image.height / 2 - 20);
            canvas.toBlob(taskCallback, "image/jpeg");
        };
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
                    console.log("ksdjfksdf");
                        var loaded = ev.loaded;
                        var total = ev.total;
                        console.log("loaded", loaded);

                        ctx.clearRect(0, 0, 200, 200);
                        loadImgFromFile(myfile.files[0], () => {
                            var prog = (1-loaded / total);
                            console.log("prog", prog);
                            ctx.globalAlpha = 0.3;
                            ctx.fillRect(0, prog * 200, 200, 200);
                            ctx.save();
                            ctx.fillStyle = "white";
                            ctx.globalAlpha = 1;
                            ctx.font = "20px 微软雅黑";
                            ctx.fillText((loaded/total) * 100 + '%', 120, 120);
                            ctx.restore();
                        });
                };
                return xhr;
            }
        }).done(console.log)
            .fail((xhr, staus, err) => console.error(xhr, staus, err));

    }

</script>


<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
        integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
        crossorigin="anonymous"></script>
</body>
</html>