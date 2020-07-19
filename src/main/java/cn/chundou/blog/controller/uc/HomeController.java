package cn.chundou.blog.controller.uc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "ucHomeController")
@RequestMapping(value = "uc")
public class HomeController {

    @GetMapping
    public String index() {
        return "uc/home/index";
    }
}
