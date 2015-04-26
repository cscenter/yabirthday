/**
 * Created by Rafa on 26.04.2015.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;


@RestController
//@EnableAutoConfiguration
@EnableAutoConfiguration
public class EJet {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/{id}/*", method = RequestMethod.GET)
    String home3(@PathVariable(value = "id") Long id, @RequestParam(value="x", required=false, defaultValue="X3") String x) {
        return  "id = "+ id.toString() + "<br>x= " + x;
    }

    @RequestMapping("/")
    String home() {
        //return this.userService.getUser("Rafa").toString();
        return "LOL";
    }

}
