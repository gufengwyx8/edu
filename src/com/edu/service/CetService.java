/*
 * @(#)BookService.java 2014-2-11 обнГ04:20:57
 * Edu
 */
package com.edu.service;

import java.util.List;

import com.edu.model.Cet;
import com.edu.model.User;

/**
 * BookService
 * @author wang
 * @version 1.0
 *
 */
public interface CetService extends BaseService<Cet> {
    List<Cet> listByStudent(User student);
}
