package com.test.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2017/6/6.
 */
@Controller
public class UploadResultController {
    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public String result(ModelMap modelMap) {
        return "result";
    }
}
