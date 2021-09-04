package xh.zero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    @RequestMapping("/test")
    public ModelAndView test(ModelAndView modelAndView) {
        System.out.println("test方法执行");
        modelAndView.addObject("name", "haha");
        modelAndView.setViewName("test");
        return modelAndView;
    }
}
