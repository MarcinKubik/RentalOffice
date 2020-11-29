<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 27.11.2020
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sprzęt</title>
</head>
<body>
<table>
    <thead>
    <td>Nazwa</td>
    <td>Wartość</td>
    <td>Opis</td>
    <td>Producent</td>
    <td>Lista cen</td>
    </thead>
    <tbody>
    <c:forEach items="${equipmentList}" var="equipment">
        <tr>
            <td>${equipment.name}</td>
            <td>${equipment.value}</td>
            <td>${equipment.description}</td>
            <td>${equipment.producent}</td>
            <td><a href="/equipment/prices/${equipment.catalogPrice.id}">Pokaż ceny dla tego produktu</a> </td><%--dodać listę!--%>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
