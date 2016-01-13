/*
 * @(#)BookServiceImpl.java 2014-2-11 ÏÂÎç04:22:43 Edu
 */
package com.edu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.edu.dao.BaseDao;
import com.edu.dao.ComputerDao;
import com.edu.model.Computer;
import com.edu.model.User;
import com.edu.service.ComputerService;

/**
 * BookServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("computerService")
public class ComputerServiceImpl extends BaseServiceImpl<Computer> implements ComputerService {
    @Resource(name = "computerDao")
    private ComputerDao computerDao;

    @Override
    protected BaseDao<Computer> getBaseDao() {
        return computerDao;
    }

    @Override
    public List<Computer> listByStudent(User student) {
        return computerDao.listByStudent(student);
    }

}
