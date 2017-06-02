package com.test.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import com.test.dao.UserDAO;
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
}
