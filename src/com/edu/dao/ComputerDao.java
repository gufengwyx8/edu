/*
 * @(#)CetDao.java 2014-2-11 обнГ04:14:58
 * Edu
 */
package com.edu.dao;

import java.util.List;

import com.edu.model.Computer;
import com.edu.model.User;

/**
 * CetDao
 * @author wang
 * @version 1.0
 *
 */
public interface ComputerDao extends BaseDao<Computer> {
    List<Computer> listByStudent(User student);
}
