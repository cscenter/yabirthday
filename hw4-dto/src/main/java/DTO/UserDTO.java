package DTO;

import java.util.List;

/**
 * Created by olya on 15.04.15.
 */
public class UserDTO {
    FriendDTO user;
    CashDTO cash;
    List<AccountDTO> userAccs;
    //List<AccountDTO> investorsAccs; //не храним, кто скидывается этому человеку, так как это секрет
    List<GiftDTO> giftsOwned;
}
