package com.test.action;

import java.io.File;
import java.util.Date;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;

import com.test.model.User;
import com.test.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadAction {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public String upload(User user) {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String department = request.getParameter("department");
//        String path = request.getSession().getServletContext().getRealPath("upload");
//        String fileName = file.getOriginalFilename();
//        File targetFile = new File(path, fileName);
//        if(!targetFile.exists()){
//            targetFile.delete();
//        }
//        try {
//            file.transferTo(targetFile);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        User user = new User(username,password,department,request.getContextPath()+"/upload/"+fileName);
        if(userService.saveUser(user) == 0){
            return "success";
        }else{
            return "fail";
        }
    }
}