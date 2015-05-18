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
            var hozain = getCookie(uName);
            var friends = getFriends(hozain);
            for (var k = 0; k < data.length; k++) {
                var user = data[k];

                var button = "";
                var uId = user.login;
                if (isFriend( user.login, friends)){ // hozain --> user.login
                    var actionDel = "\"delFriend('" + user.login + "')\"";
                    button = "<button id=\"" + uId + "\" type=\"button\" onclick= " +
                        actionDel +
                        "class=\"btn btn-danger\"><span class=\"glyphicon glyphicon-minus\"></span></button>";
                }else {
                    var actionAdd = "\"addFriend('" + user.login + "')\"";
                    button = "<button id=\"" + uId + "\" type=\"button\" onclick= " +
                        actionAdd +
                        " class=\"btn btn-success\"><span class=\"glyphicon glyphicon-plus\"></span></button>";
                }
                if(user.login == hozain) {
                    button = "";
                }
                $("#users-views").append(
                    "<div class=\"col-md-3\">" +
                    "<div class=\"panel panel-default\">" +
                    "<div class=\"panel-heading\">" +
                    "<div class=\"pull-right btn-group btn-group-xs\" role=\"group\">" +
                    button +
                    "</div><div class=\"panel-title\">" + user.login + "</div>" +
                    "</div><div class=\"panel-body\">" +
                    "<h6 class=\"label label-info\">" + user.group.name + "</h6> " +
                    "<h6 class=\"label label-info\">" + user.birthday + "</h6>" +
                    "</div></div></div>");
            }
        });
    }
});