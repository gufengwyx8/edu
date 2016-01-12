/*
 * @(#)BookDao.java 2014-2-11 обнГ04:17:00 Edu
 */
package com.edu.dao.impl;

import org.springframework.stereotype.Component;

import com.edu.dao.BookDao;
import com.edu.model.Book;

/**
 * BookDao
 * @author wang
 * @version 1.0
 *
 */
@Component("bookDao")
public class BookDaoImpl extends BaseDaoImpl<Book> implements BookDao {

}
