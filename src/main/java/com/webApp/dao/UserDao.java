package com.webApp.dao;

import com.webApp.entities.User;

public interface UserDao {

    void createUser(User user);

    User getUserByLogin(String login);
}
