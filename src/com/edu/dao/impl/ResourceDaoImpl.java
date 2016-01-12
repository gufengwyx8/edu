/*
 * @(#)ResourceDao.java 2014-2-11 обнГ04:17:00 Edu
 */
package com.edu.dao.impl;

import org.springframework.stereotype.Component;

import com.edu.dao.ResourceDao;
import com.edu.model.Resource;

/**
 * ResourceDao
 * @author wang
 * @version 1.0
 *
 */
@Component("resourceDao")
public class ResourceDaoImpl extends BaseDaoImpl<Resource> implements ResourceDao {

}
