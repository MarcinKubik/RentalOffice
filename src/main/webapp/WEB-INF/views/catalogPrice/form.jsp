<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 27.11.2020
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Ceny katalogowe</title>
    <style>
        .error{
            color: red;
        }
    </style>
</head>
<body>
<p>DODAJ ZESTAW CEN DLA TEGO PRODUKTU</p>
<form:form modelAttribute="catalogPrice" action="/equipment/addPrices" method="post">
    <form:hidden path="id"/>

    <form:label path="priceFor2Hours">Cena do dwóch godzin</form:label>
    <form:input path="priceFor2Hours"/>
    <form:errors path="priceFor2Hours" cssClass="error"/><br>

    <form:label path="priceFor2To5Hours">Cena od dwóch do 5 godzin</form:label>
    <form:input path="priceFor2To5Hours"/>
    <form:errors path="priceFor2To5Hours" cssClass="error"/><br>

    <form:label path="priceFor5To24Hours">Cena od 5 do 24 godzin</form:label>
    <form:input path="priceFor5To24Hours"/>
    <form:errors path="priceFor5To24Hours" cssClass="error"/><br>

    <form:label path="priceFor2Days">Cena do dwóch dni</form:label>
    <form:input path="priceFor2Days"/>
    <form:errors path="priceFor2Days" cssClass="error"/><br>

    <button type="submit">Wyślij</button>
</form:form>
</body>
</html>
