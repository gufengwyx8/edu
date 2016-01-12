/*
 * @(#)Course.java 2014-2-11 ����03:51:02 Edu
 */
package com.edu.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Course
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class Course {
    private Integer id;

    private String name;

    private Integer hours;

    private Double score;

    private Book book;

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
     * ����  name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * ���� name
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ����  hours
     * @return hours
     */
    public Integer getHours() {
        return hours;
    }

    /**
     * ���� hours
     * @param hours hours
     */
    public void setHours(Integer hours) {
        this.hours = hours;
    }

    /**
     * ����  score
     * @return score
     */
    public Double getScore() {
        return score;
    }

    /**
     * ���� score
     * @param score score
     */
    public void setScore(Double score) {
        this.score = score;
    }

    /**
     * ����  book
     * @return book
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    public Book getBook() {
        return book;
    }

    /**
     * ���� book
     * @param book book
     */
    public void setBook(Book book) {
        this.book = book;
    }
}
