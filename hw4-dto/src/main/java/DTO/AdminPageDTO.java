package DTO;

import java.util.List;

/**
 * Created by olya on 15.04.15.
 */
public class AdminPageDTO {
    private final CashDTO cash;
    private final List<AccountDTO> accs;
    private final List<GiftDTO> gifts;

    public AdminPageDTO(CashDTO cash, List<AccountDTO> accs, List<GiftDTO> gifts) {
        this.cash = cash;
        this.accs = accs;
        this.gifts = gifts;
    }

    public CashDTO getCash() {
        return cash;
    }

    public List<AccountDTO> getAccs() {
        return accs;
    }

    public  List<GiftDTO> getGifts() {
        return gifts;
    }
}
