package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CinemaGenerator {
    private static final Logger logger = LogManager.getLogger(CinemaGenerator.class);

    private static final String[] movieTitles = {
            "Интерстеллар", "Начало", "Темный рыцарь", "Матрица", "Дюна"
    };

    private static final String[] userNames = {
            "Анна", "Иван", "Мария", "Алексей", "София", "Дмитрий", "Ольга"
    };

    private static final Random random = new Random();

    public static List<Movie> generateMovies() {
        logger.info("Генерация фильмов...");
        List<Movie> movies = new ArrayList<>();
        for (String title : movieTitles) {
            int duration = 90 + random.nextInt(61);
            logger.debug("Фильм: {} ({} мин)", title, duration);
            movies.add(new Movie(title, duration));
        }
        logger.info("Сгенерировано {} фильмов", movies.size());
        return movies;
    }

    public static List<Hall> generateHalls(int count) {
        logger.info("Генерация {} залов...", count);
        List<Hall> halls = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int rows = 5 + random.nextInt(5);
            int seats = 6 + random.nextInt(5);
            logger.debug("Зал {}: {} рядов, {} мест в ряду", i + 1, rows, seats);
            halls.add(new Hall(rows, seats));
        }
        return halls;
    }

    public static List<Session> generateSessions(List<Movie> movies, List<Hall> halls) {
        logger.info("Генерация сеансов...");
        List<Session> sessions = new ArrayList<>();
        LocalDateTime baseTime = LocalDateTime.of(2025, 7, 15, 10, 0);

        for (int i = 0; i < 5; i++) {
            Movie movie = movies.get(random.nextInt(movies.size()));
            Hall hall = halls.get(random.nextInt(halls.size()));
            LocalDateTime time = baseTime.plusHours(i * 2);
            sessions.add(new Session(movie, hall, time));
            logger.debug("Сеанс {}: фильм '{}', время {}", i + 1, movie.getTitle(), time);
        }

        return sessions;
    }

    public static List<User> generateUsers(int count) {
        logger.info("Генерация {} пользователей...", count);
        List<User> users = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String name = userNames[random.nextInt(userNames.length)] + " #" + (i + 1);
            users.add(new User(name));
            logger.debug("Пользователь создан: {}", name);
        }
        return users;
    }
}
