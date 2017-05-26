package com.test.domain;

/**
 * @author wb-yxj268701
 * @date 2017/05/22
 */
public class UserDO {

    /**
     * 用户id
     */
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 无参构造器
     */
    public UserDO() {
    }

    /**
     * 有参构造器,不含id
     * @param username
     * @param password
     */
    public UserDO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * 完整有参构造器
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
