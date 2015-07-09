package com.zirconias.thyspring.signup;

import com.zirconias.thyspring.AjaxUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by xirc on 09/07/2015.
 */
@Controller
public class SignupController {

    @RequestMapping("signup")
    public String signup(Model model, @RequestHeader(value = "X-Requested-With", required = false) String requestedWith) {
        System.out.println("signup here");
        model.addAttribute(new SignupForm());
        if (AjaxUtils.isAjaxRequest(requestedWith)) {
            return "signup/signup".concat(" :: signupForm");
        }
        return "signup/signup";
    }

}
