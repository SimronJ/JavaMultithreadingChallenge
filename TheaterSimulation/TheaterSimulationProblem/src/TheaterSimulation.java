package src;
import java.util.List;
import java.util.ArrayList;

// Main simulation class Theatre
public class TheaterSimulation extends Thread {
    private static final int TOTAL_SEATS = 50;
    private static final int TOTAL_PATRONS = 100;
    private static final int COUNTER_COUNT = 3;
    private static final int USHER_COUNT = 2;
    
    private final List<Seat> seats;
    private final List<TicketCounter> counters;
    private final List<Usher> ushers;

    public TheaterSimulation() {
        this.seats = new ArrayList<>();
        this.counters = new ArrayList<>();
        this.ushers = new ArrayList<>();
        
        // Initialize seats
        for (int i = 1; i <= TOTAL_SEATS; i++) {
            seats.add(new Seat(i));
        }
        // Initialize counters
        for (int i = 0; i < COUNTER_COUNT; i++) {
            counters.add(new TicketCounter(i + 1, seats, this));
        }
        // Initialize ushers
        for (int i = 1; i <= USHER_COUNT; i++) {
            ushers.add(new Usher(i));
        }
    }

    public synchronized boolean bookSeatForPatron(Patron patron) {
        for (TicketCounter counter : counters) {
            if (counter.processBooking(patron)) {
                return true;
            }
        }
        return false;
    }

    public synchronized void simulateGuidance(Patron patron, Seat seat) {
        // Simple round-robin or random allocation of an usher
        Usher assignedUsher = ushers.get(patron.patronId % ushers.size());
        assignedUsher.guidePatronToSeat(patron, seat);
    }

    public void simulateShowtime() {
        // Start all counter threads
        for (TicketCounter counter : counters) {
            counter.start();
        }

        // Start all usher threads
        for (Usher usher : ushers) {
            usher.start();
        }

        // Create and start patron threads
        List<Thread> patronThreads = new ArrayList<>();
        for (int i = 1; i <= TOTAL_PATRONS; i++) {
            Patron patron = new Patron(i, this);
            Thread thread = new Thread(patron);
            patronThreads.add(thread);
            thread.start();
        }

        // Wait for all patrons to finish
        for (Thread thread : patronThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("All patrons have been handled.");
    }

    public static void main(String[] args) {
        TheaterSimulation theater = new TheaterSimulation();
        theater.simulateShowtime();
    }
}
