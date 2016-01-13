/*
 * @(#)ArticleService.java 2014-3-19 обнГ03:42:33
 * Eane
 */
package com.edu.service;

import java.util.List;

import com.edu.model.Article;

/**
 * ArticleService
 * @author wang
 * @version 1.0
 *
 */
public interface ArticleService extends BaseService<Article> {
    List<Article> list(Article article);
}
