package com.zirconias.thyspring.signup;

import com.zirconias.thyspring.config.AjaxUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "signin")
    public String signin() {
        return "signin/login";
    }

    @RequestMapping(value = "signin", method = RequestMethod.POST)
    public String signin(@RequestParam String j_username,@RequestParam String j_password) {

        //Account account = accountRepository.save(signupForm.createAccount());
        //userService.signin(account);
        // see /WEB-INF/i18n/messages.properties and /WEB-INF/views/homeSignedIn.html
        //MessageHelper.addSuccessAttribute(ra, "signup.success");
        return "redirect:/";
    }
}
