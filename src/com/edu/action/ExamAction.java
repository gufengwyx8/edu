/*
 * @(#)ExamAction.java 2014-2-15 ����02:00:31 Edu
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
     * ����  cetList
     * @return cetList
     */
    public List<Cet> getCetList() {
        return cetList;
    }

    /**
     * ���� cetList
     * @param cetList cetList
     */
    public void setCetList(List<Cet> cetList) {
        this.cetList = cetList;
    }

    /**
     * ����  cet
     * @return cet
     */
    public Cet getCet() {
        return cet;
    }

    /**
     * ���� cet
     * @param cet cet
     */
    public void setCet(Cet cet) {
        this.cet = cet;
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
     * ����  studentList
     * @return studentList
     */
    public List<User> getStudentList() {
        return studentList;
    }

    /**
     * ���� studentList
     * @param studentList studentList
     */
    public void setStudentList(List<User> studentList) {
        this.studentList = studentList;
    }

    /**
     * ����  computerList
     * @return computerList
     */
    public List<Computer> getComputerList() {
        return computerList;
    }

    /**
     * ���� computerList
     * @param computerList computerList
     */
    public void setComputerList(List<Computer> computerList) {
        this.computerList = computerList;
    }

    /**
     * ����  computer
     * @return computer
     */
    public Computer getComputer() {
        return computer;
    }

    /**
     * ���� computer
     * @param computer computer
     */
    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    /**
     * ����  examList
     * @return examList
     */
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
     * ����  exam
     * @return exam
     */
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
}
