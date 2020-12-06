<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 28.11.2020
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Sprzęt do umowy</title>
</head>
<body>
<p>DODAJ SPRZĘT</p>
<form:form modelAttribute="borrowedEquipment" method="post" action="/contract/addEquipment">
    <form:hidden path="id"/>

    <form:label path="borrowedFromString">Będzie wypożyczony od</form:label>
    <form:input type="datetime-local" path="borrowedFromString"/>
    <form:errors path="borrowedToString" cssClass="error"/><br>

    <form:label path="borrowedToString">Będzie wypożyczony do</form:label>
    <form:input type="datetime-local" path="borrowedToString"/>
    <form:errors path="borrowedToString" cssClass="error"/><br>

    <form:label path="equipment">Sprzęt</form:label>
    <form:select path="equipment" items="${availableEquipment}" itemLabel="fullInfo" itemValue="id"/>
    <form:errors path="equipment" cssClass="error"/><br>
    <button type="submit">Dodaj Sprzęt</button>
</form:form><br>
<a href="/contract/createCopyOfContract">Koniec zamówienia</a>
</body>
</html>
