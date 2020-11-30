<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 29.11.2020
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Ceny dla tego produktu</title>
</head>
<body>
<table>
    <thead>
    <td>Cena do 2 godzin</td>
    <td>Cena od 2 do 5 godzin</td>
    <td>Cena od 5 do 24 godzin</td>
    <td>Cena od 24 do 48 godzin</td>
    <td>Edytuj ceny</td>
    </thead>
    <tbody>
    <tr>
        <td><c:out value="${catalogPrice.priceFor2Hours}"/></td>
        <td><c:out value="${catalogPrice.priceFor2To5Hours}"/></td>
        <td><c:out value="${catalogPrice.priceFor5To24Hours}"/></td>
        <td><c:out value="${catalogPrice.priceFor2Days}"/></td>
        <td><a href="/equipment/editPrices/${catalogPrice.id}">Edytuj</a> </td>
    </tr>
    </tbody>
</table>
<a href="/">Powrót do menu</a>
</body>
</html>
