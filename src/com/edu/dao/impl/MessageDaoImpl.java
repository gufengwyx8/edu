/*
 * @(#)MessageDao.java 2014-2-11 обнГ04:17:00 Edu
 */
package com.edu.dao.impl;

import org.springframework.stereotype.Component;

import com.edu.dao.MessageDao;
import com.edu.model.Message;

/**
 * MessageDao
 * @author wang
 * @version 1.0
 *
 */
@Component("messageDao")
public class MessageDaoImpl extends BaseDaoImpl<Message> implements MessageDao {

}
