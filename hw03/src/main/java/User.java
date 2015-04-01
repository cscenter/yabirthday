/**
 * Created by Rafa on 31.03.2015.
 */

import javax.persistence.*;

@Entity
@Table(name = "birthdays")
public class User  implements java.io.Serializable {
    @Id// (name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true) //  nullable = false
    private long userId;

    @Column(name = "name")
    private String userName;

    @Column(name = "birthday")
    private String userBirthday;

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserBirthday(String birthday) {
        this.userBirthday = birthday;
    }
    public  String getUserBirthday() {
        return  userBirthday;
    }
}
