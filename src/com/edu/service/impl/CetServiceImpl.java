/*
 * @(#)BookServiceImpl.java 2014-2-11 ÏÂÎç04:22:43 Edu
 */
package com.edu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.edu.dao.BaseDao;
import com.edu.dao.CetDao;
import com.edu.model.Cet;
import com.edu.model.User;
import com.edu.service.CetService;

/**
 * BookServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("cetService")
public class CetServiceImpl extends BaseServiceImpl<Cet> implements CetService {
    @Resource(name = "cetDao")
    private CetDao cetDao;

    @Override
    protected BaseDao<Cet> getBaseDao() {
        return cetDao;
    }

    @Override
    public List<Cet> listByStudent(User student) {
        return cetDao.listByStudent(student);
    }

}
