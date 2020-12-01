<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 29.11.2020
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Szczegóły umowy</title>
</head>
<body>
<table>
    <thead>
    <td>Wypożyczono od</td>
    <td>Wypożyczono do</td>
    <td>Sprzęt</td>
    </thead>
    <tbody>
    <c:forEach items="${borrowedEquipmentList}" var="borrowedEquipment">
        <tr>
            <td>${borrowedEquipment.borrowedFrom}</td>
            <td>${borrowedEquipment.borrowedTo}</td>
            <td>${borrowedEquipment.equipment.name}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/">Powrót do menu</a>
</body>
</html>
