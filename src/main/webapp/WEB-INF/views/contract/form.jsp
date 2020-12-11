<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 21.11.2020
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dodaj umowę</title>
    <style>
        .error{
            color: red;
        }
    </style>
</head>
<body>
<form:form modelAttribute="contract"  method="post" action="/contract/form">
    <form:hidden path="id"/>

    <%--dodać jeśli zmienię format numeru umowy--%>
    <%--<form:label path="contractNumber">Numer umowy:</form:label>
    <form:input path="contractNumber"/>
    <form:errors path="contractNumber" cssClass="error"/><br>--%>

    <form:hidden path="employee" value="${employee}"/>
    <p>Pracownik <c:out value="${employee.fullName}"/></p>

    <form:label path="customer">Klient:</form:label>
    <form:select path="customer" items="${customers}" itemLabel="fullName" itemValue="id" />
    <form:errors path="customer" cssClass="error"/><br>
    <button type="submit">Wyślij</button>
</form:form>
<a href="/">Powrót do menu</a>
</body>
</html>
