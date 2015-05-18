function getUserData2(login) {
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
    return JSON.parse(result)["friends"];
}


function addFriend(name) {
    alert("add friend: " + name);
    var button = document.getElementById(name);
    button.innerHTML  = "<span class=\"glyphicon glyphicon-minus\">";
    button.onclick =  function() { delFriend(name); };
    button.className = "btn btn-danger";

    // send request to server
}

function delFriend(name) {
    alert("delete friend: " + name);
    var button = document.getElementById(name);
    button.innerHTML  = "<span class=\"glyphicon glyphicon-plus\">";
    button.onclick =  function() { addFriend(name); };
    button.className = "btn btn-success";

    // send request to server
}

function isFriend(userName, friendList) {
    for(var i in friendList){
        if (friendList[i]["login"] == userName) {
            return true;
        }
    }
    return false;
}

function getFriends(userName) {
    var data  = getUserData2(userName);
    return data;
}

