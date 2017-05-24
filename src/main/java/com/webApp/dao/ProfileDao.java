package com.webApp.dao;

import com.webApp.entities.Ticket;

import java.util.List;

public interface ProfileDao {

    void createProfile(String userName);

    void addTicketToProfile(String userName, Ticket ticket);

    List<Ticket> getTickets(final String userName);

}
