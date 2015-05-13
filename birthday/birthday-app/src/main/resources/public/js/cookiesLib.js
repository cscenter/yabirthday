/**
 * Created by olya on 13.05.15.
 */
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
    var name = uName;
    //alert("lol");
    document.cookie = name + '=; expires=Thu, 01 Jan 1970 00:00:01 GMT;';
}

