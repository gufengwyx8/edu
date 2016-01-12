/*
 * @(#)roomServiceImpl.java 2014-2-11 обнГ04:22:43 Edu
 */
package com.edu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.edu.dao.BaseDao;
import com.edu.dao.RoomDao;
import com.edu.model.Room;
import com.edu.service.RoomService;

/**
 * roomServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("roomService")
public class RoomServiceImpl extends BaseServiceImpl<Room> implements RoomService {
    @Resource(name = "roomDao")
    private RoomDao roomDao;

    @Override
    protected BaseDao<Room> getBaseDao() {
        return roomDao;
    }

}
