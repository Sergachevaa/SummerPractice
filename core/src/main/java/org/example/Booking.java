package org.example;

import java.time.format.DateTimeFormatter;

public class Booking {
    private User user;
    private Session session;
    private int row;
    private int seat;
    private double price;

    public Booking(User user, Session session, int row, int seat, double price) {
        this.user = user;
        this.session = session;
        this.row = row;
        this.seat = seat;
        this.price = price;
    }

    public void printTicket() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        String formattedDateTime = session.getDateTime().format(formatter);

        System.out.println("Билет");
        System.out.println("Имя: " + user.getName());
        System.out.println("Фильм: " + session.getMovie().getTitle());
        System.out.println("Время: " + formattedDateTime);
        System.out.println("Место: Ряд " + (row + 1) + ", Место " + (seat + 1));
        System.out.println("Цена: " + price + " руб.");
        System.out.println("----------------");
    }
}
