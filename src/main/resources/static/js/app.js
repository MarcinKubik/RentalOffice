data = [ {
    title: 'Conference',
    start: '2020-12-15',
    end: '2020-12-17'
},
    {
        title: 'Long Event',
        start: '2020-12-15',
        end: '2020-12-17'
    }];


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