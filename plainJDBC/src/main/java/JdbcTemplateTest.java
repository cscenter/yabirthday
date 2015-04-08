/**
 * Created by Rafa on 07.04.2015.
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Map;

//import javax.activation.DataSource;

public class JdbcTemplateTest {

    private  ApplicationContext ctx = null;
    private JdbcTemplate template = null;
    private DataSource dataSource = null;

    public JdbcTemplateTest() {
        try {

            ctx = new ClassPathXmlApplicationContext("datasources-beans.xml");
            dataSource = ctx.getBean("dataSource",DataSource.class);
            // Instantiate the template with the datasource
            template = new JdbcTemplate((javax.sql.DataSource) dataSource);
        } catch (Exception e) {
            System.out.print("something wring");
            e.printStackTrace();
        }
    }

    public Map<String,Object> getTradeAsMap(){
        // note that we have hardcoded ID here!
        Map<String,Object> tradeAsMap =
                template.queryForMap("SELECT *  FROM  birthdays LIMIT 1");
        //System.out.println("Trades Map:"+tradeAsMap);
        return tradeAsMap;
    }

    public List<Map<String,Object>> getAllUsers(){
        List<Map<String,Object>> trades =
                template.queryForList("SELECT *  FROM  birthdays "); //WHERE  name ='Putin'
       // System.out.println("All Trades:"+trades);
        return trades;
    }
    public int getUsersCount(){
        //int numOfTrades = template.queryForInt("SELECT  count(*) FROM  birthdays");
        int numOfTrades =  template.queryForObject("SELECT  count(*) FROM  birthdays", Integer.class);
        return numOfTrades;
    }

    public  List<String> getByName(String name) {
        List<String> obg;
        obg = template.queryForList("select birthday from birthdays where name= ?",
                new Object[]{name}, String.class);

        return obg;
    }

    public User getMappedUser(String name){
        User user = template.queryForObject("select * from birthdays where  name = ?",
                new Object[]{name} ,
                new UserMapper());
        return user;
    }

    public List<User> getAllMappedUesrs(){
        List<User> users =
                template.query("select * from birthdays",

                   new RowMapper < User > (){
                        @Override
                        public User mapRow (ResultSet rs, int rowNum) throws SQLException {
                            User u = new User();
                            u.setName(rs.getString("name"));
                            return u;
                        }
                    }
                );
        return users;
    }


    private void insertUser() {

        Integer[] a = new Integer[1];
        a[0]=42;

        int rowsUpdated =
                template.update("insert into birthdays values(?,?)",
                        "JSDATA", Date.from(Instant.now()));
        System.out.println("Rows Updated:"+rowsUpdated);
    }


    private void updateUser(String name, Date d) {
        int rowsUpdated =
                template.update("UPDATE birthdays set name='"+name+"' where birthday='2015-04-05'"); //2015-04-05
        System.out.println("Rows Updated:"+rowsUpdated);
    }

    public int getUsersCount2(String s){
        //Map bindValues = new HashMap(); bindValues.put("nm", s);

        SqlParameterSource bindValues = new MapSqlParameterSource().addValue("name", s);

        int numOfTrades = template.queryForInt
                ("select count(*) from birthdays where name=:name ", bindValues);
        System.out.println("Number of Users: "+numOfTrades);
        return numOfTrades;
    }


    public static void  main(String args[]) {
        JdbcTemplateTest t = new JdbcTemplateTest();
        /*
        System.out.println(t.getUsersCount());
        System.out.println(t.getTradeAsMap());
        System.out.println(t.getAllUsers());

        System.out.println(t.getByName("Putin"));
        System.out.println(t.getMappedUser("Putin") + ":"  + t.getMappedUser("Putin").getName() );
        System.out.println(t.getAllMappedUesrs());

           t.insertUser();

*/
        System.out.println(t.getUsersCount2("RAFA"));

    }
}

