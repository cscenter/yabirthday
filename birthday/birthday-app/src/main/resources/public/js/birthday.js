$(function() {
    $.get("/api/user", function(data) {
        for (var i = 0; i < data.length; i++) {
            var user = data[i];
            $("#user-table").find("> tbody").append(
                "<tr class=\"alert-danger\">" +
                "<td><a href=\"#\">" + user.login + "</a></td>" +
                "<td>" + user.birthday +"</td>" +
                "</tr>"
            );
        }

        $("#ololo").html("");
    });
});