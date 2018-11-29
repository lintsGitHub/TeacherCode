<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title><spring:message code="title" /></title>
    <link rel="stylesheet" href="<spring:theme code="main.style" />">

</head>
<body style="color: <spring:theme code="main.color" />; background: <spring:theme code="main.bgcolor" />;">

<h1>
    <spring:message code="global.greeting" arguments="${user}::~~~" argumentSeparator="::" />
</h1>

<div>
    <spring:message code="page.cl" />
    <br>
    <a href="/emp2/cl/zh">中文</a>
    <a href="/emp2/cl/en">English.</a>
    <a href="/emp2/cl/jp">小日本</a>
    <br><br>
</div>

<div>
    一键换肤:<br>
    <a href="/emp2/ct/boy">boy</a>
    <a href="/emp2/ct/girl">girl</a>
    <a href="/emp2/ct/default">默认</a>
    <br><br>
</div>

<form:form action="/emp2" method="post" id="myform" modelAttribute="formBean">
    <div style="color: red">
        <form:errors path="*" />
    </div>
<table>
    <thead>
    <tr>
        <th><spring:message code="user.id" /></th>
        <th><spring:message code="user.name" /></th>
        <th><spring:message code="user.sal" /></th>
    </tr>
    </thead>
    <tbody id="tbody1">
    <tr>
        <td><form:input type='text' path='emps[0].eId'/></td>
        <td><form:input type='text' path='emps[0].eName' /></td>
        <td><form:input type='text' path='emps[0].eSalary'/></td>
    </tr>
    <tr>
        <td><form:input type='text' path='emps[1].eId'/></td>
        <td><form:input type='text' path='emps[1].eName' /></td>
        <td><form:input type='text' path='emps[1].eSalary'/></td>
    </tr>
    </tbody>
</table>
<input type="submit" />
</form:form>


<script src="../js/jquery.js"></script>
<script>

</script>
</body>
</html>
