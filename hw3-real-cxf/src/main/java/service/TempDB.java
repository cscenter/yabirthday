package service;

import domain.Cash;
import domain.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by olya on 05.04.15.
 */
public class TempDB {
    static List<User> users = new ArrayList<>();
    static Cash cash = new Cash();

    public static void init() {
        LocalDate b_day = LocalDate.of(1993, 11, 18);
        User u1 = new User("olya", b_day, cash);
        users.add(u1);
    }
}
