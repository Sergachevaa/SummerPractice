package org.example;

import java.time.LocalDateTime;

public class Session {
    private Movie movie;
    private Hall hall;
    private LocalDateTime dateTime;

    public Session(Movie movie, Hall hall, LocalDateTime dateTime) {
        this.movie = movie;
        this.hall = hall;
        this.dateTime = dateTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public Hall getHall() {
        return hall;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void displayAvailableSeats() {
        hall.displaySeats();
    }

    public boolean bookSeat(int row, int seat) {
        return hall.bookSeat(row, seat);
    }
}
