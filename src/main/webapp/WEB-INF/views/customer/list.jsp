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
    <%--<td>Kontrakty (zrobić po id)</td>--%>
    </thead>
    <tbody>
    <c:forEach items="${customers}" var="customer">

    </c:forEach>
    </tbody>
</table>
</body>
</html>
