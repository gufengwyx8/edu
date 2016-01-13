/*
 * @(#)Schedule.java 2014-2-11 ����04:04:44 Edu
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
     * ����  room
     * @return room
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    public Room getRoom() {
        return room;
    }

    /**
     * ���� room
     * @param room room
     */
    public void setRoom(Room room) {
        this.room = room;
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
     * ����  weekday
     * @return weekday
     */
    public Integer getWeekday() {
        return weekday;
    }

    /**
     * ���� weekday
     * @param weekday weekday
     */
    public void setWeekday(Integer weekday) {
        this.weekday = weekday;
    }

    /**
     * ����  number
     * @return number
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * ���� number
     * @param number number
     */
    public void setNumber(Integer number) {
        this.number = number;
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
     * ����  startTime
     * @return startTime
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * ���� startTime
     * @param startTime startTime
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * ����  endTime
     * @return endTime
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * ���� endTime
     * @param endTime endTime
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
