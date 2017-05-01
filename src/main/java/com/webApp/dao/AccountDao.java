package com.webApp.dao;

import com.webApp.entities.User;

import java.util.HashMap;
import java.util.Map;

public class AccountDao {

    private final Map<String, User> loginToProfile;

    public AccountDao() {
        loginToProfile = new HashMap<String,User>();
    }

    public synchronized void  addNewUser(User userProfile) {
        loginToProfile.put(userProfile.getLogin(), userProfile);
    }

    public synchronized User getUserByLogin(String login) {
        return loginToProfile.get(login);
    }


}
