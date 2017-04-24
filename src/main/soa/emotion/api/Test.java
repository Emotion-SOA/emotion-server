package emotion.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lifengshuang on 22/04/2017.
 */

@Controller
public class Test {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public
    @ResponseBody
    String hello() {
        return "Hello!";
    }
}
