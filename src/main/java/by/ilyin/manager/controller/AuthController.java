package by.ilyin.manager.controller;

import by.ilyin.manager.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/signup")
    public String signUpPage(@ModelAttribute("user") User user) {
        return "auth/sign_up";
    }

    
}
