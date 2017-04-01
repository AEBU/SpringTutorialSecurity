package securityinmemory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Alexis on 01/04/2017.
 */

@Controller
public class WebController {
    @RequestMapping(value={"/","home"})
    public String home(){
        return "home";
    }

    @RequestMapping(value={"/welcome"})
    public String welcome(){
        return "welcome";
    }

    @RequestMapping(value="/admin")
    public String admin(){
        return "admin";
    }

    @RequestMapping(value={"/login"})
    public String login(){
        return "login";
    }


    @RequestMapping(value="/403")
    public String Error403(){
        return "403";
    }
}
