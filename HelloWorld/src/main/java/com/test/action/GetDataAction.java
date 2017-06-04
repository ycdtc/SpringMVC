package com.test.action;

import com.test.model.Data;
import com.test.service.RecordService;
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
public class GetDataAction {
    @Resource
    private RecordService recordService;
    @Resource
    private UserService userService;
    @RequestMapping(value = "/getData",method = RequestMethod.POST)
    @ResponseBody
    public Data[] getData(@RequestParam("prefix") String prefix){
        Data bar = userService.getUserDataByDepartment();
        Data pie = userService.getUserDataByDepartment();
        Data line = recordService.getRecordData(prefix);
        return new Data[]{bar,pie,line};
    }
}
