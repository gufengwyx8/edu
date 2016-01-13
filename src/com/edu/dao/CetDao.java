/*
 * @(#)CetDao.java 2014-2-11 обнГ04:14:58
 * Edu
 */
package com.edu.dao;

import java.util.List;

import com.edu.model.Cet;
import com.edu.model.User;

/**
 * CetDao
 * @author wang
 * @version 1.0
 *
 */
public interface CetDao extends BaseDao<Cet> {
    List<Cet> listByStudent(User student);
}
