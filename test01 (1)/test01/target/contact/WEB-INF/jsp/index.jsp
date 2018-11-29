<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>员工编号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>学历</th>
        <th>月薪</th>
        <th>增加</th>
        <th>移除</th>
    </tr>
    </thead>
    <tbody id="tbody1">
    <tr>
        <td><input type='text' name='eId'/></td>
        <td><input type='text' name='eName'/></td>
        <td>
            <select name='eSex'>
                <option value='男'>男</option>
                <option value='女'>女</option>
            </select>
        </td>
        <td><select name='eXueli'>
            <option value='大专'>大专</option>
            <option value='中专'>中专</option>
            <option value='博士'>博士</option>
        </select></td>
        <td><input type='text' name='eSalary'/></td>
        <td><input type='button' class='add' value='  +  '/></td>
        <td><input type='button' class='del' value='  -  '/></td>
    </tr>
    </tbody>
</table>
<p></p>
<input type="button" id="btn_add" value="批量添加">
<table>
    <tr>
        <th>员工编号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>学历</th>
        <th>月薪</th>
        <th>操作</th>
    </tr>
    <c:forEach var="e" items="${empList}">
        <tr>
            <td> ${e.eId} </td>
            <td> ${e.eName} </td>
            <td> ${e.eSex} </td>
            <td> ${e.eXueli} </td>
            <td> ${e.eSalary} </td>
            <td><a href="/em/del/${e.eId}">删除</a></td>
        </tr>
    </c:forEach>
</table>

<script src="../js/jquery.js"></script>
<script>
    $(function () {
        var tbody = $("#tbody1");

        trNode = tbody.clone();

        tbody.on("click", " .add", function () {
            $("#tbody1").append(trNode.clone());
        });

        tbody.on("click", ".del", function () {
            var del = $("tr", tbody).length;
            console.log(del);
            if (del === 1) {
                alert("兄弟不能再删了....!!!!");
                return false;
            }
            $(this).parent().parent().remove();
        })
    });

    $("#btn_add").click(function () {
        var data = [];
        $("#tbody1 tr").each(function (index, obj) {
            data.push(
                {
                    eId: $("input[name='eId']", obj).val(),
                    eName: $("input[name='eName']", obj).val(),
                    eSex: $("select[name='eSex']", obj).val(),
                    eXueli: $("select[name='eXueli']", obj).val(),
                    eSalary: $("input[name='eSalary']", obj).val()
                }
            )
        });

        $.post({
            url: "/em",
            contentType: "application/json;charset=utf-8",
            data: JSON.stringify(data)
        }).done(function (data) {
            if (data.msg === "ok") {
                alert("添加成功");
                window.location.href = "/em";
            }
            else {
                alert("添加失败");
            }
        }).fail(function (xhr, code, ex) {
            console.error(ex);
        });
    })

</script>
</body>
</html>
