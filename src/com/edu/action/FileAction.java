/*
 * @(#)FileAction.java 2014-3-20 下午01:42:07 Eane
 */
package com.edu.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.edu.model.Resource;

/**
 * FileAction
 * @author wang
 * @version 1.0
 *
 */
@Component("fileAction")
@Scope("prototype")
public class FileAction extends BaseAction {

    public static final String UPLOAD_PATH = "/upload";

    private Resource resource;

    private List<Resource> resourceList;

    private File file;

    private String fileFileName;

    private String fileContentType;

    public String listResource() {
        resourceList = resourceService.list();
        return SUCCESS;
    }

    public String addResource() {
        if (file != null) {
            resource.setFileName(fileFileName);
            resourceService.save(resource);
            String realpath = ServletActionContext.getServletContext()
                    .getRealPath(UPLOAD_PATH);
            File newFile = new File(realpath, String.valueOf(resource.getId()));
            try {
                FileUtils.copyFile(file, newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return SUCCESS;
    }

    public InputStream getInputStream() {
        if (file == null) {
            return null;
        }
        try {
            return new FileInputStream(file);
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    public String download() {
        resource = resourceService.getEntityById(resource.getId());
        file = new File(ServletActionContext.getServletContext().getRealPath(
            UPLOAD_PATH), String.valueOf(resource.getId()));
        try {
            fileFileName = new String(resource.getFileName().getBytes(),
                    "iso-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    /**
     * 返回  file
     * @return file
     */
    public File getFile() {
        return file;
    }

    /**
     * 设置 file
     * @param file file
     */
    public void setFile(File file) {
        this.file = file;
    }

    /**
     * 返回  fileFileName
     * @return fileFileName
     */
    public String getFileFileName() {
        return fileFileName;
    }

    /**
     * 设置 fileFileName
     * @param fileFileName fileFileName
     */
    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    /**
     * 返回  fileContentType
     * @return fileContentType
     */
    public String getFileContentType() {
        return fileContentType;
    }

    /**
     * 设置 fileContentType
     * @param fileContentType fileContentType
     */
    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    /**
     * 返回  resource
     * @return resource
     */
    public Resource getResource() {
        return resource;
    }

    /**
     * 设置 resource
     * @param resource resource
     */
    public void setResource(Resource resource) {
        this.resource = resource;
    }

    /**
     * 返回  resourceList
     * @return resourceList
     */
    public List<Resource> getResourceList() {
        return resourceList;
    }

    /**
     * 设置 resourceList
     * @param resourceList resourceList
     */
    public void setResourceList(List<Resource> resourceList) {
        this.resourceList = resourceList;
    }
}
