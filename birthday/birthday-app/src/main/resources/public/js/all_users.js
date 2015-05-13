/**
 * Created by olya on 12.05.15.
 */
var part;
$(function() {
    $.get("/api/user/users", function(data) {
        for (var k = 0; k < data.length; k++) {
            var user = data[k];
            $("#users-views").append(
                "<div class=\"col-md-4\">" +
                "<div class=\"panel panel-default\">" +
                "<div class=\"panel-body\">" +
                "<div class=\"media\">" +
                "<div class=\"media-body\">" +
                "<h4 class=\"media-heading\">" + user.login + "</h4>" +
                "<h6 class=\"label media-heading label-info\">" + user.group.name + "</h6>" +
                "<h6 class=\"label media-heading label-info\">" + user.birthday + "</h6><br>" +
                "</div></div></div></div></div>");
        }
    });

    $("#my-input").keyup(function() {
        $("#users-views").html("");
        var part = document.getElementById("my-input").value;
        if (part == "") {
            part = "users";
        }
        else {
            part = "search/" + part;
        }
        $.get("/api/user/" + part, function(data) {
            for (var k = 0; k < data.length; k++) {
                var user = data[k];
                $("#users-views").append(
                    "<div class=\"col-md-4\">" +
                    "<div class=\"panel panel-default\">" +
                    "<div class=\"panel-body\">" +
                    "<div class=\"media\">" +
                    "<div class=\"media-body\">" +
                    "<h4 class=\"media-heading\">" + user.login + "</h4>" +
                    "<h6 class=\"label media-heading label-info\">" + user.group.name + "</h6>" +
                    "<h6 class=\"label media-heading label-info\">" + user.birthday + "</h6><br>" +
                    "</div></div></div></div></div>");
            }
        });
    });
});
