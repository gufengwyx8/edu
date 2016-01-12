/*
 * @(#)Score.java 2014-2-11 ����03:59:42 Edu
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
     * ����  student
     * @return student
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    public User getStudent() {
        return student;
    }

    /**
     * ���� student
     * @param student student
     */
    public void setStudent(User student) {
        this.student = student;
    }

    /**
     * ����  classCourse
     * @return classCourse
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_course_id")
    public ClassCourse getClassCourse() {
        return classCourse;
    }

    /**
     * ���� classCourse
     * @param classCourse classCourse
     */
    public void setClassCourse(ClassCourse classCourse) {
        this.classCourse = classCourse;
    }

    /**
     * ����  score
     * @return score
     */
    public Double getScore() {
        return score;
    }

    /**
     * ���� score
     * @param score score
     */
    public void setScore(Double score) {
        this.score = score;
    }
}
