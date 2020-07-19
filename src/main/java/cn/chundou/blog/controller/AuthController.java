package cn.chundou.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "auth")
public class AuthController {

    @GetMapping(value = "login")
    public String login() {
        return "auth/login";
    }

    @GetMapping(value = "register")
    public String register() {
        return "auth/register";
    }
}
