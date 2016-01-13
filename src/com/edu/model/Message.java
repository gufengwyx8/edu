/*
 * @(#)Message.java 2014-4-17 下午05:00:57
 * Edu
 */
package com.edu.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * Message
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class Message {
    private Integer id;
    
    private String title;
    
    private String content;
    
    private Date date;

    /**
     * 返回  id
     * @return id
     */
    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    /**
     * 设置 id
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 返回  title
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置 title
     * @param title title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 返回  content
     * @return content
     */
    @Lob
    public String getContent() {
        return content;
    }

    /**
     * 设置 content
     * @param content content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 返回  date
     * @return date
     */
    public Date getDate() {
        return date;
    }

    /**
     * 设置 date
     * @param date date
     */
    public void setDate(Date date) {
        this.date = date;
    }
}
