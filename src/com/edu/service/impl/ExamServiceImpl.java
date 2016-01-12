/*
 * @(#)ExamServiceImpl.java 2014-2-11 ÏÂÎç04:22:43 Edu
 */
package com.edu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.edu.dao.BaseDao;
import com.edu.dao.ExamDao;
import com.edu.model.Exam;
import com.edu.service.ExamService;

/**
 * ExamServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("examService")
public class ExamServiceImpl extends BaseServiceImpl<Exam> implements ExamService {
    @Resource(name = "examDao")
    private ExamDao examDao;

    @Override
    protected BaseDao<Exam> getBaseDao() {
        return examDao;
    }

    @Override
    public List<Exam> listFinalExam() {
        return examDao.listFinalExam();
    }

    @Override
    public List<Exam> search(String value) {
        return examDao.search(value);
    }

}
