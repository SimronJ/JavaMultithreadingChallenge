
// Implementation of an Usher

import java.util.Random;

class Usher extends Thread {
    private final int usherId;
    private Random random = new Random();

    public Usher(int usherId) {
        this.usherId = usherId;
    }

    public void guidePatronToSeat(Patron patron, Seat seat) {
        System.out.println("Usher " + usherId + " guiding Patron " + patron.patronId + " to seat: " + seat.getSeatNumber());
        try {
            Thread.sleep(random.nextInt(500)); // Simulating time to guide
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run() {
        System.out.println("Usher " + usherId + " is ready.");
        // Usher logic could be handled here, if needed
    }
}