/*
 * @(#)ScheduleServiceImpl.java 2014-2-11 ÏÂÎç04:22:43 Edu
 */
package com.edu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.edu.dao.BaseDao;
import com.edu.dao.ScheduleDao;
import com.edu.model.ClassCourse;
import com.edu.model.Schedule;
import com.edu.service.ClassCourseService;
import com.edu.service.ScheduleService;

/**
 * ScheduleServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("scheduleService")
public class ScheduleServiceImpl extends BaseServiceImpl<Schedule> implements ScheduleService {
    @Resource(name = "scheduleDao")
    private ScheduleDao scheduleDao;

    @Resource(name = "classCourseService")
    private ClassCourseService classCourseService;

    @Override
    protected BaseDao<Schedule> getBaseDao() {
        return scheduleDao;
    }

    @Override
    public String avaliable(Schedule schedule) {
        List<Schedule> list = this.list();
        for (Schedule s : list) {
            if (!s.getId().equals(schedule.getId())
                    && s.getWeekday().equals(schedule.getWeekday())
                    && s.getNumber().equals(schedule.getNumber())) {
                ClassCourse cc = classCourseService.getEntityById(schedule
                        .getClassCourse().getId());
                if (s.getRoom().getId().equals(schedule.getRoom().getId())) {
                    return "room";
                } else if (s.getClassCourse().getTeacher().getId().equals(
                    cc.getTeacher().getId())) {
                    return "teacher";
                } else if (s.getClassCourse().getClsInfo().getId().equals(
                    cc.getClsInfo().getId())) {
                    return "clsInfo";
                }
            }
        }
        return null;
    }

    @Override
    public List<Schedule> search(String msg) {
        return scheduleDao.search(msg);
    }

}
