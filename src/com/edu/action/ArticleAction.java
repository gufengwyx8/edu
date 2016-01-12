/*
 * @(#)ArticleAction.java 2014-3-20 下午01:03:31 Eane
 */
package com.edu.action;

import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.edu.model.Article;

/**
 * ArticleAction
 * @author wang
 * @version 1.0
 *
 */
@Component("articleAction")
@Scope("prototype")
public class ArticleAction extends BaseAction {
    private List<Article> articleList;

    private Article article;

    public String listArticle() {
        articleList = articleService.list();
        return SUCCESS;
    }

    public String showArticle() {
        articleList = articleService.list(article);
        article = articleList.get(0);
        if (articleList.size() > 1) {
            articleList = articleList.subList(1, articleList.size());
        } else {
            articleList.clear();
        }
        return SUCCESS;
    }

    public String postArticle() {
        article.setUser(loginUser);
        article.setDate(new Date());
        articleService.save(article);
        if (article.getParent() != null) {
            return "reply";
        }
        return SUCCESS;
    }

    public String removeArticle() {
        for (Article a : articleService.list(article)) {
            if (a.getParent() != null) {
                articleService.delete(a);
            }
        }
        articleService.delete(article);
        return SUCCESS;
    }

    /**
     * 返回  articleList
     * @return articleList
     */
    public List<Article> getArticleList() {
        return articleList;
    }

    /**
     * 设置 articleList
     * @param articleList articleList
     */
    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    /**
     * 返回  article
     * @return article
     */
    public Article getArticle() {
        return article;
    }

    /**
     * 设置 article
     * @param article article
     */
    public void setArticle(Article article) {
        this.article = article;
    }
}
