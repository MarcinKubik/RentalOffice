<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 27.11.2020
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Dodaj nowy sprzęt</title>
</head>
<body>
<form:form modelAttribute="equipment" method="post" action="/equipment/form">
    <form:hidden path="id"/>

    <form:hidden path="available" value="true"/>

    <form:label path="name">Nazwa</form:label>
    <form:input path="name"/>
    <form:errors path="name" cssClass="error"/><br>


    <form:label path="value">Wartość</form:label>
    <form:input path="value"/>
    <form:errors path="value" cssClass="error"/><br>

    <form:label path="description">Opis</form:label>
    <form:input  path="description"/>
    <form:errors path="description" cssClass="error"/><br>

    <form:label path="producent">Producent</form:label>
    <form:input path="producent"/>
    <form:errors path="producent" cssClass="error"/><br>

    <button type="submit">Wyślij</button>
</form:form>
</body>
</html>
