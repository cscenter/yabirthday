/**
 * Created by Rafa on 31.03.2015.
 */

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "birthdays")
public class User  implements java.io.Serializable {
    @Id// (name = "id")
   // @ManyToMany
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") //  nullable = false
    private Integer userId;

    @Column(name = "name")
    private String userName;

    @Column(name = "birthday")
    private Date userBirthday;

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserBirthday(Date birthday) {
        this.userBirthday = birthday;
    }
    public Date  getUserBirthday() {
        return  userBirthday;
    }
}
