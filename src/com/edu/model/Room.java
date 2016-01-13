/*
 * @(#)Room.java 2014-2-11 下午03:56:07 Edu
 */
package com.edu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Room
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class Room {
    private Integer id;

    private String name;

    private String main;

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
     * 返回  name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 name
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 返回  main
     * @return main
     */
    public String getMain() {
        return main;
    }

    /**
     * 设置 main
     * @param main main
     */
    public void setMain(String main) {
        this.main = main;
    }
}
