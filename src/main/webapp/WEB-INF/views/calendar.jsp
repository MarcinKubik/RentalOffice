<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Kalendarz</title>
    <meta charset='utf-8' />
    <link rel="stylesheet" href='https://cdn.jsdelivr.net/npm/fullcalendar@5.4.0/main.min.css' />
    <script src='https://cdn.jsdelivr.net/npm/fullcalendar@5.4.0/main.min.js'></script>
    <script>
        data = [
           /* {
            title: 'Conference',
            start: '2020-12-15',
            end: '2020-12-17'
        },
            {
                title: 'Long Event',
                start: '2020-12-15',
                end: '2020-12-17'
            }*/
            ];
        <c:forEach items="${stillBorrowedEquipment}" var="equipment">
        var event = {
            title: '${equipment.equipment.name}',
            start: '${equipment.borrowedFrom}',
            end: '${equipment.borrowedTo}'
        }
        data.push(event);
        </c:forEach>

        function draw(data) {
            var calendarEl = document.getElementById('calendar');
            var calendar = new FullCalendar.Calendar(calendarEl, {
                initialView: 'dayGridMonth',
                initialDate: Date.now(),
                headerToolbar: {
                    left: 'prev,next today',
                    center: 'title',
                    right: 'dayGridMonth,timeGridWeek,timeGridDay'
                },
                events: data
            });
            calendar.render();
        }

        document.addEventListener("DOMContentLoaded", evt => draw(data));
    </script>

</head>
<body>
<div id='calendar'></div>
<a href="/">Powrót do menu</a>
</body>
</html>
