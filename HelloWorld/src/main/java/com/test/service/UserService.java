package com.test.service;

import java.util.List;

import com.test.model.User;

public interface UserService {

    List<User> findUserList(User user);

    User findUser(User user);

    int saveUser(User user);

    void updateUser(User user);
}
