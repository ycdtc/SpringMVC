package com.test.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import com.test.domain.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public class UserDAO{

    private static final String USER_COLLECTION = "user_info";

    @Autowired
    @Qualifier("mongoTemplate")
    private MongoTemplate mongoTemplate;


    public List<UserDO> findUserList(UserDO userDO) {
        List<UserDO> userDOList = mongoTemplate.findAll(UserDO.class, USER_COLLECTION);
        return userDOList;
    }

    public UserDO findUser(UserDO userDO) {
        Query query = new Query();
        query.addCriteria(new Criteria("username").is(userDO.getUsername()));
        query.addCriteria(new Criteria("password").is(userDO.getPassword()));
        UserDO findUser = mongoTemplate.findOne(query, UserDO.class, USER_COLLECTION);
        return findUser;
    }

    public long findUserListForCount(UserDO userDO) {
        Query query = new Query();
        query.addCriteria(new Criteria("username").is(userDO.getUsername()));
        query.addCriteria(new Criteria("password").is(userDO.getPassword()));
        long count = mongoTemplate.count(query, USER_COLLECTION);
        return count;
    }

    public void saveUser(UserDO userDO) {
        mongoTemplate.save(userDO, USER_COLLECTION);
    }

}
