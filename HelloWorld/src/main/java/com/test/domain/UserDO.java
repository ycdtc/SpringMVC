package com.test.domain;

/**
 * @author wb-yxj268701
 * @date 2017/05/22
 */
public class UserDO {

    /**
     * �û�id
     */
    private String id;

    /**
     * �û���
     */
    private String username;

    /**
     * ����
     */
    private String password;

    /**
     * �޲ι�����
     */
    public UserDO() {
    }

    /**
     * �вι�����,����id
     * @param username
     * @param password
     */
    public UserDO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * �����вι�����
     * @param id
     * @param username
     * @param password
     */
    public UserDO(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
