/*
 * @(#)BookServiceImpl.java 2014-2-11 ÏÂÎç04:22:43 Edu
 */
package com.edu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.edu.dao.BaseDao;
import com.edu.dao.ClassCourseDao;
import com.edu.model.ClassCourse;
import com.edu.model.Score;
import com.edu.model.User;
import com.edu.service.ClassCourseService;
import com.edu.service.ScoreService;

/**
 * BookServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("classCourseService")
public class ClassCourseServiceImpl extends BaseServiceImpl<ClassCourse> implements ClassCourseService {
    @Resource(name = "classCourseDao")
    private ClassCourseDao classCourseDao;

    @Resource(name = "scoreService")
    private ScoreService scoreService;

    @Override
    protected BaseDao<ClassCourse> getBaseDao() {
        return classCourseDao;
    }

    @Override
    public void delete(ClassCourse classCourse) {
        List<Score> scoreList = scoreService.list();
        for (Score s : scoreList) {
            if (s.getClassCourse().getId().equals(classCourse.getId())) {
                scoreService.delete(s);
            }
        }
        super.delete(classCourse);
    }

    @Override
    public List<ClassCourse> listByTeacher(User teacher) {
        return classCourseDao.listByTeacher(teacher);
    }
}
