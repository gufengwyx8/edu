/*
 * @(#)CourseAction.java 2014-2-14 下午09:29:39 Edu
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
     * 返回  clsInfoList
     * @return clsInfoList
     */
    public List<ClsInfo> getClsInfoList() {
        return clsInfoList;
    }

    /**
     * 设置 clsInfoList
     * @param clsInfoList clsInfoList
     */
    public void setClsInfoList(List<ClsInfo> clsInfoList) {
        this.clsInfoList = clsInfoList;
    }

    /**
     * 返回  courseList
     * @return courseList
     */
    public List<Course> getCourseList() {
        return courseList;
    }

    /**
     * 设置 courseList
     * @param courseList courseList
     */
    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    /**
     * 返回  course
     * @return course
     */
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

    /**
     * 返回  classCourseList
     * @return classCourseList
     */
    public List<ClassCourse> getClassCourseList() {
        return classCourseList;
    }

    /**
     * 设置 classCourseList
     * @param classCourseList classCourseList
     */
    public void setClassCourseList(List<ClassCourse> classCourseList) {
        this.classCourseList = classCourseList;
    }

    /**
     * 返回  classCourse
     * @return classCourse
     */
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
     * 返回  teacherList
     * @return teacherList
     */
    public List<User> getTeacherList() {
        return teacherList;
    }

    /**
     * 设置 teacherList
     * @param teacherList teacherList
     */
    public void setTeacherList(List<User> teacherList) {
        this.teacherList = teacherList;
    }

    /**
     * 返回  schedule
     * @return schedule
     */
    public Schedule getSchedule() {
        return schedule;
    }

    /**
     * 设置 schedule
     * @param schedule schedule
     */
    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    /**
     * 返回  scheduleList
     * @return scheduleList
     */
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

    /**
     * 返回  roomList
     * @return roomList
     */
    public List<Room> getRoomList() {
        return roomList;
    }

    /**
     * 设置 roomList
     * @param roomList roomList
     */
    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    /**
     * 返回  score
     * @return score
     */
    public Score getScore() {
        return score;
    }

    /**
     * 设置 score
     * @param score score
     */
    public void setScore(Score score) {
        this.score = score;
    }

    /**
     * 返回  scoreList
     * @return scoreList
     */
    public List<Score> getScoreList() {
        return scoreList;
    }

    /**
     * 设置 scoreList
     * @param scoreList scoreList
     */
    public void setScoreList(List<Score> scoreList) {
        this.scoreList = scoreList;
    }
}
