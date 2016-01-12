/*
 * @(#)ClassCourse.java 2014-2-11 下午03:56:52 Edu
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

    /**
     * 返回  course
     * @return course
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    public Course getCourse() {
        return course;
    }

    /**
     * 设置 course
     * @param course course
     */
    public void setCourse(Course course) {
        this.course = course;
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

    /**
     * 返回  examList
     * @return examList
     */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "class_course_id")
    public List<Exam> getExamList() {
        return examList;
    }

    /**
     * 设置 examList
     * @param examList examList
     */
    public void setExamList(List<Exam> examList) {
        this.examList = examList;
    }

    /**
     * 返回  scheduleList
     * @return scheduleList
     */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "class_course_id")
    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    /**
     * 设置 scheduleList
     * @param scheduleList scheduleList
     */
    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }
}
