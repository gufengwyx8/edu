/*
 * @(#)BookDao.java 2014-2-11 ÏÂÎç04:17:00 Edu
 */
package com.edu.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.edu.dao.ScoreDao;
import com.edu.model.Score;
import com.edu.model.User;

/**
 * BookDao
 * @author wang
 * @version 1.0
 *
 */
@Component("scoreDao")
public class ScoreDaoImpl extends BaseDaoImpl<Score> implements ScoreDao {

    @Override
    public List<Score> listByTeacher(User teacher) {
        String hql = "from Score s where s.classCourse.teacher = ?";
        Object[] params = { teacher };
        return this.list(Score.class, hql, params);
    }

    @Override
    public List<Score> listByStudent(User student) {
        String hql = "from Score s where s.student = ?";
        Object[] params = { student };
        return this.list(Score.class, hql, params);
    }

}
