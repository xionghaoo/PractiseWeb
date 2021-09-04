package xh.zero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import xh.zero.domain.Role;
import xh.zero.domain.User;
import xh.zero.service.RoleService;
import xh.zero.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;

    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session) {
        User user = userService.login(username, password);
        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/index.jsp";
        } else {
            return "redirect:/login.jsp";
        }
    }

    @RequestMapping("/list")
    public ModelAndView list(ModelAndView modelAndView) {
        List<User> users = userService.list();
        modelAndView.addObject("userList", users);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add(ModelAndView modelAndView) {
        List<Role> roles = roleService.list();
        modelAndView.addObject("roleList", roles);
        modelAndView.setViewName("user-add");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(User user, Long[] roleIds) {
        userService.saveUser(user, roleIds);
        return "redirect:/user/list";
    }

    @RequestMapping("/delete")
    public String delete(Long id) {
        userService.delete(id);
        return "redirect:/user/list";
    }
}
