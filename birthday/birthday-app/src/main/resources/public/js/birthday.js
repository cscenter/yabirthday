$(function() {
    $.get("/api/user", function(data) {
        //UserPageDTO(UserDTO user, CashDTO cash, List<AccountDTO> userAccs, List<GiftDTO> giftsOwned) {
        var user = data.user;
        var cash = data.cash;
        var acc_list = data.userAccs;
        var gift_list = data.giftsOwned;

        for (var k = 0; k < gift_list.length; k++) {
            var gift = gift_list[k];
            $("#gift-table").find("> tbody").append(
                "<tr>" +
                "<td><a href=\"#\">" + gift.name + "</a></td>" +
                "<td>" + "мы лохи" + "</td>" +
                "</tr>"
            );
        }

        /*
         <tr>
         <td>MP3-плеер</td>
         <td>02/05/015</td>
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