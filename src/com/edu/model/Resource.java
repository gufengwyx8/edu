/*
 * @(#)Resource.java 2014-4-17 下午05:04:26 Edu
 */
package com.edu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Resource
 * @author wang
 * @version 1.0
 *
 */
@Entity
public class Resource {
    private Integer id;

    private String title;

    private String filePath;

    private String fileName;

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
     * 返回  filePath
     * @return filePath
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * 设置 filePath
     * @param filePath filePath
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * 返回  fileName
     * @return fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 设置 fileName
     * @param fileName fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
