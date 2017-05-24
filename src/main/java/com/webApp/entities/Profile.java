package com.webApp.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "profile")
@XmlAccessorType(XmlAccessType.FIELD)
public class Profile {

    private String userName;

    @XmlElement(name = "ticket")
    private ArrayList<Ticket> tickets;

    public Profile() {}

//    public Profile(Profile profile)

    public Profile(String userName) {
        this.userName = userName;
    }

    public Profile(String userName, ArrayList<Ticket> tickets) {
        this.userName = userName;
        this.tickets = tickets;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }
}
