<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 25.11.2020
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Klienci</title>
</head>
<body>
<table>
    <thead>
    <td>Imię</td>
    <td>Nazwisko</td>
    <td>Email</td>
    <td>Numer telefonu</td>
    <td>Miasto</td>
    <td>Ulica</td>
    <td>Numer</td>
    <td>Umowy</td>
    <td>Edytuj klienta</td>
    </thead>
    <tbody>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td>${customer.name}</td>
            <td>${customer.surname}</td>
            <td>${customer.email}</td>
            <td>${customer.phoneNumber}</td>
            <td>${customer.city}</td>
            <td>${customer.street}</td>
            <td>${customer.number}</td>
            <td><a href="/customer/contracts/${customer.id}">Lista umów</a> </td>
            <td><a href="/customer/form/${customer.id}">Edytuj</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/">Powrót do menu</a>
</body>
</html>
