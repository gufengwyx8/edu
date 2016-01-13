/*
 * @(#)BookDao.java 2014-2-11 обнГ04:17:00 Edu
 */
package com.edu.dao.impl;

import org.springframework.stereotype.Component;

import com.edu.dao.RoomDao;
import com.edu.model.Room;

/**
 * BookDao
 * @author wang
 * @version 1.0
 *
 */
@Component("roomDao")
public class RoomDaoImpl extends BaseDaoImpl<Room> implements RoomDao {

}
