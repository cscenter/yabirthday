package DTO;

/**
 * Created by olya on 15.04.15.
 */
public class AccountDTO {
    long id;
    FriendDTO owner;
    CashDTO cash;
    int funds;
    //List<FriendDTO> receivers; по-моему, это лишнее тут
}
