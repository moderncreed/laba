$(document).ready(function (){
    showStudents();
    showSubjects();
    showMarks();
});

function showMarks() {
    $.get('/ajax/get_mark', function (data){
        let table = "<table> <tr><th>Студент</th><th>Предмет</th><th>Часы</th><th>Оценка</th>"

        for (i = 0; i<data.length; i++){
            table = table + "<tr><td>" + data[i].student.name +"</td><td>" + data[i].subject.title +"</td><td>" + data[i].subject.time + "</td><td>" + data[i].mark +"</td></tr>";
        }
        table = table + "</table>";
        $("#test_mark").html(table);
        $("table").addClass("table")
    })
}

function showStudents() {
    $.get('/ajax/get_student', function (data) {
        console.log(data);

        let table = "<table> <tr><th>ИД</th><th>Имя</th><th>Средняя оценка</th></tr>";

        for (i = 0; i<data.length; i++){
            table = table + "<tr><td>" + data[i].id +"</td><td>" + data[i].name +"</td><td><a href='/main/id=" + data[i].id + "'>Средняя оценка</a></td></tr>";
        }
        table = table + "</table>";
        $("#test_student").html(table);
        $("table").addClass("table")
    })
}
function showSubjects() {
    $.get('/ajax/get_subject', function (data) {
        console.log(data);

        let table = "<table> <tr><th>Ид</th><th>Название</th><th>Часы</th></tr>";

        for (i = 0; i<data.length; i++){
            table = table + "<tr><td>" + data[i].id +"</td><td>" + data[i].title +"</td><td>" + data[i].time + "</td></tr>";
        }
        table = table + "</table>";
        $("#test_subject").html(table);
        $("table").addClass("table")
    })
}

function deleteBad() {
    $.ajax({
        url: "/ajax/delete",
        method: 'POST',
        cache: false,
        contentType: 'application/json',
        success: function () {
            showMarks()
            showStudents()
        }
    });
}

function changeMark() {
    $.ajax({
        url: "/ajax/change_mark",
        method: 'POST',
        cache: false,
        contentType: 'application/json',
        data: JSON.stringify({
            idStudent: $("#student").val(),
            idSubject: $("#subject").val(),
            mark: $("#mark").val()
        }),
        success: function () {
            showMarks()
        }
    });
}

function addMark() {
    $.ajax({
        url: "/ajax/add_mark",
        method: 'POST',
        cache: false,
        contentType: 'application/json',
        data: JSON.stringify({
            idStudent: $("#student").val(),
            idSubject: $("#subject").val(),
            mark: $("#mark").val()
        }),
        success: function () {
            showMarks()
        }

    });
}

function addStudent() {
    $.ajax({
        url: "/ajax/add_student",
        method: 'POST',
        cache: false,
        contentType: 'application/json',
        data: JSON.stringify({
            name: $("#name").val()
        }),
        success:function () {
            showStudents()
        }

    });
}

function addSubject() {
    $.ajax({
        url: "/ajax/add_subject",
        method: 'POST',
        cache: false,
        contentType: 'application/json',
        data: JSON.stringify({
            title: $("#title").val(),
            time: $("#time").val()
        }),
        success: function () {
            showSubjects();
        }
    });
}


