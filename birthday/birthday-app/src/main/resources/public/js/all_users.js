/**
 * Created by olya on 12.05.15.
 */

const friend = 0;
const i_am = 1;
const non_friend = 2;

function addFriend(name) {
    //alert("add friend: " + name);
    var button = document.getElementById(name);
    button.innerHTML  = "<span class=\"glyphicon glyphicon-minus\">";
    button.onclick =  function() { delFriend(name); };
    button.className = "btn btn-danger";

    // send request to server
}

function delFriend(name) {
    //alert("delete friend: " + name);
    var button = document.getElementById(name);
    button.innerHTML  = "<span class=\"glyphicon glyphicon-plus\">";
    button.onclick =  function() { addFriend(name); };
    button.className = "btn btn-success";

    // send request to server
}


$(function() {
    //$("#money").html("Баланс: " + getCookie(uMoney) + " ₽");
    //$("#money-name").html("Баланс: " + getCookie(uMoney)/*user_money*/ + " ₽" + "<span class=\"caret\"></span>");
    $("#user-name").html(getCookie(uName) + "<span class=\"caret\"></span>");
    load_data("/api/friend/" + getCookie(uName));

    $("#my-input").keyup(function() {
        $("#users-views").html("");
        var part = getCookie(uName) + "/" + document.getElementById("my-input").value;
        load_data("/api/friend/" + part);
    });

    function load_data(path) {
        $.get(path, function(data) {
            $("#money-name").html("Баланс: " + data.money + " ₽" + "<span class=\"caret\"></span>");

            var userAccs = data.userAccs;
            for (var k = 0; k < userAccs.length; k++) {
                var acc = userAccs[k];
                //alert(acc.funds);
                $("#cur-money").append("<li><a>" + acc.funds + " ₽, " + "кассир: " + acc.cash.owner.login + "</a></li>");
            }

            data = data.users;
            for (var k = 0; k < data.length; k++) {
                var user = data[k];
                var button = "";
                var uId = user.user.login;
                if (user.status == friend){
                    var actionDel = "\"delFriend('" + uId + "')\"";
                    button = "<button id=\"" + uId + "\" type=\"button\" onclick= " +
                        actionDel +
                        "class=\"btn btn-danger\"><span class=\"glyphicon glyphicon-minus\"></span></button>";
                } else if (user.status == non_friend) {
                    var actionAdd = "\"addFriend('" + uId + "')\"";
                    button = "<button id=\"" + uId + "\" type=\"button\" onclick= " +
                        actionAdd +
                        " class=\"btn btn-success\"><span class=\"glyphicon glyphicon-plus\"></span></button>";
                }
                else {
                    button = "";
                }
                $("#users-views").append(
                    "<div class=\"col-md-3\">" +
                    "<div class=\"panel panel-default\">" +
                    "<div class=\"panel-heading\">" +
                    "<div class=\"pull-right btn-group btn-group-xs\" role=\"group\">" +
                    button +
                    "</div><div class=\"panel-title\">" + user.user.login + "</div>" +
                    "</div><div class=\"panel-body\">" +
                    "<h6 class=\"label label-info\">" + user.user.group.name + "</h6> " +
                    "<h6 class=\"label label-info\">" + user.user.birthday + "</h6>" +
                    "</div></div></div>");
            }
        });
    }
});