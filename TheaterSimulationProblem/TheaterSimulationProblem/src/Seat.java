package src;
// Represents a single seat
class Seat {
    private final int seatNumber;
    private boolean booked;

    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.booked = false;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public synchronized boolean isBooked() {
        return booked;
    }

    public synchronized void bookSeat() {
        this.booked = true;
    }
}