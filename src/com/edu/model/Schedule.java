/*
 * @(#)Schedule.java 2014-2-11 下午04:04:44 Edu
 */
package com.edu.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Schedule
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class Schedule {
    private Integer id;

    private Room room;

    private ClassCourse classCourse;

    private Integer weekday;

    private Integer number;

    private Integer year;

    private Date startTime;

    private Date endTime;

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
     * 返回  weekday
     * @return weekday
     */
    public Integer getWeekday() {
        return weekday;
    }

    /**
     * 设置 weekday
     * @param weekday weekday
     */
    public void setWeekday(Integer weekday) {
        this.weekday = weekday;
    }

    /**
     * 返回  number
     * @return number
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * 设置 number
     * @param number number
     */
    public void setNumber(Integer number) {
        this.number = number;
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
     * 返回  startTime
     * @return startTime
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置 startTime
     * @param startTime startTime
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 返回  endTime
     * @return endTime
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置 endTime
     * @param endTime endTime
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
