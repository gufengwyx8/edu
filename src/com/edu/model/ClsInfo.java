/*
 * @(#)ClsInfo.java 2014-2-11 ����03:54:45 Edu
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
     * ����  teacher
     * @return teacher
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    public User getTeacher() {
        return teacher;
    }

    /**
     * ���� teacher
     * @param teacher teacher
     */
    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    /**
     * ����  year
     * @return year
     */
    public Integer getYear() {
        return year;
    }

    /**
     * ���� year
     * @param year year
     */
    public void setYear(Integer year) {
        this.year = year;
    }

}
