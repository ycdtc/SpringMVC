package com.test.dao;

import java.util.List;

import com.test.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


@Repository
public class UserDAO{

    private static final String USER_COLLECTION = "user_info";

    @Autowired
    @Qualifier("mongoTemplate")
    private MongoTemplate mongoTemplate;


    public List<User> findUserList(User user) {
        List<User> userList = mongoTemplate.findAll(User.class, USER_COLLECTION);
        return userList;
    }

    public List<User> findResumeList() {
        Query query = new Query();
        query.addCriteria(new Criteria("status").is(1));
        List<User> userList = mongoTemplate.find(query,User.class, USER_COLLECTION);
        return userList;
    }

    public User findUser(User user) {
        Query query = new Query();
        query.addCriteria(new Criteria("username").is(user.getUsername()));
        User findUser = mongoTemplate.findOne(query, User.class, USER_COLLECTION);
        return findUser;
    }

    public void saveUser(User user) {
        mongoTemplate.save(user, USER_COLLECTION);
    }

    public void updateUser(User user) {
        User tmpUser = new User();
        tmpUser.setUsername(user.getUsername());
        mongoTemplate.remove(tmpUser,USER_COLLECTION);
        saveUser(user);
    }

    public Integer findUserCountByDepartment(String department){
        Query query = new Query();
        query.addCriteria(new Criteria("department").is(department));
        query.addCriteria(new Criteria("status").is(0));
        List<User> userList = mongoTemplate.find(query,User.class, USER_COLLECTION);
        return userList.size();
    }

    public void removeUser(String username){
        User tmpUser = findUser(new User(username));
        mongoTemplate.remove(tmpUser,USER_COLLECTION);
    }

}
