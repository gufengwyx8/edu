/*
 * @(#)BookDao.java 2014-2-11 обнГ04:17:00 Edu
 */
package com.edu.dao.impl;

import org.springframework.stereotype.Component;

import com.edu.dao.ClsInfoDao;
import com.edu.model.ClsInfo;

/**
 * BookDao
 * @author wang
 * @version 1.0
 *
 */
@Component("clsInfoDao")
public class ClsInfoDaoImpl extends BaseDaoImpl<ClsInfo> implements ClsInfoDao {

}
