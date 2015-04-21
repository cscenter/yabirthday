/**
 * Created by Rafa on 24.03.2015.
 */

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class EmbeddedJetty {

    @RequestMapping(value = "/{id}/*", method = RequestMethod.GET)
    public  String home3(@PathVariable(value = "id") Long id, @RequestParam(value="x", required=false, defaultValue="X3") String x) {
        return  "id = "+ id.toString() + "<br>x= " + x;
    }

    @RequestMapping("/")
    public  String home() {
        return "Hello World! 5-";
    }

}
