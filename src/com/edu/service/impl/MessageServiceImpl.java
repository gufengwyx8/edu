/*
 * @(#)MessageServiceImpl.java 2014-2-11 обнГ04:22:43 Edu
 */
package com.edu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.edu.dao.BaseDao;
import com.edu.dao.MessageDao;
import com.edu.model.Message;
import com.edu.service.MessageService;

/**
 * MessageServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("messageService")
public class MessageServiceImpl extends BaseServiceImpl<Message> implements MessageService {
    @Resource(name = "messageDao")
    private MessageDao messageDao;

    @Override
    protected BaseDao<Message> getBaseDao() {
        return messageDao;
    }

}
