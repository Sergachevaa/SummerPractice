package org.example;

public class Hall {
    private final boolean[][] seats;

    public Hall(int rows, int seatsPerRow) {
        seats = new boolean[rows][seatsPerRow];
    }

    public void displaySeats() {
        for (int i = 0; i < seats.length; i++) {
            System.out.print("Ряд " + (i + 1) + ": ");
            for (int j = 0; j < seats[i].length; j++) {
                System.out.print(seats[i][j] ? "[X]" : "[ ]");
            }
            System.out.println();
        }
    }

    public boolean bookSeat(int row, int seat) {
        if (!seats[row][seat]) {
            seats[row][seat] = true;
            return true;
        } else {
            return false;
        }
    }
}
