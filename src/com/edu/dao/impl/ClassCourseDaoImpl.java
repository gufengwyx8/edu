/*
 * @(#)BookDao.java 2014-2-11 ÏÂÎç04:17:00 Edu
 */
package com.edu.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.edu.dao.ClassCourseDao;
import com.edu.model.ClassCourse;
import com.edu.model.User;

/**
 * BookDao
 * @author wang
 * @version 1.0
 *
 */
@Component("classCourseDao")
public class ClassCourseDaoImpl extends BaseDaoImpl<ClassCourse> implements ClassCourseDao {

    @Override
    public List<ClassCourse> listByTeacher(User teacher) {
        String hql = "from ClassCourse c where c.teacher = ?";
        Object[] params = { teacher };
        return this.list(ClassCourse.class, hql, params);
    }

    @Override
    public List<ClassCourse> listByStudent(User student) {
        String hql = "from ClassCourse c where c.teacher = ?";
        Object[] params = { student };
        return this.list(ClassCourse.class, hql, params);
    }

}
