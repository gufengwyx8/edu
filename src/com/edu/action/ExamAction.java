/*
 * @(#)ExamAction.java 2014-2-15 下午02:00:31 Edu
 */
package com.edu.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.edu.model.Cet;
import com.edu.model.ClassCourse;
import com.edu.model.Computer;
import com.edu.model.Exam;
import com.edu.model.Room;
import com.edu.model.User;
import com.edu.model.UserType;

/**
 * ExamAction
 * @author wang
 * @version 1.0
 *
 */
@Component("examAction")
@Scope("prototype")
public class ExamAction extends BaseAction {
    private List<Cet> cetList;

    private Cet cet;

    private List<Room> roomList;

    private List<User> studentList;

    private List<Computer> computerList;

    private Computer computer;

    private List<Exam> examList;

    private Exam exam;

    private List<ClassCourse> classCourseList;

    public String listCet() {
        if (loginUser.getType() == UserType.STUDENT) {
            cetList = cetService.listByStudent(loginUser);
        } else {
            cetList = cetService.list();
        }
        roomList = roomService.list();
        studentList = userService.list(UserType.STUDENT);

        return SUCCESS;
    }

    public String saveCet() {
        cetService.saveOrUpdate(cet);
        msg = "success";
        return SUCCESS;
    }

    public String destoryCet() {
        cetService.delete(cet);
        return SUCCESS;
    }

    public String listComputer() {
        roomList = roomService.list();
        studentList = userService.list(UserType.STUDENT);
        if (loginUser.getType() == UserType.STUDENT) {
            computerList = computerService.listByStudent(loginUser);
        } else {
            computerList = computerService.list();
        }
        return SUCCESS;
    }

    public String saveComputer() {
        computerService.saveOrUpdate(computer);
        msg = "success";
        return SUCCESS;
    }

    public String destoryComputer() {
        computerService.delete(computer);
        return SUCCESS;
    }

    public String listExam() {
        if (value == null) {
            examList = examService.listFinalExam();
        } else {
            examList = examService.search(value);
        }
        classCourseList = classCourseService.list();
        roomList = roomService.list();
        return SUCCESS;
    }

    public String saveExam() {
        examService.saveOrUpdate(exam);
        msg = "success";
        return SUCCESS;
    }

    public String destoryExam() {
        examService.delete(exam);
        return SUCCESS;
    }

    /**
     * 返回  cetList
     * @return cetList
     */
    public List<Cet> getCetList() {
        return cetList;
    }

    /**
     * 设置 cetList
     * @param cetList cetList
     */
    public void setCetList(List<Cet> cetList) {
        this.cetList = cetList;
    }

    /**
     * 返回  cet
     * @return cet
     */
    public Cet getCet() {
        return cet;
    }

    /**
     * 设置 cet
     * @param cet cet
     */
    public void setCet(Cet cet) {
        this.cet = cet;
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
     * 返回  studentList
     * @return studentList
     */
    public List<User> getStudentList() {
        return studentList;
    }

    /**
     * 设置 studentList
     * @param studentList studentList
     */
    public void setStudentList(List<User> studentList) {
        this.studentList = studentList;
    }

    /**
     * 返回  computerList
     * @return computerList
     */
    public List<Computer> getComputerList() {
        return computerList;
    }

    /**
     * 设置 computerList
     * @param computerList computerList
     */
    public void setComputerList(List<Computer> computerList) {
        this.computerList = computerList;
    }

    /**
     * 返回  computer
     * @return computer
     */
    public Computer getComputer() {
        return computer;
    }

    /**
     * 设置 computer
     * @param computer computer
     */
    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    /**
     * 返回  examList
     * @return examList
     */
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
     * 返回  exam
     * @return exam
     */
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
}
