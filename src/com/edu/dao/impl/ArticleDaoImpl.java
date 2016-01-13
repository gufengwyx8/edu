/*
 * @(#)ArticleDaoImpl.java 2014-3-19 ÏÂÎç03:41:12 Eane
 */
package com.edu.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.edu.dao.ArticleDao;
import com.edu.model.Article;

/**
 * ArticleDaoImpl
 * @author wang
 * @version 1.0
 *
 */
@Component("articleDao")
public class ArticleDaoImpl extends BaseDaoImpl<Article> implements ArticleDao {

    @Override
    public List<Article> list() {
        String hql = "from Article a where a.parent is null order by a.date desc";
        return this.list(Article.class, hql);
    }

    @Override
    public List<Article> list(Article article) {
        String hql = "from Article a where a = ? or a.parent = ? order by a.date asc";
        Object[] params = { article, article };
        return this.list(Article.class, hql, params);
    }

}
