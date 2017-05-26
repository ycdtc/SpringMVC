package com.test.service;

import java.util.List;

import com.test.domain.UserDO;

/**
 * @author wb-yxj268701
 * @date 2017/05/22
 */
public interface UserService {

    /**
     * ���ݲ��������û��б�
     * @param userDO
     * @return
     */
    List<UserDO> findUserList(UserDO userDO);

    /**
     * ���ݲ��������û�����
     * @param userDO
     * @return
     */
    long findUserListForCount(UserDO userDO);

    /**
     * ���ݲ��������û���Ϣ
     * @param userDO
     * @return
     */
    UserDO findUser(UserDO userDO);



    /**
     * �����û���Ϣ
     * @param userDO
     */
    void saveUser(UserDO userDO);
}
