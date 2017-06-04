package com.test.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2017/6/3.
 */
@Controller
public class HRController {
    @RequestMapping(value = "/hr", method = RequestMethod.GET)
    public String hr(ModelMap modelMap) {
        return "hr";
    }
}
