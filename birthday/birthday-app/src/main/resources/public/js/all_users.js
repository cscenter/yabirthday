/**
 * Created by olya on 12.05.15.
 */

$(function() {
    $("#money").html("Баланс: " + getCookie(uMoney) + " ₽");
    $("#user-name").html(getCookie(uName) + "<span class=\"caret\"></span>");
    load_data("/api/user/users");


    $("#my-input").keyup(function() {
        $("#users-views").html("");
        var part = document.getElementById("my-input").value;
        if (part == "") {
            part = "users";
        }
        else {
            part = "search/" + part;
        }
        load_data("/api/user/" + part);
    });

    function load_data(path) {
        $.get(path, function(data) {
            for (var k = 0; k < data.length; k++) {
                var user = data[k];
                $("#users-views").append(
                    "<div class=\"col-md-3\">" +
                    "<div class=\"panel panel-default\">" +
                    "<div class=\"panel-heading\">" +
                    "<div class=\"pull-right btn-group btn-group-xs\" role=\"group\">" +
                    "<button type=\"button\" class=\"btn btn-success\"><span class=\"glyphicon glyphicon-plus\"></span></button>" +
                    "</div><div class=\"panel-title\">" + user.login + "</div>" +
                    "</div><div class=\"panel-body\">" +
                    "<h6 class=\"label label-info\">" + user.group.name + "</h6> " +
                    "<h6 class=\"label label-info\">" + user.birthday + "</h6>" +
                    "</div></div></div>");
            }
        });
    }
});