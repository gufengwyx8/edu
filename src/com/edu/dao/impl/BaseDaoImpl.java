/*
 * @(#)BaseDao.java 2012-10-31 ����04:00:59 ShopService
 */
package com.edu.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.edu.dao.BaseDao;
import com.edu.util.PagerCallBack;

/**
 * BaseDao DAO������
 * @version 1.0
 * @param <E> DAO����
 */
public class BaseDaoImpl<E> implements BaseDao<E> {

    /** HibernateTemplate */
    @Resource(name = "hibernateTemplate")
    protected HibernateTemplate hibernateTemplate;

    /**
     * ��ȡģ����ѯ�ַ���%%
     * @param str ��ѯ�ַ���
     * @return ģ����ѯ�ַ���
     */
    public String getLikeString(String str) {
        return "%" + str + "%";
    }

    /**
     * ����  hibernateTemplate
     * @return hibernateTemplate
     */
    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    /**
     * ���� hibernateTemplate
     * @param hibernateTemplate hibernateTemplate
     */
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    /**
     * ���ݲ�ѯHQL�������ض����󼯺�
     * @param <T> ��������
     * @param cls ��������Class
     * @param hql ��ѯHQL
     * @return �ض����󼯺�
     */
    @SuppressWarnings("unchecked")
    public <T> List<T> list(Class<T> cls, String hql) {
        List result = hibernateTemplate.find(hql);
        return (List<T>) result;
    }

    /**
     * ���ݲ�ѯHQL�������ض����󼯺�
     * @param <T> ��������
     * @param cls ��������Class
     * @param hql ��ѯHQL
     * @param params HQL���� 
     * @return �ض����󼯺�
     */
    @SuppressWarnings("unchecked")
    public <T> List<T> list(Class<T> cls, String hql, Object[] params) {
        List result = hibernateTemplate.find(hql, params);
        return (List<T>) result;
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> list(Class<T> cls, String hql, Object[] params,
            int pageNo, int pageSize) {
        return (List<T>) hibernateTemplate.executeFind(new PagerCallBack(
                pageNo, pageSize, hql, params));
    }

    /**
     * ���ݲ�ѯHQL�������ض����������е�һ����������޽���򷵻�null
     * @param <T> ��������
     * @param cls ��������Class
     * @param hql ��ѯHQL
     * @return �ض�������
     */
    @SuppressWarnings("unchecked")
    public <T> T find(Class<T> cls, String hql) {
        List result = hibernateTemplate.find(hql);
        if (result.size() > 0) {
            return (T) result.get(0);
        }
        return null;
    }

    /**
     * ���ݲ�ѯHQL�������ض����������е�һ����������޽���򷵻�null
     * @param <T> ��������
     * @param cls ��������Class
     * @param hql ��ѯHQL
     * @param params HQL����
     * @return �ض�������
     */
    @SuppressWarnings("unchecked")
    public <T> T find(Class<T> cls, String hql, Object[] params) {
        List result = hibernateTemplate.find(hql, params);
        if (result.size() > 0) {
            return (T) result.get(0);
        }
        return null;
    }

    /**
     * ��������ɾ��ʵ��
     * @param entity ʵ�����
     */
    public void delete(E entity) {
        hibernateTemplate.clear();
        hibernateTemplate.delete(entity);
    }

    /**
     * ����������ȡʵ�����
     * @param id ����
     * @return ʵ�����
     */
    @SuppressWarnings("unchecked")
    public E getEntityById(Serializable id) {
        Class<E> entityClass = (Class<E>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
        return (E) hibernateTemplate.get(entityClass, id);
    }

    /**
     * ����ʵ�嵽���ݿ���
     * @param entity ʵ�����
     */
    public void save(E entity) {
        hibernateTemplate.save(entity);
    }

    /**
     * ��������ʵ�嵽���ݿ���
     * @param entity ʵ�����
     */
    public void saveOrUpdate(E entity) {
        hibernateTemplate.clear();
        hibernateTemplate.saveOrUpdate(entity);
    }

    /**
     * ����ʵ�嵽���ݿ���
     * @param entity ʵ�����
     */
    public void update(E entity) {
        hibernateTemplate.clear();
        hibernateTemplate.update(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<E> list() {
        Class<E> entityClass = (Class<E>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
        return this.list(entityClass, "from " + entityClass.getSimpleName());
    }

    @Override
    public void save(final List<E> list) {
        hibernateTemplate.execute(new HibernateCallback<Object>() {

            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                int i = 0;
                for (E e : list) {
                    session.save(e);
                    if (i++ > 500) {
                        session.flush();
                        session.clear();
                    }
                }
                return null;
            }
        });
    }
}
