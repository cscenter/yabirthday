package DTO;

import java.util.List;

/**
 * Created by olya on 15.04.15.
 */
public class UserPageDTO {
    private final UserDTO user;
    private final CashDTO cash;
    private final List<AccountDTO> userAccs;
    private final List<GiftDTO> giftsOwned;

    public UserPageDTO(UserDTO user, CashDTO cash, List<AccountDTO> userAccs, List<GiftDTO> giftsOwned) {
        this.user = user;
        this.cash = cash;
        this.userAccs = userAccs;
        this.giftsOwned = giftsOwned;
    }

    public UserDTO getUser() {
        return user;
    }

    public CashDTO getCash() {
        return cash;
    }

    public List<AccountDTO> getUserAccs() {
        return userAccs;
    }

    public List<GiftDTO> getGiftsOwned() {
        return giftsOwned;
    }
}
