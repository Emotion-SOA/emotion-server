package emotion.api;

import emotion.api.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lifengshuang on 22/04/2017.
 */

@Controller
public class Test {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public
    @ResponseBody
    String helloPost() {
        return "Hello";
    }

}
