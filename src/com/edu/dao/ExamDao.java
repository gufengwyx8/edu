/*
 * @(#)CetDao.java 2014-2-11 обнГ04:14:58
 * Edu
 */
package com.edu.dao;

import java.util.List;

import com.edu.model.Exam;

/**
 * CetDao
 * @author wang
 * @version 1.0
 *
 */
public interface ExamDao extends BaseDao<Exam> {
    List<Exam> listFinalExam();
    
    List<Exam> search(String value);
}
