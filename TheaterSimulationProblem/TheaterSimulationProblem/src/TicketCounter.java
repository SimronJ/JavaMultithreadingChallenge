package src;
// Implementation of a TicketCounter

import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class TicketCounter extends Thread {
    private final int counterId;
    private final List<Seat> seats;
    private final ReentrantLock lock;
    private Random random = new Random();
    private TheaterSimulation theater;
    

    public TicketCounter(int counterId, List<Seat> seats, TheaterSimulation theater) {
        this.counterId = counterId;
        this.seats = seats;
        this.lock = new ReentrantLock();
        this.theater = theater;
    }

    public boolean processBooking(Patron patron) {
        lock.lock();
        try {
            Thread.sleep(random.nextInt(200)); // Simulate processing time
            for (Seat seat : seats) {
                if (!seat.isBooked()) {
                    seat.bookSeat();
                    System.out.println("Patron " + patron.patronId + " booked seat " + seat.getSeatNumber() + " at counter " + counterId);
                    // Guide the patron to their seat through the theater simulation
                    theater.simulateGuidance(patron, seat);
                    return true;
                }
            }
            System.out.println("No available seats for Patron " + patron.patronId + " at counter " + counterId);
            return false;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void run() {
        System.out.println("Counter " + counterId + " is open.");
    }
}
