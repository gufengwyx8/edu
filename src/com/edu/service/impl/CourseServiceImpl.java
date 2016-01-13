/*
 * @(#)BookServiceImpl.java 2014-2-11 обнГ04:22:43 Edu
 */
package com.edu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.edu.dao.BaseDao;
import com.edu.dao.CourseDao;
import com.edu.model.Course;
import com.edu.service.CourseService;

/**
 * BookServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("courseService")
public class CourseServiceImpl extends BaseServiceImpl<Course> implements CourseService {
    @Resource(name = "courseDao")
    private CourseDao courseDao;

    @Override
    protected BaseDao<Course> getBaseDao() {
        return courseDao;
    }

}
