import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CinemaSystemMockitoTest {

    private Hall mockHall;
    private Session session;
    private Movie movie;

    @BeforeEach
    public void setup() {
        mockHall = mock(Hall.class);
        movie = new Movie("Интерстеллар", 169);
        session = new Session(movie, mockHall, LocalDateTime.of(2025, 7, 15, 14, 0));
    }

    @Test
    public void testSessionBookSeatDelegatesToHall() {
        when(mockHall.bookSeat(1, 2)).thenReturn(true);

        boolean result = session.bookSeat(1, 2);

        assertTrue(result, "Сеанс должен вернуть true, если Hall вернул true");
        verify(mockHall, times(1)).bookSeat(1, 2);
    }

    @Test
    public void testSessionDisplayAvailableSeatsCallsHall() {
        session.displayAvailableSeats();

        verify(mockHall, times(1)).displaySeats();
    }

    @Test
    public void testBookingPrintsCorrectInfo() {
        User user = new User("Иван");

        Hall realHall = new Hall(5, 5);
        Session realSession = new Session(movie, realHall, LocalDateTime.of(2025, 7, 15, 18, 0));
        Booking booking = new Booking(user, realSession, 2, 3, 450);

        assertDoesNotThrow(booking::printTicket);
    }
}
