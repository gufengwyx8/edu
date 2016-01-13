/*
 * @(#)CourseAction.java 2014-2-14 ����09:29:39 Edu
 */
package com.edu.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.edu.model.ClassCourse;
import com.edu.model.ClsInfo;
import com.edu.model.Course;
import com.edu.model.Room;
import com.edu.model.Schedule;
import com.edu.model.Score;
import com.edu.model.User;
import com.edu.model.UserType;
import com.mysql.jdbc.StringUtils;

/**
 * CourseAction
 * @author wang
 * @version 1.0
 *
 */
@Component("classCourseAction")
@Scope("prototype")
public class ClassCourseAction extends BaseAction {
    private List<ClsInfo> clsInfoList;

    private List<Course> courseList;

    private Course course;

    private List<ClassCourse> classCourseList;

    private ClassCourse classCourse;

    private List<User> teacherList;

    private Schedule schedule;

    private List<Schedule> scheduleList;

    private List<Room> roomList;

    private Score score;

    private List<Score> scoreList;

    public String listClassCourse() {
        courseList = courseService.list();
        teacherList = userService.list(UserType.TEACHER);
        clsInfoList = clsInfoService.list();
        classCourseList = classCourseService.list();
        return SUCCESS;
    }

    public String saveClassCourse() {
        classCourseList = classCourseService.list();
        for (ClassCourse cc : classCourseList) {
            if (!cc.getId().equals(classCourse.getId())
                    && cc.getClsInfo().getId().equals(
                        classCourse.getClsInfo().getId())
                    && cc.getCourse().getId().equals(
                        classCourse.getCourse().getId())) {
                msg = "error";
                return SUCCESS;
            }
        }
        classCourseService.saveOrUpdate(classCourse);
        msg = "success";
        return SUCCESS;
    }

    public String destoryClassCourse() {
        classCourseService.delete(classCourse);
        return SUCCESS;
    }

    public String listSchedule() {
        classCourseList = classCourseService.list();
        roomList = roomService.list();
        if (StringUtils.isNullOrEmpty(msg)) {
            scheduleList = scheduleService.list();
        } else {
            scheduleList = scheduleService.search(msg);
        }
        return SUCCESS;
    }

    public String saveSchedule() {
        String ret = scheduleService.avaliable(schedule);
        if (ret == null) {
            scheduleService.saveOrUpdate(schedule);
            msg = "success";
        } else {
            msg = ret;
        }
        return SUCCESS;
    }

    public String destorySchedule() {
        scheduleService.delete(schedule);
        return SUCCESS;
    }

    /**
     * ����  clsInfoList
     * @return clsInfoList
     */
    public List<ClsInfo> getClsInfoList() {
        return clsInfoList;
    }

    /**
     * ���� clsInfoList
     * @param clsInfoList clsInfoList
     */
    public void setClsInfoList(List<ClsInfo> clsInfoList) {
        this.clsInfoList = clsInfoList;
    }

    /**
     * ����  courseList
     * @return courseList
     */
    public List<Course> getCourseList() {
        return courseList;
    }

    /**
     * ���� courseList
     * @param courseList courseList
     */
    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    /**
     * ����  course
     * @return course
     */
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

    /**
     * ����  classCourseList
     * @return classCourseList
     */
    public List<ClassCourse> getClassCourseList() {
        return classCourseList;
    }

    /**
     * ���� classCourseList
     * @param classCourseList classCourseList
     */
    public void setClassCourseList(List<ClassCourse> classCourseList) {
        this.classCourseList = classCourseList;
    }

    /**
     * ����  classCourse
     * @return classCourse
     */
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
     * ����  teacherList
     * @return teacherList
     */
    public List<User> getTeacherList() {
        return teacherList;
    }

    /**
     * ���� teacherList
     * @param teacherList teacherList
     */
    public void setTeacherList(List<User> teacherList) {
        this.teacherList = teacherList;
    }

    /**
     * ����  schedule
     * @return schedule
     */
    public Schedule getSchedule() {
        return schedule;
    }

    /**
     * ���� schedule
     * @param schedule schedule
     */
    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    /**
     * ����  scheduleList
     * @return scheduleList
     */
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

    /**
     * ����  roomList
     * @return roomList
     */
    public List<Room> getRoomList() {
        return roomList;
    }

    /**
     * ���� roomList
     * @param roomList roomList
     */
    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    /**
     * ����  score
     * @return score
     */
    public Score getScore() {
        return score;
    }

    /**
     * ���� score
     * @param score score
     */
    public void setScore(Score score) {
        this.score = score;
    }

    /**
     * ����  scoreList
     * @return scoreList
     */
    public List<Score> getScoreList() {
        return scoreList;
    }

    /**
     * ���� scoreList
     * @param scoreList scoreList
     */
    public void setScoreList(List<Score> scoreList) {
        this.scoreList = scoreList;
    }
}
