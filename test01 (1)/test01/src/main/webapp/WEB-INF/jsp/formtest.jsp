<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <!-- js -->
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.bootcss.com/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>
    <div class="card" style="width: 20rem;">
      <div class="card-body">
        <h4 class="card-title">title</h4>
        <p class="card-text">text</p>
        <a href="#" class="btn btn-primary">button</a>
      </div>
    </div>


    <div class="container">
        <form>
            <div class="form-group row">
                <label for="inputName" class="col-sm-1-12 col-form-label">姓名</label>
                <div class="col-sm-1-12">
                    <input type="text"
                           class="form-control" name="inputName" id="inputName" placeholder="">
                </div>
            </div>
            <fieldset class="form-group row">
                <legend class="col-form-legend col-sm-1-12">Group name</legend>
                <div class="col-sm-2">

                </div>
            </fieldset>
            <div class="form-group row">
                <div class="offset-sm-2 col-sm-10">
                    <button type="submit" class="btn btn-primary">Action</button>
                </div>
            </div>
        </form>
    </div>


    <input type="file" id="myfile" />

<button onclick="test()">电击我测试</button>

<script>

    function urlparams_tesyt() {
        var params = new URLSearchParams();
        params.append("aaa", "2222");
        params.append("bbb", "3333");
        params.append("cccccc", "hello, no = &sksdfjteshudefuhao‘skdfj");
    }

    function formData_test() {
        // 1. 完全取代 form 表单
        // 2. 可以往里面添加文件
        var data = new FormData(document.querySelector("#myform"));
        data.append("aaa", "222");
        data.append("bbb", "333");
        data.append("ccc", "hello, no = &sksdfjteshudefuhao‘skdfj");
        data.append("ddd", document.querySelector("#myfile").files[0]);
        return data;
    }

    function test () {
        fetch("/formpost", {
            method: 'post',
            body: formData_test()
        }).then(resp => resp);
    }

    function jqueryTest() {
        $.ajax({
            url: '/formpost',
            method: 'post',
            data : formData_test(), // 如果这里是字符串，还则罢了，否则，他就要作了

        })
    }


</script>
    <input type="button" onclick="y()" value="按一下"/>

</body>
</html>
