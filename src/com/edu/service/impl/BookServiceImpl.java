/*
 * @(#)BookServiceImpl.java 2014-2-11 обнГ04:22:43 Edu
 */
package com.edu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.edu.dao.BaseDao;
import com.edu.dao.BookDao;
import com.edu.model.Book;
import com.edu.service.BookService;

/**
 * BookServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("bookService")
public class BookServiceImpl extends BaseServiceImpl<Book> implements BookService {
    @Resource(name = "bookDao")
    private BookDao bookDao;

    @Override
    protected BaseDao<Book> getBaseDao() {
        return bookDao;
    }

}
