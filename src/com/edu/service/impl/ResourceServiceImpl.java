/*
 * @(#)ResourceServiceImpl.java 2014-2-11 обнГ04:22:43 Edu
 */
package com.edu.service.impl;

import org.springframework.stereotype.Component;

import com.edu.dao.BaseDao;
import com.edu.dao.ResourceDao;
import com.edu.model.Resource;
import com.edu.service.ResourceService;

/**
 * ResourceServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("resourceService")
public class ResourceServiceImpl extends BaseServiceImpl<Resource> implements ResourceService {
    @javax.annotation.Resource(name = "resourceDao")
    private ResourceDao resourceDao;

    @Override
    protected BaseDao<Resource> getBaseDao() {
        return resourceDao;
    }

}
