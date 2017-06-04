package com.test.action;

import com.test.model.User;
import com.test.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/6/4.
 */
@Controller
@RequestMapping("/getResume")
public class GetResumeAction {

    @Resource
    private UserService userService;
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public List<User> getResume() {
        List<User> l =  userService.findResumeList();
        return l;
    }
}
