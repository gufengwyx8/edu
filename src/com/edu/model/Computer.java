/*
 * @(#)Computer.java 2014-2-11 下午04:09:22 Edu
 */
package com.edu.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Computer
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class Computer {
    private Integer id;

    private String name;

    private User student;

    private Exam exam;

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
     * 返回  exam
     * @return exam
     */
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "exam_id")
    public Exam getExam() {
        return exam;
    }

    /**
     * 设置 exam
     * @param exam exam
     */
    public void setExam(Exam exam) {
        this.exam = exam;
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
