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

    <form:label path="borrowedTo">Będzie wypożyczony do</form:label>
    <form:input path="borrowedTo"/>
    <form:errors path="borrowedTo" cssClass="error"/><br>

    <form:label path="equipment">Sprzęt</form:label>
    <form:select path="equipment" items="${availableEquipment}" itemLabel="name" itemValue="id"/>
    <form:errors path="equipment" cssClass="error"/>
    <button type="submit">Wyślij</button>
</form:form>
</body>
</html>
