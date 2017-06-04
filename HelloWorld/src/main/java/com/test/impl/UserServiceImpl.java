package com.test.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import com.test.dao.UserDAO;
import com.test.model.Data;
import com.test.model.User;
import com.test.service.UserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    UserDAO userDAO;

   public List<User> findUserList(User user) {
        List<User> userList = userDAO.findUserList(user);
        return userList;
    }

    public User findUser(User user) {
        return userDAO.findUser(user);
    }

    public int saveUser(User user) {
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        user.setId(id);
        if(userDAO.findUser(user) != null){
            return 1;
        }else {
            userDAO.saveUser(user);
            return 0;
        }
    }

    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    public void updateDate(String username, String date) {
        User user = userDAO.findUser(new User(username));
        user.setLastSignInDate(date);
        userDAO.updateUser(user);
    }

    public void updateStatus(String username,int status) {
        User user = userDAO.findUser(new User(username));
        user.setStatus(status);
        userDAO.updateUser(user);
    }

    public List<User> findResumeList() {
        return userDAO.findResumeList();
    }

    public Data getUserDataByDepartment() {
        String[] departments = new String[]{"Marketing","Sales","Finance","Human resources"};
        Data data = new Data();
        for(String department:departments) {
            data.addName(department);
            data.addValue(userDAO.findUserCountByDepartment(department));
        }
        return data;
    }
}

