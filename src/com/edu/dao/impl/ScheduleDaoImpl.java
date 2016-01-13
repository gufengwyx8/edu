/*
 * @(#)BookDao.java 2014-2-11 ÏÂÎç04:17:00 Edu
 */
package com.edu.dao.impl;

import java.util.List;

import org.apache.commons.lang.xwork.math.NumberUtils;
import org.springframework.stereotype.Component;

import com.edu.dao.ScheduleDao;
import com.edu.model.Schedule;

/**
 * BookDao
 * @author wang
 * @version 1.0
 *
 */
@Component("scheduleDao")
public class ScheduleDaoImpl extends BaseDaoImpl<Schedule> implements ScheduleDao {

    @Override
    public List<Schedule> search(String msg) {
        String hql = "select s from Schedule s where s.classCourse.teacher.id = ? "
                + "or s.classCourse.teacher.name like ? "
                + "or s.classCourse.clsInfo.name like ? "
                + "or s.classCourse.course.name like ? "
                + "or s.room.name like ? " + "or s.classCourse.year = ?";
        Object[] params = { NumberUtils.toInt(msg), getLikeString(msg),
                getLikeString(msg), getLikeString(msg), getLikeString(msg),
                NumberUtils.toInt(msg) };
        return this.list(Schedule.class, hql, params);
    }

}
