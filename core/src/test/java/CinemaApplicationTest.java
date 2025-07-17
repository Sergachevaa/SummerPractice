import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CinemaApplicationTest {

    private Hall hall;
    private Movie movie;
    private User user;
    private Session session;

    @BeforeEach
    public void setUp() {
        hall = new Hall(3, 3);
        movie = new Movie("Тестовый фильм", 120);
        user = new User("Тестовый пользователь");
        session = new Session(movie, hall, LocalDateTime.of(2025, 7, 15, 12, 0));
    }

    @Test
    public void testBookSeat_Success() {
        boolean booked = hall.bookSeat(0, 0);
        assertTrue(booked, "Место должно быть успешно забронировано");
    }

    @Test
    public void testBookSeat_AlreadyBooked() {
        hall.bookSeat(0, 0);
        boolean bookedAgain = hall.bookSeat(0, 0);
        assertFalse(bookedAgain, "Место уже занято, повторное бронирование должно вернуть false");
    }

    @Test
    public void testSessionDelegatesBooking() {
        assertTrue(session.bookSeat(1, 1), "Сеанс должен передать бронирование залу");
    }

    @Test
    public void testMovieToString() {
        String str = movie.toString();
        assertTrue(str.contains("Тестовый фильм"));
        assertTrue(str.contains("120"));
    }

    @Test
    public void testUserGetName() {
        assertEquals("Тестовый пользователь", user.getName());
    }

    @Test
    public void testGenerateMovies() {
        List<Movie> movies = CinemaGenerator.generateMovies();
        assertFalse(movies.isEmpty(), "Список фильмов не должен быть пуст");
    }

    @Test
    public void testGenerateUsers() {
        List<User> users = CinemaGenerator.generateUsers(3);
        assertEquals(3, users.size(), "Должно быть сгенерировано 3 пользователя");
    }

    @Test
    public void testGenerateHalls() {
        List<Hall> halls = CinemaGenerator.generateHalls(2);
        assertEquals(2, halls.size(), "Должно быть сгенерировано 2 зала");
    }

    @Test
    public void testGenerateSessions() {
        List<Movie> movies = CinemaGenerator.generateMovies();
        List<Hall> halls = CinemaGenerator.generateHalls(2);
        List<Session> sessions = CinemaGenerator.generateSessions(movies, halls);
        assertEquals(5, sessions.size(), "Должно быть сгенерировано 5 сеансов");
    }
}
