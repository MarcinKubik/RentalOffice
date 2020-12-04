<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 04.12.2020
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Logowanie</title>
</head>
<body>
<form method="post">
    <label>
        Login
        <input type="text" name="login">
    </label>
    <label>
        <input type="password" name="password">
    </label>
    <input type="submit" value="Zaloguj">
    <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
</form>
</body>
</html>
