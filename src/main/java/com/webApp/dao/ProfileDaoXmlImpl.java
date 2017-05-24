package com.webApp.dao;

import com.webApp.entities.Ticket;
import com.webApp.storageBeans.ProfileStorage;
import com.webApp.utils.XmlUtils;

import java.util.List;

public class ProfileDaoXmlImpl implements ProfileDao{

    private static ProfileStorage profileStorage = new ProfileStorage();

    private static final String PROFILE_RESOURCE_PATH = "src\\main\\resources\\storages\\profiles.xml";

    public ProfileDaoXmlImpl() {
        profileStorage = XmlUtils.unmarshalBeen(ProfileStorage.class, PROFILE_RESOURCE_PATH);
    }

    public void createProfile(final String userName){
        synchronized (profileStorage){
            profileStorage.addProfile(userName);
            XmlUtils.marshalBeen(profileStorage,ProfileStorage.class, PROFILE_RESOURCE_PATH);
        }
    }

    public void addTicketToProfile(final String userName, Ticket ticket){
        synchronized (profileStorage){
            profileStorage.addTicketToProfile(userName, ticket);
            XmlUtils.marshalBeen(profileStorage,ProfileStorage.class, PROFILE_RESOURCE_PATH);
        }
    }

    public List<Ticket> getTickets(final String userName){
        synchronized (profileStorage){
            return profileStorage.getTicketByProfile(userName);
        }
    }

}
