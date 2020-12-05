<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 04.12.2020
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Dodaj administratora</title>
</head>
<body>
<form:form modelAttribute="employee" method="post">
    <form:hidden path="id"/>

    <form:label path="name">Imię</form:label>
    <form:input path="name"/>
    <form:errors path="name" cssClass="error"/><br>

    <form:label path="surname">Nazwisko</form:label>
    <form:input path="surname"/>
    <form:errors path="surname" cssClass="error"/><br>

    <form:label path="login">Login</form:label>
    <form:input path="login"/>
    <form:errors path="login" cssClass="error"/><br>

    <form:label path="password">Hasło</form:label>
    <form:input type="password" path="password"/>
    <form:errors path="password" cssClass="error"/><br>

    <button type="submit">Wyślij</button>
</form:form>
<a href="/">Powrót do menu</a>
</body>
</html>
