/*
 * @(#)Exam.java 2014-2-11 下午04:02:50 Edu
 */
package com.edu.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Exam
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class Exam {
    private Integer id;

    private Room room;

    private ClassCourse classCourse;

    private String startTime;

    private String endTime;

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
     * 返回  room
     * @return room
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    public Room getRoom() {
        return room;
    }

    /**
     * 设置 room
     * @param room room
     */
    public void setRoom(Room room) {
        this.room = room;
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
     * 返回  startTime
     * @return startTime
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 设置 startTime
     * @param startTime startTime
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * 返回  endTime
     * @return endTime
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 设置 endTime
     * @param endTime endTime
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
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
