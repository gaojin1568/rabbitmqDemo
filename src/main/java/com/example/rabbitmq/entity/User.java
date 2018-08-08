package com.example.rabbitmq.entity;

import java.io.Serializable;

/**
 * 用户实体类
 * 特别注意：实体类一定要实现序列化接口，才可以在rabbitmq中使用，包括试题中包含的实体。
 * @author gaojin
 */
public class User implements Serializable {

    private static final long serialVersionUID = -112501448055278680L;

    private Integer id;
    private String username;
    private String password;
    private Page page;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public User() {
    }

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", page='" + page.toString() + '\'' +
                '}';
    }
}