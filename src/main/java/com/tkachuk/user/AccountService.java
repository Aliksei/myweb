package com.tkachuk.user;

import java.util.HashMap;
import java.util.Map;

public class AccountService {

    private final Map<String, User> loginToProfile;
    private final Map<String, User> sessionIdToProfile;

    public AccountService() {
        loginToProfile = new HashMap<String,User>();
        sessionIdToProfile = new HashMap<String, User>();
    }

    public synchronized void  addNewUser(User userProfile) {
        loginToProfile.put(userProfile.getLogin(), userProfile);
    }

    public synchronized User getUserByLogin(String login) {
        return loginToProfile.get(login);
    }

    public synchronized User getUserBySessionId(String sessionId) {
        return sessionIdToProfile.get(sessionId);
    }

    public synchronized void addSession(String sessionId, User userProfile) {
        sessionIdToProfile.put(sessionId, userProfile);
    }

    public synchronized void deleteSession(String sessionId) {
        sessionIdToProfile.remove(sessionId);
    }

}
