<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .error {
            color: red;
        }
    </style>

</head>
<body>


<div style="color: red">
    <c:forEach items="${errs}" var="err">
        <div>${err}</div>
    </c:forEach>
</div>

<form:form action="/book" method="post" modelAttribute="book">
    <div>
        <form:input path="name" />
        <form:errors path="name" />
    </div>
    <div>
        <form:input path="price" />
        <form:errors path="price" />
    </div>

    <input type="file" name="ufile" />
    <input type="submit"/>
</form:form>

<script>

</script>

</body>
</html>
