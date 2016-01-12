/*
 * @(#)UserAction.java 2014-2-15 下午07:26:58 Edu
 */
package com.edu.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.edu.model.User;
import com.edu.model.UserType;
import com.mysql.jdbc.StringUtils;

/**
 * UserAction
 * @author wang
 * @version 1.0
 *
 */
@Component("userAction")
@Scope("prototype")
public class UserAction extends BaseAction {
    private List<User> userList;

    private String type;

    public String listUser() {
        if (StringUtils.isNullOrEmpty(type)) {
            userList = userService.list();
        } else if (type != null) {
            userList = userService.list(UserType.valueOf(type));
        }
        return SUCCESS;
    }

    public String saveUser() {
        userList = userService.list();
        for (User u : userList) {
            if (!u.getId().equals(user.getId())
                    && u.getName().equals(user.getName())) {
                msg = "error";
                return SUCCESS;
            }
        }
        userService.saveOrUpdate(user);
        msg = "success";
        return SUCCESS;
    }

    public String destoryUser() {
        userService.delete(user);
        return SUCCESS;
    }

    /**
     * 返回  userList
     * @return userList
     */
    public List<User> getUserList() {
        return userList;
    }

    /**
     * 设置 userList
     * @param userList userList
     */
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    /**
     * 返回  type
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * 设置 type
     * @param type type
     */
    public void setType(String type) {
        this.type = type;
    }
}
