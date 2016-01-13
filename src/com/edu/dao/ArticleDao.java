/*
 * @(#)ArticleDao.java 2014-3-19 ����03:39:04 Eane
 */
package com.edu.dao;

import java.util.List;

import com.edu.model.Article;

/**
 * ArticleDao
 * @author wang
 * @version 1.0
 *
 */
public interface ArticleDao extends BaseDao<Article> {
    List<Article> list(Article article);
}
