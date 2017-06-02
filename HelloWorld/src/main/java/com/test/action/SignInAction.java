package com.test.action;

import com.test.model.Record;
import com.test.model.User;
import com.test.service.RecordService;
import com.test.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class SignInAction {

    @Resource
    private RecordService recordService;
    @Resource
    private UserService userService;
    @RequestMapping(value = "/addRecord")
    @ResponseBody
    public String addRecord(@ModelAttribute("username") String username,@ModelAttribute("date") String date) {
        try {
            recordService.saveRecord(new Record(username, date));
            userService.updateDate(username, date);
            return "success";
        } catch(Exception e) {
            System.out.println(e.getMessage() + e.getStackTrace());
            return e.getMessage();
        }
    }

}
