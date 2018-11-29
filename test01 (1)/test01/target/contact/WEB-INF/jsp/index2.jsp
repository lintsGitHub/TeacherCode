<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form action="/emp2" method="post" id="myform" modelAttribute="formBean">
    <div style="color: red">
        :<form:errors path="*" />
    </div>
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
        <td><form:input type='text' path='eId'/></td>
        <td><form:input type='text' path='eName' /></td>
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
        <td><form:input type='text' path='eSalary'/></td>
        <td><input type='button' class='add' value='  +  '/></td>
        <td><input type='button' class='del' value='  -  '/></td>
    </tr>
    </tbody>
</table>
</form:form>


<input type="button" id="btn_add" onclick="doSubmit()" value="批量添加">

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
            <td><a href="/emp2/del/${e.eId}">删除</a></td>
        </tr>
    </c:forEach>
</table>

<script src="../js/jquery.js"></script>
<script>
    function doSubmit() {
        var rows = $("#tbody1 tr");

        rows.each(function (i, e) {
            $("input:text, select", e).each(function (ii, ee) {
                $(ee).attr("name", "emps[" + i + "]." + $(ee).attr("name"));
            });
        });
        myform.submit();
    }

    $(function () {
        var tbody = $("#tbody1");

        trNode = tbody.find("tr").clone();

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


</script>
</body>
</html>
