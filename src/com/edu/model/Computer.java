/*
 * @(#)Computer.java 2014-2-11 ����04:09:22 Edu
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
     * ����  exam
     * @return exam
     */
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "exam_id")
    public Exam getExam() {
        return exam;
    }

    /**
     * ���� exam
     * @param exam exam
     */
    public void setExam(Exam exam) {
        this.exam = exam;
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
