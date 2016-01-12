/*
 * @(#)BookDao.java 2014-2-11 ÏÂÎç04:17:00 Edu
 */
package com.edu.dao.impl;

import java.util.List;

import org.apache.commons.lang.xwork.math.NumberUtils;
import org.springframework.stereotype.Component;

import com.edu.dao.ExamDao;
import com.edu.model.Exam;

/**
 * BookDao
 * @author wang
 * @version 1.0
 *
 */
@Component("examDao")
public class ExamDaoImpl extends BaseDaoImpl<Exam> implements ExamDao {

    @Override
    public List<Exam> listFinalExam() {
        String hql = "from Exam e where e.classCourse is not null";
        return this.list(Exam.class, hql);
    }

    @Override
    public List<Exam> search(String value) {
        String hql = "from Exam e where e.classCourse.teacher.id = ? "
                + "or e.classCourse.teacher.name like ? "
                + "or e.classCourse.clsInfo.name like ? "
                + "or e.classCourse.course.name like ? "
                + "or e.room.name like ? " + "or e.classCourse.year = ?";
        Object[] params = { NumberUtils.toInt(value), getLikeString(value),
                getLikeString(value), getLikeString(value),
                getLikeString(value), NumberUtils.toInt(value) };
        return this.list(Exam.class, hql, params);
    }

}
