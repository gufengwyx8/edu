/*
 * @(#)Resource.java 2014-4-17 ����05:04:26 Edu
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
     * ����  filePath
     * @return filePath
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * ���� filePath
     * @param filePath filePath
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * ����  fileName
     * @return fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * ���� fileName
     * @param fileName fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
