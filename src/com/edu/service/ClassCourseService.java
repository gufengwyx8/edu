/*
 * @(#)BookService.java 2014-2-11 обнГ04:20:57
 * Edu
 */
package com.edu.service;

import java.util.List;

import com.edu.model.ClassCourse;
import com.edu.model.User;


/**
 * BookService
 * @author wang
 * @version 1.0
 *
 */
public interface ClassCourseService extends BaseService<ClassCourse> {
    List<ClassCourse> listByTeacher(User teacher);
}
