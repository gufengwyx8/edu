/*
 * @(#)Book.java 2014-2-11 ����03:53:23 Edu
 */
package com.edu.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * Book
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class Book {
    private Integer id;

    private String name;

    private String remark;

    private String press;

    private String date;

    private List<Course> courseList;

    /**
     * ����  id
     * @return id
     */
    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    /**
     * ���� id
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * ����  name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * ���� name
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ����  remark
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * ���� remark
     * @param remark remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * ����  press
     * @return press
     */
    public String getPress() {
        return press;
    }

    /**
     * ���� press
     * @param press press
     */
    public void setPress(String press) {
        this.press = press;
    }

    /**
     * ����  date
     * @return date
     */
    public String getDate() {
        return date;
    }

    /**
     * ���� date
     * @param date date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * ����  courseList
     * @return courseList
     */
    @OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.REMOVE })
    @JoinColumn(name = "book_id")
    public List<Course> getCourseList() {
        return courseList;
    }

    /**
     * ���� courseList
     * @param courseList courseList
     */
    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
