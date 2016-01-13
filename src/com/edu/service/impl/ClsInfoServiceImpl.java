/*
 * @(#)BookServiceImpl.java 2014-2-11 обнГ04:22:43 Edu
 */
package com.edu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.edu.dao.BaseDao;
import com.edu.dao.ClsInfoDao;
import com.edu.model.ClsInfo;
import com.edu.service.ClsInfoService;

/**
 * BookServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("clsInfoService")
public class ClsInfoServiceImpl extends BaseServiceImpl<ClsInfo> implements ClsInfoService {
    @Resource(name = "clsInfoDao")
    private ClsInfoDao clsInfoDao;

    @Override
    protected BaseDao<ClsInfo> getBaseDao() {
        return clsInfoDao;
    }

}
