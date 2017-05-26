package com.test.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeAction {

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String index(@RequestParam("username")String name,ModelMap modelMap) {
        System.out.print(name);
        modelMap.addAttribute("name",name);
        return "employee";
    }
}