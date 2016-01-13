/*
 * @(#)BaseDao.java 2012-11-3 ����05:12:13 Shop-common
 */
package com.edu.dao;

import java.io.Serializable;
import java.util.List;


/**
 * BaseDao DAO����ӿ�
 * @version 1.0
 * @param <T> ��Ӧʵ������
 */
public interface BaseDao<T> {
    /**
     * ����ʵ����Ϣ
     * @param entity ʵ����Ϣ
     */
    void save(T entity);
    
    /**
     * ��������
     * @param list ʵ����Ϣ����
     */
    void save(List<T> list);

    /**
     * ɾ��ʵ����Ϣ
     * @param entity ʵ����Ϣ
     */
    void delete(T entity);

    /**
     * ��������ʵ����Ϣ
     * @param entity ʵ����Ϣ
     */
    void saveOrUpdate(T entity);

    /**
     * ����ʵ����Ϣ
     * @param entity ʵ����Ϣ
     */
    void update(T entity);

    /**
     * ����������ȡʵ����Ϣ
     * @param id ����
     * @return ʵ����Ϣ
     */
    T getEntityById(Serializable id);
    
    /**
     * ��ȡ��������
     * @return ���� 
     */
    List<T> list();
}
