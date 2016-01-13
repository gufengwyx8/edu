/*
 * @(#)ArticleServiceImpl.java 2014-3-19 ÏÂÎç03:43:13 Eane
 */
package com.edu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.edu.dao.ArticleDao;
import com.edu.dao.BaseDao;
import com.edu.model.Article;
import com.edu.service.ArticleService;

/**
 * ArticleServiceImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("articleService")
public class ArticleServiceImpl extends BaseServiceImpl<Article> implements ArticleService {

    @Resource(name = "articleDao")
    private ArticleDao articleDao;

    @Override
    protected BaseDao<Article> getBaseDao() {
        return articleDao;
    }

    @Override
    public List<Article> list(Article article) {
        return articleDao.list(article);
    }

}
