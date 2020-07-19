package cn.chundou.blog.controller.uc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "ucOrderController")
@RequestMapping(value = "uc/orders")
public class OrderController {

    @GetMapping
    public String index() {
        return "uc/order/index";
    }
}
