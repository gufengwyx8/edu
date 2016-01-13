/*
 * @(#)UserService.java 2013-4-10 обнГ12:51:33 Order
 */
package com.edu.service;

import java.util.List;

import com.edu.model.User;
import com.edu.model.UserType;

/**
 * UserService
 * @author wang
 * @version 1.0
 *
 */
public interface UserService extends BaseService<User> {
    User login(User user);

    void regUser(User user);

    List<User> list(UserType type);
}
