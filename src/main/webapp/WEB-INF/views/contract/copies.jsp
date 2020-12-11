<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 05.12.2020
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Kopie umów</title>
</head>
<body>

<c:forEach items="${copies}" var="copy">
    <table>
        <thead>
        <td>Numer</td>
        <td>Pracownik</td>
        <td>Klient</td>
        <td>Należność</td>
        </thead>
        <tbody>
        <tr>
            <td>${copy.contractNumber}</td>
            <td>${copy.employee}</td>
            <td>${copy.customer}</td>
            <td>${copy.profit}</td>
        </tr>
        </tbody>
    </table>
    <table>
        <thead>
        <td>Szczegóły</td>
        </thead>
        <tbody>
        <tr>
            <td>${copy.borrowDetails}</td>
        </tr>
        </tbody>
    </table>
    <br><br>
</c:forEach>
<a href="/">Powrót do menu</a>
</body>
</html>
