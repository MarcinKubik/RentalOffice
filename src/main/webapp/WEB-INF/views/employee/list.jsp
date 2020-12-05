<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 05.12.2020
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Pracownicy</title>
</head>
<body>
<table>
    <thead>
    <td>Imię i nazwisko</td>
    </thead>
    <tbody>
    <c:forEach items="${employeeList}" var="employee">
        <tr>
            <td>${employee.fullName}</td>
            <td><a href="/employee/delete/${employee.id}">Usuń</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/">Powrót do menu</a>
</body>
</html>
