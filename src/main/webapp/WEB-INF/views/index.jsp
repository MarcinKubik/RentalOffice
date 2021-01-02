<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 19.11.2020
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>STRONA STARTOWA WYPOŻYCZALNI</title>
    <style>
        .item{
            font-family: arial;
            text-decoration: none;
            color: #2C3E50;
        }

        .item:hover{
            color: #3788d8;
        }
        .content {
            display: flex;
            width: 100vw;
            height: 100vh;
            justify-content: center;
            align-items: center;
        }
    </style>
</head>
<body>
<div class="content">
    <div class="center">
        <p><a href="/equipment/list" class="item">OFERTA</a></p>
        <p><a href="/equipment/borrowedList">SPRZĘT WYPOŻYCZONY</a></p>
        <p><a href="/equipment/form">DODAJ SPRZĘT</a></p>
        <p><a href="/customer/list">KLIENCI</a> </p>
        <p><a href="/customer/form">DODAJ KLIENTA</a></p>
        <p><a href="/contract/list">UMOWY</a></p>
        <p><a href="/contract/copies">KOPIE UMÓW</a> </p>
        <p><a href="/contract/form">DODAJ UMOWĘ</a></p>
        <p><a href="/employee/list">PRACOWNICY</a></p>
        <p><a href="/employee/form">DODAJ PRACOWNIKA</a></p>
        <p><a href="/employee/addFirstEmployee">DODAJ PIERWSZEGO PRACOWNIKA</a></p>
        <p><a href="/calendar">KALENDARZ</a></p>

        <%--<p><a href="">KONTAKT Z KLIENTEM</a></p>--%>
        <form action="/logout" method="post">
            <input class="fa fa-id-badge" type="submit" value="Wyloguj">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </div>

</div>


</body>
</html>
