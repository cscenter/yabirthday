$('document').ready(
    function() {
        if (getCookie(uName) == null) {
            $('.container').hide();
            $("#myModal").modal('show');
        } else {
            loadAll(getUserData(getCookie(uName)));
        }

        function loadAll(data) {
                var user = data.user; //UserDTO user
                var userAccs = data.userAccs;
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
                    var gift = transaction.destination;
                    var gift_name;
                    var gift_owner;
                    var gift_price;
                    if (gift == null) {
                        gift_name = "";
                        gift_owner = "";
                        gift_price = "+" + transaction.sum;
                    }
                    else {
                        gift_name = gift.name;
                        gift_owner = gift.owner.login;
                        gift_price = "-" + transaction.sum;
                    }
                    $("#transaction-table").find("> tbody").append(
                        "<tr>" +
                        "<td>" + transaction.date + "</td>" +
                        "<td>" + gift_price + " ₽" + "</td>" +
                        "<td>" + gift_name + "</td>" +
                        "<td><a href=\"#\">" + gift_owner + "</a></td>" +
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
                //$("#money").html("Баланс: " + user_money + " ₽");
                $("#money-name").html("Баланс: " + user_money + " ₽" + "<span class=\"caret\"></span>");
                setCookie(uMoney, user_money);

            for (var k = 0; k < userAccs.length; k++) {
                var acc = userAccs[k];
                //alert(acc.funds);
                $("#cur-money").append("<li><a>" + acc.funds + " ₽, " + "кассир: " + acc.cash.owner.login + "</a></li>");
            }

        }

        function getUserData(login) {
            var result = null;
            var scriptUrl = "/api/user/" + login;
            $.ajax({
                url: scriptUrl,
                type: 'get',
                dataType: 'html',
                async: false,
                success: function (data) {
                    result = data;
                }
            });
            if (result == null) {
                return null;
            }
            return JSON.parse(result);
        }

        $("#myModal button").click(function(event) {
            var login = $('input').val();
            var ans = getUserData(login);
            if (ans != null) {
                $("#myModal").modal('hide');
                $('.container').show();
                setCookie(uName, login);
                loadAll(ans);
            }
            else {
                alert('No such user. Try again');
            }
        });
    });