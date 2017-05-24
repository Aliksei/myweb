package com.webApp.command;

import com.webApp.dao.ProfileDaoXmlImpl;
import com.webApp.entities.Ticket;
import com.webApp.utils.ConfigUtils;

import javax.servlet.http.HttpServletRequest;

public class BuyCommand implements ICommand {

    public String execute(HttpServletRequest request) {

        ProfileDaoXmlImpl profileDao = (ProfileDaoXmlImpl) request.getServletContext().getAttribute("profileDao");

        String filmName = request.getParameter("filmName");
        String price = request.getParameter("price");
        String userName = (String) request.getSession().getAttribute("user");

        profileDao.addTicketToProfile(userName, new Ticket(filmName,price));
        request.getSession().setAttribute("tickets",profileDao.getTickets(userName));

        return  ConfigUtils.getProperty("path.page.main");
    }
}
