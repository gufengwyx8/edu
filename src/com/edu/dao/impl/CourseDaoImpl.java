/*
 * @(#)BookDao.java 2014-2-11 обнГ04:17:00 Edu
 */
package com.edu.dao.impl;

import org.springframework.stereotype.Component;

import com.edu.dao.CourseDao;
import com.edu.model.Course;

/**
 * BookDao
 * @author wang
 * @version 1.0
 *
 */
@Component("courseDao")
public class CourseDaoImpl extends BaseDaoImpl<Course> implements CourseDao {

}
