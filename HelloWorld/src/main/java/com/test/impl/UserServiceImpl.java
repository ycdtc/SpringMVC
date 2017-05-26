package com.test.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import com.test.dao.UserDAO;
import com.test.domain.UserDO;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

/**
 * @author wb-yxj268701
 * @date 2017/05/22
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    UserDAO userDAO;

    /**
     * 根据参数查找用户列表
     * @param userDO
     * @return
     */
   public List<UserDO> findUserList(UserDO userDO) {
        List<UserDO> userDOList = userDAO.findUserList(userDO);
        return userDOList;
    }

    /**
     * 根据参数查找用户数量
     * @param userDO
     * @return
     */
    public long findUserListForCount(UserDO userDO) {
        return userDAO.findUserListForCount(userDO);
    }

    /**
     * 根据参数查找用户信息
     * @param userDO
     * @return
     */
    public UserDO findUser(UserDO userDO) {
        return userDAO.findUser(userDO);
    }



    /**
     * 保存用户信息
     * @param userDO
     */
    public void saveUser(UserDO userDO) {
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        userDO.setId(id);
        userDAO.saveUser(userDO);
    }
}
