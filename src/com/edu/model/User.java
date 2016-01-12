/*
 * @(#)User.java 2013-4-10 下午12:51:27 Order
 */
package com.edu.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 * User
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class User {

    private Integer id;

    private String name;

    private String password;

    public UserType type;

    private String sex;

    private String birthday;

    private String phone;

    private String email;

    private ClsInfo clsInfo;

    @Transient
    public String getTypeName() {
        if (type == UserType.ADMIN) {
            return "管理员";
        } else if (type == UserType.TEACHER) {
            return "教师";
        } else if (type == UserType.STUDENT) {
            return "学生";
        }
        return null;
    }

    /**
     * 返回  id
     * @return id
     */
    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    /**
     * 设置 id
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 返回  name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 name
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 返回  password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置 password
     * @param password password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 返回  type
     * @return type
     */
    @Enumerated(EnumType.STRING)
    public UserType getType() {
        return type;
    }

    /**
     * 设置 type
     * @param type type
     */
    public void setType(UserType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User)) {
            return false;
        }
        User u = (User) o;
        return this.getId().equals(u.getId());
    }

    @Override
    public int hashCode() {
        return this.getId() * 31;
    }

    /**
     * 返回  sex
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置 sex
     * @param sex sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 返回  birthday
     * @return birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * 设置 birthday
     * @param birthday birthday
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * 返回  phone
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置 phone
     * @param phone phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 返回  email
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置 email
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 返回  clsInfo
     * @return clsInfo
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cls_info_id")
    public ClsInfo getClsInfo() {
        return clsInfo;
    }

    /**
     * 设置 clsInfo
     * @param clsInfo clsInfo
     */
    public void setClsInfo(ClsInfo clsInfo) {
        this.clsInfo = clsInfo;
    }

}
