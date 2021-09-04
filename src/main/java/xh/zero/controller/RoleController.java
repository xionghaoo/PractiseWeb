package xh.zero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import xh.zero.domain.Role;
import xh.zero.service.RoleService;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    @RequestMapping("/list")
    public ModelAndView list(ModelAndView modelAndView) {
        List<Role> list = roleService.list();
        modelAndView.addObject("roleList", list);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Role role) {
        roleService.saveRole(role);
        return "redirect:/role/list";
    }

    @RequestMapping("/delete")
    public String delete(int id) {
        roleService.deleteRole(id);
        return "redirect:/role/list";
    }
}
