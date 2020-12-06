<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 06.12.2020
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edycja klienta</title>
</head>
<body>
<form:form modelAttribute="customer" method="post" action="/customer/form">
    <form:hidden path="id"/>

    <form:label path="name">Imię:</form:label>
    <form:input path="name"/>
    <form:errors path="name" cssClass="error"/><br>

    <form:label path="surname">Nazwisko:</form:label>
    <form:input path="surname"/>
    <form:errors path="surname" cssClass="error"/><br>

    <form:label path="email">Email:</form:label>
    <form:input path="email"/>
    <form:errors path="email" cssClass="error"/><br>

    <form:label path="phoneNumber">Numer telefonu:</form:label>
    <form:input path="phoneNumber"/>
    <form:errors path="phoneNumber" cssClass="error"/><br>

    <form:label path="city">Miejscowość:</form:label>
    <form:input path="city"/>
    <form:errors path="city" cssClass="error"/><br>

    <form:label path="street">Ulica:</form:label>
    <form:input path="street"/>
    <form:errors path="street" cssClass="error"/><br>

    <form:label path="number">Numer mieszkania:</form:label>
    <form:input path="number"/>
    <form:errors path="number" cssClass="error"/><br>

    <button type="submit">Wyślij</button>
</form:form>
<a href="/">Powrót do menu</a>
</body>
</html>
