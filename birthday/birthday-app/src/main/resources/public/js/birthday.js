$(function() {
    $.get("/api/user/main", function(data) {
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
});