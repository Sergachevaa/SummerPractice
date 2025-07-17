package org.example;

public class Booking {
    private User user;
    private Session session;
    private int row;
    private int seat;

    public Booking(User user, Session session, int row, int seat) {
        this.user = user;
        this.session = session;
        this.row = row;
        this.seat = seat;
    }

    public void printTicket() {
        System.out.println("Билет для: " + user.getName());
        System.out.println("Фильм: " + session.getMovie().getTitle());
        System.out.println("Дата и время: " + session.getDateTime());
        System.out.println("Место: Ряд " + (row + 1) + ", Место " + (seat + 1));
    }
}
