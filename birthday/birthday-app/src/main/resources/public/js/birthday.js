$(function() {
    $.get("/api/user/main", function(data) {
        //UserPageDTO(UserDTO user, CashDTO cash, List<AccountDTO> userAccs, List<TransactionDTO> transactions, List<UserDTO> friends, List<GiftDTO> gifts)
        var user = data.user;
        var cash = data.cash;
        var accounts = data.userAccs;
        var transactions = data.transactions;
        var friends = data.friends;
        var gifts = data.gifts;

        for (var k = 0; k < friends.length; k++) {
            var friend = friends[k];
            $("#friend-table").find("> tbody").append(
                "<tr>" +
                "<td><a href=\"#\">" + friend.login + "</a></td>" +
                "<td>" + friend.birthday + "</td>" +
                "</tr>"
            );
        }

        /*
         <tr>
         <td>MP3-плеер</td>
         <td>02/05/015</td>

         </tr>
         <tr class="alert-danger">
         <td><a href="#">Артем Егоров</a></td>
         <td>02/05/2015</td>
         </tr>
         <tr>
         <td><a href="#">Анастасия Быкова</a></td>
         <td>15/05/2015</td>
         </tr>
         <tr>
         <td><a href="#">Олег Сабинин</a></td>
         <td>15/05/2015</td>
         </tr>


        for (var k = 0; k < user_list.length; j++) {
            var user = user_list[k];
            $("#user-table").find("> tbody").append(
                "<tr>" +
                "<td><a href=\"#\">" + user.login + "</a></td>" +
                "<td>" + user.birthday + "</td>" +
                "</tr>"
            );
        } */


       // $("#ololo").html("");
    });
	
});