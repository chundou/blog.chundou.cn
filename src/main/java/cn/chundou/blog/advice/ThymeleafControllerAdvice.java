package cn.chundou.blog.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Thymeleaf 全局属性
 */
@ControllerAdvice
public class ThymeleafControllerAdvice {

    @ModelAttribute("siteProfile")
    public String siteProfiles() {
        return "牛逼的站点";
    }
}
