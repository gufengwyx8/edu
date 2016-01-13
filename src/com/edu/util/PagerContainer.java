/*
 * @(#)PagerContainer.java 2013-2-6 ����02:57:30 bishe
 */
package com.edu.util;

import java.util.ArrayList;
import java.util.List;

/**
 * PagerContainer
 * @author wang
 * @version 1.0
 *
 */
public class PagerContainer<T> {
    private List<T> data;

    private Integer pageNo;

    private Integer pageSize;

    public int getMaxPage() {
        if (data.size() % pageSize == 0) {
            return data.size() / pageSize;
        }
        return data.size() / pageSize + 1;
    }

    public List<T> getPagerData() {
        if (data == null) {
            return null;
        }
        List<T> result = new ArrayList<T>();
        result.addAll(data.subList((pageNo - 1) * pageSize, Math.min(data
                .size(), pageNo * pageSize)));
        return result;
    }

    public int getStartPage() {
        if (pageNo < 3) {
            return 1;
        } else if (pageNo > getMaxPage() - 2) {
            return getMaxPage() - 4;
        }
        return pageNo - 2;
    }

    /**
     * ����  data
     * @return data
     */
    public List<T> getData() {
        return data;
    }

    /**
     * ���� data
     * @param data data
     */
    public void setData(List<T> data) {
        this.data = data;
    }

    /**
     * ����  pageNo
     * @return pageNo
     */
    public Integer getPageNo() {
        return pageNo;
    }

    /**
     * ���� pageNo
     * @param pageNo pageNo
     */
    public void setPageNo(Integer pageNo) {
        if (pageNo == null || pageNo <= 0) {
            pageNo = 1;
        }
        this.pageNo = pageNo;
    }

    /**
     * ����  pageSize
     * @return pageSize
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * ���� pageSize
     * @param pageSize pageSize
     */
    public void setPageSize(Integer pageSize) {
        if (pageSize == null) {
            pageSize = 10;
        }
        this.pageSize = pageSize;
    }

    /**
     * ����  count
     * @return count
     */
    public int getCount() {
        return data.size();
    }

}