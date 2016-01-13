/*
 * @(#)Article.java 2014-3-20 ����12:58:44 Eane
 */
package com.edu.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Article
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class Article {
    private Integer id;

    private String title;

    private String content;

    private Article parent;

    private Date date;

    private User user;

    /**
     * ����  id
     * @return id
     */
    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    /**
     * ���� id
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * ����  title
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * ���� title
     * @param title title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * ����  content
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * ���� content
     * @param content content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * ����  parent
     * @return parent
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    public Article getParent() {
        return parent;
    }

    /**
     * ���� parent
     * @param parent parent
     */
    public void setParent(Article parent) {
        this.parent = parent;
    }

    /**
     * ����  date
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * ���� date
     * @param date date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * ����  user
     * @return user
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    /**
     * ���� user
     * @param user user
     */
    public void setUser(User user) {
        this.user = user;
    }

}
