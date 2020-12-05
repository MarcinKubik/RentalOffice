<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 25.11.2020
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Lista umów</title>
</head>
<body>
<table>
    <thead>
    <td>Numer umowy</td>
    <td>Należność</td>
    <td>Pracownik</td>
    <td>Klient</td>
    <td>Szczegóły umowy</td>
    <td>Usuń umowę</td>
    </thead>
    <tbody>
    <c:forEach items="${contracts}" var="contract">
        <tr>
            <td>${contract.id}</td>
            <td>${contract.profit}</td>
            <td>${contract.employee.fullName}</td>
            <td>${contract.customer.fullName}</td>
            <td><a href="/contract/borrowedEquipment/${contract.id}">Szczegóły umowy</a></td>
            <td><a href="/contract/delete/${contract.id}">Usuń</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/">Powrót do menu</a>
</body>
</html>
