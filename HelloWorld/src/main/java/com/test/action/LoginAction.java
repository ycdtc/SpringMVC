package com.test.action;

import java.util.List;

import javax.annotation.Resource;

import com.test.model.User;
import com.test.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class LoginAction {
    @Resource
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, produces="application/json;charset=UTF-8")
    @ResponseBody
    public User login(@ModelAttribute("userDO")User user) {
        User findUser = userService.findUser(user);
        return findUser;
    }
}
