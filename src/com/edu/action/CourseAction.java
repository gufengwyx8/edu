/*
 * @(#)CourseAction.java 2014-2-14 下午09:29:39 Edu
 */
package com.edu.action;

import java.util.List;

import org.apache.commons.lang.xwork.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.edu.model.Book;
import com.edu.model.ClassCourse;
import com.edu.model.ClsInfo;
import com.edu.model.Course;
import com.edu.model.Score;
import com.edu.model.User;
import com.edu.model.UserType;

/**
 * CourseAction
 * @author wang
 * @version 1.0
 *
 */
@Component("courseAction")
@Scope("prototype")
public class CourseAction extends BaseAction {
    private List<ClsInfo> clsInfoList;

    private List<Course> courseList;

    private Course course;

    private List<Book> bookList;

    private Book book;

    private Score score;

    private List<Score> scoreList;

    private List<ClassCourse> classCourseList;

    private List<User> studentList;

    public String listCourse() {
        courseList = courseService.list();
        bookList = bookService.list();
        return SUCCESS;
    }

    public String saveCourse() {
        if (course.getBook().getId() == null) {
            course.setBook(null);
        }
        courseList = courseService.list();
        for (Course c : courseList) {
            if (!c.getId().equals(course.getId())
                    && c.getName().equals(course.getName())) {
                msg = "error";
                return SUCCESS;
            }
        }
        courseService.saveOrUpdate(course);
        msg = "success";
        return SUCCESS;
    }

    public String destoryCourse() {
        courseService.delete(course);
        return SUCCESS;
    }

    public String listBook() {
        bookList = bookService.list();
        return SUCCESS;
    }

    public String saveBook() {
        bookList = bookService.list();
        for (Book b : bookList) {
            if (!b.getId().equals(book.getId())
                    && StringUtils.equals(book.getName(), b.getName())) {
                msg = "error";
                return SUCCESS;
            }
        }
        bookService.saveOrUpdate(book);
        msg = "success";
        return SUCCESS;
    }

    public String destoryBook() {
        bookService.delete(book);
        return SUCCESS;
    }

    public String listScore() {
        if (loginUser.getType() == UserType.TEACHER) {
            studentList = userService.list(UserType.STUDENT);
            classCourseList = classCourseService.listByTeacher(loginUser);
            scoreList = scoreService.listByTeacher(loginUser);
        } else if (loginUser.getType() == UserType.STUDENT) {
            scoreList = scoreService.listByStudent(loginUser);
        }
        return SUCCESS;
    }

    public String saveScore() {
        scoreList = scoreService.list();
        for (Score s : scoreList) {
            if (!s.getId().equals(score.getId())
                    && s.getClassCourse().getId().equals(
                        score.getClassCourse().getId())
                    && s.getStudent().getId()
                            .equals(score.getStudent().getId())) {
                msg = "error";
                return SUCCESS;
            }
        }
        scoreService.saveOrUpdate(score);
        msg = "success";
        return SUCCESS;
    }

    public String destoryScore() {
        scoreService.delete(score);
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
     * 返回  bookList
     * @return bookList
     */
    public List<Book> getBookList() {
        return bookList;
    }

    /**
     * 设置 bookList
     * @param bookList bookList
     */
    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    /**
     * 返回  book
     * @return book
     */
    public Book getBook() {
        return book;
    }

    /**
     * 设置 book
     * @param book book
     */
    public void setBook(Book book) {
        this.book = book;
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

}
