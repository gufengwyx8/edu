/*
 * @(#)Score.java 2014-2-11 下午03:59:42 Edu
 */
package com.edu.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Score
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class Score {
    private Integer id;

    private User student;

    private ClassCourse classCourse;

    private Double score;

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
     * 返回  student
     * @return student
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    public User getStudent() {
        return student;
    }

    /**
     * 设置 student
     * @param student student
     */
    public void setStudent(User student) {
        this.student = student;
    }

    /**
     * 返回  classCourse
     * @return classCourse
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_course_id")
    public ClassCourse getClassCourse() {
        return classCourse;
    }

    /**
     * 设置 classCourse
     * @param classCourse classCourse
     */
    public void setClassCourse(ClassCourse classCourse) {
        this.classCourse = classCourse;
    }

    /**
     * 返回  score
     * @return score
     */
    public Double getScore() {
        return score;
    }

    /**
     * 设置 score
     * @param score score
     */
    public void setScore(Double score) {
        this.score = score;
    }
}
