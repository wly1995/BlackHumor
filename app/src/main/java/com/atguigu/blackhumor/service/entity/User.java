package com.atguigu.blackhumor.service.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

import java.io.Serializable;

/**
 * Created by 万里洋 on 2017/3/27.
 */

@Entity
public class User implements Serializable{
    @Id
    private Long id;
    private String name;
    private String password;
    @Transient
    private int tempUsageCount; // not persisted
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    @Generated(hash = 1691991404)
    public User(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
    @Generated(hash = 586692638)
    public User() {
    }
}
