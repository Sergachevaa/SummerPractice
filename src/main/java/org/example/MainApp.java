/*
Система бронирования билетов в кинотеатр

Описание:
Необходимо реализовать простую консольную программу на языке Java, имитирующая работу системы бронирования билетов в кинотеатра

Пользователь может:
- Выбрать фильм из списка
- Выбрать сеанс (дата и время)
- Посмотреть доступные места в зале
- Забронировать конкретное место
- Получить виртуальный билет (подтверждение бронирования)
 */
package org.example;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("СИСТЕМА БРОНИРОВАНИЯ КИНОТЕАТРА");

        List<Movie> movies = CinemaGenerator.generateMovies();
        List<Hall> halls = CinemaGenerator.generateHalls(3);
        List<Session> sessions = CinemaGenerator.generateSessions(movies, halls);
        List<User> users = CinemaGenerator.generateUsers(5);

        System.out.println("\nДоступные фильмы:");
        for (Movie movie : movies) {
            System.out.println("- " + movie);
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

        System.out.println("\nСеансы:");
        for (int i = 0; i < sessions.size(); i++) {
            Session s = sessions.get(i);
            String formattedTime = s.getDateTime().format(formatter);
            System.out.println((i + 1) + ") " + s.getMovie() + " | Время: " + formattedTime);
        }

        Random random = new Random();
        Session randomSession = sessions.get(random.nextInt(sessions.size()));
        User randomUser = users.get(random.nextInt(users.size()));
        int row = random.nextInt(5);
        int seat = random.nextInt(6);
        double price = 300 + random.nextInt(200); // 300–499 руб.

        System.out.println("\nПопытка бронирования:");
        randomSession.displayAvailableSeats();
        if (randomSession.bookSeat(row, seat)) {
            Booking booking = new Booking(randomUser, randomSession, row, seat, price);
            System.out.println("\nБронирование прошло успешно:");
            booking.printTicket();
        } else {
            System.out.println("Место занято. Попробуйте другое.");
        }
    }
}
