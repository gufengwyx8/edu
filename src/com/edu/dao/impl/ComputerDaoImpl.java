/*
 * @(#)BookDao.java 2014-2-11 обнГ04:17:00 Edu
 */
package com.edu.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.edu.dao.ComputerDao;
import com.edu.model.Computer;
import com.edu.model.User;

/**
 * BookDao
 * @author wang
 * @version 1.0
 *
 */
@Component("computerDao")
public class ComputerDaoImpl extends BaseDaoImpl<Computer> implements ComputerDao {

    @Override
    public List<Computer> listByStudent(User student) {
        String hql = "from Computer c where c.student = ?";
        Object[] params = { student };
        return this.list(Computer.class, hql, params);
    }
}
