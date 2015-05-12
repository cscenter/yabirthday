$('document').ready(function() {
    $('#loghide').hide();
    $("#myModal").modal('show');
    $("input").keypress(function(event) {
        if (event.which == 13) {
            event.preventDefault();
            //$("form").submit();

			if ($('input').val() == 'Hello') {
                $("#myModal").modal('hide');
                $('#loghide').show();
            }
            else {
                alert('Wrong!');
            }
        }
    });

    function loadAll(login) {
        $.get("/api/user/" + login, function(data) {
            //UserPageDTO
            var user = data.user; //UserDTO user
            var cash = data.cash; //CashDTO cash
            var accounts = data.userAccs; //List<AccountDTO> userAccs
            var transactions = data.transactions; //List<TransactionDTO> transactions
            var friends = data.friends; //List<UserDTO> friends
            var gifts = data.gifts; //List<GiftDTO> gifts

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

            var cur_cash = 0;
            for (var k = 0; k < accounts.length; k++) {
                cur_cash += accounts[k].funds;
            }
            $("#money").html("Баланс: " + cur_cash + " ₽");
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
            loadAll(login);
        }
        else {
            alert('Wrong!');
        }
    });
})

