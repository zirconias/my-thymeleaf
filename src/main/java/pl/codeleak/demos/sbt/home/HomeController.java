package pl.codeleak.demos.sbt.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * Created by xirc on 01/07/2015.
 */
@Controller
public class HomeController {


    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView messages() {
        ModelAndView mav = new ModelAndView("index");
        String[] messages = {"a","b","c"};
        mav.addObject("messages", messages);
        return mav;
    }

    @RequestMapping("/do")
    public String redirect() {
        return "redirect:/?q=Thymeleaf Is Great!";
    }
}
