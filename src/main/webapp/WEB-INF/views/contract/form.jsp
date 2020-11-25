<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 21.11.2020
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Dodaj umowę</title>
</head>
<body>
<form:form modelAttribute="contract"  method="post" action="/contract/form">
    <form:hidden path="id"/>

    <form:label path="contractNumber">Numer umowy:</form:label>
    <form:input path="contractNumber"/>
    <form:errors path="contractNumber" cssClass="error"/><br>

    <form:hidden path="employee" items="${employee}"/>

    <form:label path="customer">Klient:</form:label>
    <form:select path="customer" items="${customers}" itemLabel="surname" itemValue="id" />
    <form:errors path="customer" cssClass="error"/><br>
    <button type="submit">Wyślij</button>
</form:form>
</body>
</html>
