package com.company;

import DTO.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by olya on 15.04.15.
 */
public class TempDB {
    private static Calendar bday;
    private static UserDTO user, admin;
    private static CashDTO cash;
    private static AccountDTO userAcc;
    private static List<AccountDTO> accs;
    private static GiftDTO gift;
    private static List<GiftDTO> gifts;
    private static UserPageDTO page;


    public static void init() {
        bday = Calendar.getInstance();
        user = new UserDTO("olya", bday);
        admin = new UserDTO("sergey", bday);
        cash = new CashDTO(42, admin);
        userAcc = new AccountDTO(123, user, cash, 150);
        accs = new ArrayList();
        accs.add(userAcc);
        gift = new GiftDTO(13, user, 200, "flowers");
        gifts = new ArrayList();
        gifts.add(gift);

        page = new UserPageDTO(user, cash, accs, gifts);
    }

    public static UserPageDTO getPage() {
        return page;
    }

    public static UserDTO getUser() {
        return user;
    }

}
