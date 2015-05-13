const uName = "userName";
const uMoney = "userBalance";

function getCookie(name) {
    var matches = document.cookie.match(new RegExp(
        "(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"
    ));
    return matches ? decodeURIComponent(matches[1]) : null;
}

function setCookie(key,val) {
    document.cookie = key+ "=" + val;
}
function deleteCookie(name) {
    document.cookie = name + '=; expires=Thu, 01 Jan 1970 00:00:01 GMT;';
}

function deleteCookieAll() {
    //var name = uName;
    //alert("lol");
    //document.cookie = name + '=; expires=Thu, 01 Jan 1970 00:00:01 GMT;';
    deleteCookie(uName);
    deleteCookie(uMoney);
}

$('document').ready(function() {

    if(getCookie(uName) == null) {
        //alert("cook == null");
        $('#loghide').hide();
        $("#myModal").modal('show');
    } else {
        //alert("cook != null");
        loadAll(getCookie(uName));
    }

    function loadAll(login) {

        $.get("/api/user/" + login, function(data) {
            //UserPageDTO
            var user = data.user; //UserDTO user
            //var cash = data.cash; //CashDTO cash
            //var accounts = data.userAccs; //List<AccountDTO> userAccs
            var transactions = data.transactions; //List<TransactionDTO> transactions
            var friends = data.friends; //List<UserDTO> friends
            var gifts = data.gifts; //List<GiftDTO> gifts
            var user_money = data.money;

            for (var k = 0; k < friends.length; k++) {
                var friend = friends[k];
                $("#friend-table").find("> tbody").append(
                    "<tr>" +
                    "<td><a href=\"#\">" + friend.login + "</a></td>" +
                    "<td>" + friend.birthday + "</td>" +
                    "</tr>"
                );
            }

            for (var k = 0; k < transactions.length; k++) {
                var transaction = transactions[k];
                $("#transaction-table").find("> tbody").append(
                    "<tr>" +
                    "<td>" + transaction.date + "</td>" +
                    "<td>" + transaction.sum + " ₽" +  "</td>" +
                    "<td>" + transaction.destination.name + "</td>" +
                    "<td><a href=\"#\">" + transaction.destination.owner.login + "</a></td>" +
                    "</tr>"
                );
            }

            for (var k = 0; k < gifts.length; k++) {
                var gift = gifts[k];
                $("#gift-table").find("> tbody").append(
                    "<tr>" +
                    "<td>" + gift.name + "</td>" +
                    "</tr>"
                );
            }

            $("#user-name").html(user.login + "<span class=\"caret\"></span>");
            $("#money").html("Баланс: " + user_money + " ₽");
            setCookie(uMoney, user_money);
        });
    }

    //////////////  Ќажали на кнопку войти  ///////////////////
    function showGetResult( name ) //узнали существует ли така€ ручка (с таким логином) в базе
    {
        var result = null;
        var scriptUrl = "/api/user/" + name;
        $.ajax({ // по сути вытаскиваем всю json'ку но как проще € хз
            url: scriptUrl,
            type: 'get',
            dataType: 'html',
            async: false,
            success: function(data) {
                result = data;
            }
        });

        if (result == null){ return null;} // если null то все €сно
        var resjs = JSON.parse(result); // если нет то делаем из строки json объект и достаем логин юзера
        //alert("rjs = " + resjs.user.login);
        return resjs.user.login;
    }

    $("button").click(function(event) {

        var login = $('input').val();
        //alert(login);
        var ans =  showGetResult(login);
        //alert("ans: " + ans);  // по сути если не null значит валидный логин

        if (ans != null) {
            $("#myModal").modal('hide');
            $('#loghide').show();
            setCookie(uName, login);
            loadAll(login);
        }
        else {
            alert('Wrong!');
        }
    });


})

function loadAll42() {}
