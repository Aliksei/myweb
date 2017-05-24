package com.webApp.entities;

public class Ticket {

    private String filmName;
    private String price;

    public Ticket() {
    }

    public Ticket(String filmName, String price) {
        this.filmName = filmName;
        this.price = price;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
