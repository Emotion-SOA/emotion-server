package emotion.api;

import emotion.api.service.TokenService;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lifengshuang on 22/04/2017.
 */

@Controller
public class Test {

//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
//    public
//    @ResponseBody
//    Hello hello(@RequestParam(name = "name") String name) {
//        return new Hello(name);
//    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public
    @ResponseBody
    String helloPost(@RequestBody Hello hello) {
        return "123";
    }

    private class Hello {
        private String message;
        private String date;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }
}
