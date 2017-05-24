package com.webApp.storageBeans;

import com.webApp.entities.Profile;
import com.webApp.entities.Ticket;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "profiles")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProfileStorage {

    @XmlElement(name = "profile")
    private List<Profile> profiles = new ArrayList<Profile>();

    public void addTicketToProfile(final String userName,final Ticket ticket){
        int index = -1;
        ArrayList<Ticket> tickets = null;
        for (Profile profile : profiles){
            if (profile.getUserName().equals(userName)){
                index = profiles.indexOf(profile);
                tickets = profile.getTickets();
                break;
            }
        }
        if (tickets==null){
            tickets = new ArrayList<Ticket>();
        }
        tickets.add(ticket);
        profiles.set(index,new Profile(userName,tickets));
    }

    public void addProfile(final String userName){
        profiles.add(new Profile(userName));
    }

    public List<Ticket> getTicketByProfile(final String userName) {
        ArrayList<Ticket> tickets = null;
        for (Profile profile : profiles){
            if (profile.getUserName().equals(userName)){
                tickets = profile.getTickets();
                break;
            }
        }
        return tickets;
    }

}
