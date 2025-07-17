package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CinemaGenerator {
    private static final String[] movieTitles = {
            "Интерстеллар", "Начало", "Темный рыцарь", "Матрица", "Дюна"
    };

    private static final String[] userNames = {
            "Анна", "Иван", "Мария", "Алексей", "София", "Дмитрий", "Ольга"
    };

    private static final Random random = new Random();

    public static List<Movie> generateMovies() {
        List<Movie> movies = new ArrayList<>();
        for (String title : movieTitles) {
            int duration = 90 + random.nextInt(61); // 90–150 минут
            movies.add(new Movie(title, duration));
        }
        return movies;
    }

    public static List<Hall> generateHalls(int count) {
        List<Hall> halls = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int rows = 5 + random.nextInt(5);       // 5–9 рядов
            int seats = 6 + random.nextInt(5);      // 6–10 мест
            halls.add(new Hall(rows, seats));
        }
        return halls;
    }

    public static List<Session> generateSessions(List<Movie> movies, List<Hall> halls) {
        List<Session> sessions = new ArrayList<>();
        LocalDateTime baseTime = LocalDateTime.of(2025, 7, 15, 10, 0);

        for (int i = 0; i < 5; i++) {
            Movie movie = movies.get(random.nextInt(movies.size()));
            Hall hall = halls.get(random.nextInt(halls.size()));
            LocalDateTime time = baseTime.plusHours(i * 2);
            sessions.add(new Session(movie, hall, time));
        }

        return sessions;
    }

    public static List<User> generateUsers(int count) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String name = userNames[random.nextInt(userNames.length)] + " #" + (i + 1);
            users.add(new User(name));
        }
        return users;
    }
}
