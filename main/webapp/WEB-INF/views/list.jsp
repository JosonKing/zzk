<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: root5
  Date: 2017/8/23
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>employee list</title>
</head>
<body>
<table border="1" cellspacing="0" cellpadding="10">
    <tr>
        <th>ID</th>
        <th>LastName</th>
        <th>Email</th>
    </tr>

    <c:forEach items="${employees}" var="emp">
        <tr>
            <th>${emp.id}</th>
            <th>${emp.lastName}</th>
            <th>${emp.email}</th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
