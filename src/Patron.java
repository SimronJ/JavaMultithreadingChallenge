// Implementation of a Patron

import java.util.Random;

class Patron extends Thread {
    final int patronId;
    private final TheaterSimulation theater;
    private Random random = new Random();
    private long arrivalTime;  // Added to track arrival time

    public Patron(int patronId, TheaterSimulation theater) {
        this.patronId = patronId;
        this.theater = theater;
        this.arrivalTime = System.currentTimeMillis(); // Record start time
    }

    private void arrive() {
        try {
            // Simulate random arrival times
            Thread.sleep(random.nextInt(2000));
            // Calculate actual arrival time
            long timeTaken = System.currentTimeMillis() - arrivalTime;
            System.out.println("Patron " + patronId + " has arrived after " + timeTaken + " ms.");
            boolean bookingSuccess = theater.bookSeatForPatron(this);
            if (!bookingSuccess) {
                System.out.println("Patron " + patronId + " failed to book a seat.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run() {
        arrive();
    }
}
