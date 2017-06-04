package com.test.action;

import com.test.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/6/4.
 */
@Controller

public class AcceptResumeAction {
    @Resource
    private UserService userService;
    @ResponseBody
    @RequestMapping(value = "/accept",method = RequestMethod.POST)
    public Integer acceptResume(@RequestParam("username") String  username){
        try {
            userService.updateStatus(username,0);
            return 0;
        }catch (Exception e){
            System.out.print(e.getMessage() + e.getStackTrace());
            return 1;
        }
    }
}
