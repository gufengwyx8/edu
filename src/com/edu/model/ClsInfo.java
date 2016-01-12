/*
 * @(#)ClsInfo.java 2014-2-11 下午03:54:45 Edu
 */
package com.edu.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * ClsInfo
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class ClsInfo {
    private Integer id;

    private String name;

    private User teacher;

    private Integer year;

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
     * 返回  teacher
     * @return teacher
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    public User getTeacher() {
        return teacher;
    }

    /**
     * 设置 teacher
     * @param teacher teacher
     */
    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    /**
     * 返回  year
     * @return year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * 设置 year
     * @param year year
     */
    public void setYear(Integer year) {
        this.year = year;
    }

}
