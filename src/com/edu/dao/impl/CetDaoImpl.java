/*
 * @(#)BookDao.java 2014-2-11 обнГ04:17:00 Edu
 */
package com.edu.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.edu.dao.CetDao;
import com.edu.model.Cet;
import com.edu.model.User;

/**
 * BookDao
 * @author wang
 * @version 1.0
 *
 */
@Component("cetDao")
public class CetDaoImpl extends BaseDaoImpl<Cet> implements CetDao {

    @Override
    public List<Cet> listByStudent(User student) {
        String hql = "from Cet c where c.student = ?";
        Object[] params = { student };
        return this.list(Cet.class, hql, params);
    }

}
