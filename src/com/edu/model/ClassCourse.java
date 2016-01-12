/*
 * @(#)ClassCourse.java 2014-2-11 ����03:56:52 Edu
 */
package com.edu.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * ClassCourse
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class ClassCourse {
    private Integer id;

    private ClsInfo clsInfo;

    private Course course;

    private User teacher;

    private Integer year;

    private List<Exam> examList;
    
    private List<Schedule> scheduleList;

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
     * ����  clsInfo
     * @return clsInfo
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cls_info_id")
    public ClsInfo getClsInfo() {
        return clsInfo;
    }

    /**
     * ���� clsInfo
     * @param clsInfo clsInfo
     */
    public void setClsInfo(ClsInfo clsInfo) {
        this.clsInfo = clsInfo;
    }

    /**
     * ����  course
     * @return course
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    public Course getCourse() {
        return course;
    }

    /**
     * ���� course
     * @param course course
     */
    public void setCourse(Course course) {
        this.course = course;
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

    /**
     * ����  examList
     * @return examList
     */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "class_course_id")
    public List<Exam> getExamList() {
        return examList;
    }

    /**
     * ���� examList
     * @param examList examList
     */
    public void setExamList(List<Exam> examList) {
        this.examList = examList;
    }

    /**
     * ����  scheduleList
     * @return scheduleList
     */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "class_course_id")
    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    /**
     * ���� scheduleList
     * @param scheduleList scheduleList
     */
    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }
}
