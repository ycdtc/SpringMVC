package com.test.service;

import java.util.List;

import com.test.domain.UserDO;

/**
 * @author wb-yxj268701
 * @date 2017/05/22
 */
public interface UserService {

    /**
     * 根据参数查找用户列表
     * @param userDO
     * @return
     */
    List<UserDO> findUserList(UserDO userDO);

    /**
     * 根据参数查找用户数量
     * @param userDO
     * @return
     */
    long findUserListForCount(UserDO userDO);

    /**
     * 根据参数查找用户信息
     * @param userDO
     * @return
     */
    UserDO findUser(UserDO userDO);



    /**
     * 保存用户信息
     * @param userDO
     */
    void saveUser(UserDO userDO);
}
