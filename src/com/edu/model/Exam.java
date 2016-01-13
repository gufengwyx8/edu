/*
 * @(#)Exam.java 2014-2-11 ����04:02:50 Edu
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
     * ����  startTime
     * @return startTime
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * ���� startTime
     * @param startTime startTime
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * ����  endTime
     * @return endTime
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * ���� endTime
     * @param endTime endTime
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
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
