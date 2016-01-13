/*
 * @(#)CetDao.java 2014-2-11 обнГ04:14:58
 * Edu
 */
package com.edu.dao;

import java.util.List;

import com.edu.model.Schedule;

/**
 * CetDao
 * @author wang
 * @version 1.0
 *
 */
public interface ScheduleDao extends BaseDao<Schedule> {
    List<Schedule> search(String msg);
}
