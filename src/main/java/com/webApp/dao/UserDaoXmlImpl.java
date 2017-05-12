package com.webApp.dao;

import com.webApp.entities.User;
import com.webApp.storageBeans.UserStorage;
import com.webApp.utils.XmlUtils;

import java.util.List;

public class UserDaoXmlImpl implements UserDao {

    private static UserStorage userStorage;
    private static final String USERS_RESOURCE_PATH = "src\\main\\resources\\storages\\users.xml";

    public UserDaoXmlImpl() {
        userStorage = XmlUtils.unmarshalBeen(UserStorage.class,USERS_RESOURCE_PATH);
    }

    @Override
    public void createUser(User user){
        synchronized (userStorage){
            userStorage.setUser(user);
            XmlUtils.marshalBeen(userStorage,UserStorage.class,USERS_RESOURCE_PATH);
        }
    }

    @Override
    public synchronized User getUserByLogin(String login) {
        List<User> list;
        synchronized (userStorage){
           list = XmlUtils.unmarshalBeen(UserStorage.class,USERS_RESOURCE_PATH).getUsers();
        }
        for (User user : list){
            if (user.getLogin().equals(login)){
                return user;
            }
        }
        return null;
    }

}
