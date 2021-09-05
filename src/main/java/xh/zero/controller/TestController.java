package xh.zero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import xh.zero.service.AccountService;

import javax.annotation.Resource;

@Controller
public class TestController {

    @Resource
    private AccountService accountService;

    @RequestMapping("/test")
    public ModelAndView test(ModelAndView modelAndView) {
        System.out.println("test方法执行");
        modelAndView.addObject("name", "haha");
        modelAndView.setViewName("test");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/exception")
    public void exception() {
//        String str = "null";
//        Integer n = (Integer) String.valueOf(str);
    }

    @ResponseBody
    @RequestMapping("/transaction")
    public void transactionTest() {
        String inName = "alice";
        String outName = "tom";
        int money = 500;
        accountService.transfer(outName, inName, money);
    }
}
