/*
 * @(#)BookService.java 2014-2-11 обнГ04:20:57 Edu
 */
package com.edu.service;

import java.util.List;

import com.edu.model.Schedule;

/**
 * BookService
 * @author wang
 * @version 1.0
 *
 */
public interface ScheduleService extends BaseService<Schedule> {
    String avaliable(Schedule schedule);

    List<Schedule> search(String msg);
}
