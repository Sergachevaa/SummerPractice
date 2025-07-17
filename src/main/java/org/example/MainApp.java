package org.example;

import java.time.LocalDateTime;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Программа реализует систему бронирования билетов в кинотеатр.");

        Movie movie = new Movie("Интерстеллар", 169);
        Hall hall = new Hall(5, 8);
        Session session = new Session(movie, hall, LocalDateTime.of(2025, 7, 15, 18, 30));
        User user = new User("Иван Петров");

        session.displayAvailableSeats();

        int row = 2;
        int seat = 4;

        if (session.bookSeat(row, seat)) {
            Booking booking = new Booking(user, session, row, seat);
            System.out.println("Бронирование успешно!");
            booking.printTicket();
        } else {
            System.out.println("Место уже занято!");
        }
    }
}
