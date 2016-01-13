/*
 * @(#)BaseServiceImpl.java 2013-2-5 ����10:25:00 bishe
 */
package com.edu.service.impl;

import java.io.Serializable;
import java.util.List;

import com.edu.dao.BaseDao;
import com.edu.service.BaseService;

/**
 * BaseServiceImpl
 * @author wang
 * @version 1.0
 *
 */
public abstract class BaseServiceImpl<E> implements BaseService<E> {

    public void delete(E entity) {
        getBaseDao().delete(entity);
    }

    public E getEntityById(Serializable id) {
        return getBaseDao().getEntityById(id);
    }

    public void save(E entity) {
        getBaseDao().save(entity);
    }

    public void saveOrUpdate(E entity) {
        getBaseDao().saveOrUpdate(entity);
    }

    public void update(E entity) {
        getBaseDao().update(entity);
    }

    @Override
    public List<E> list() {
        return getBaseDao().list();
    }

    protected abstract BaseDao<E> getBaseDao();

    public void save(List<E> list) {
        getBaseDao().save(list);
    }
}