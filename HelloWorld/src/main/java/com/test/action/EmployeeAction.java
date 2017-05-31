package com.test.action;

import com.test.model.User;
import com.test.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class EmployeeAction {
    @Resource
    private UserService userService;
    @RequestMapping(value = "/employee/{username}", method = RequestMethod.GET)
    public String index(@PathVariable String username, ModelMap modelMap) {
        System.out.print(username);
        modelMap.addAttribute("username",username);
        modelMap.addAttribute("lastSignInDate",userService.findUser(new User(username)).getLastSignInDate());
        return "employee";
    }
}