/*
 * @(#)BookService.java 2014-2-11 обнГ04:20:57
 * Edu
 */
package com.edu.service;

import java.util.List;

import com.edu.model.Exam;

/**
 * BookService
 * @author wang
 * @version 1.0
 *
 */
public interface ExamService extends BaseService<Exam> {
    List<Exam> listFinalExam();
    
    List<Exam> search(String value);
}
