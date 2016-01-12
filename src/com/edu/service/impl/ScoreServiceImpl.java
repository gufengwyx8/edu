/*
 * @(#)ScoreServiceImpl.java 2014-2-11 ÏÂÎç04:22:43 Edu
 */
package com.edu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.edu.dao.BaseDao;
import com.edu.dao.ScoreDao;
import com.edu.model.Score;
import com.edu.model.User;
import com.edu.service.ScoreService;

/**
 * ScoreServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("scoreService")
public class ScoreServiceImpl extends BaseServiceImpl<Score> implements ScoreService {
    @Resource(name = "scoreDao")
    private ScoreDao scoreDao;

    @Override
    protected BaseDao<Score> getBaseDao() {
        return scoreDao;
    }

    @Override
    public List<Score> listByTeacher(User teacher) {
        return scoreDao.listByTeacher(teacher);
    }

    @Override
    public List<Score> listByStudent(User student) {
        return scoreDao.listByStudent(student);
    }

}
