import java.util.ArrayList;
import java.util.List;


// Main simulation class
public class FlightSimulation {
    private final List<Passenger> passengers = new ArrayList<>();
    private final List<Thread> counters = new ArrayList<>();
    private final List<Thread> attendants = new ArrayList<>();

    public FlightSimulation(int numPassengers, int numCounters, int numAttendants) {
        // Initialize Passengers
        for (int i = 1; i <= numPassengers; i++) {
            passengers.add(new Passenger(i));
        }
        
        // Assign passengers to counters evenly
        for (int i = 1; i <= numCounters; i++) {
            int fromIndex = (i - 1) * (numPassengers / numCounters);
            int toIndex = i * (numPassengers / numCounters);
            List<Passenger> sublist = passengers.subList(fromIndex, toIndex);
            counters.add(new Thread(new CheckInCounter(i, sublist)));
        }

        // Assign passengers to attendants evenly
        for (int i = 1; i <= numAttendants; i++) {
            int fromIndex = (i - 1) * (numPassengers / numAttendants);
            int toIndex = i * (numPassengers / numAttendants);
            List<Passenger> sublist = passengers.subList(fromIndex, toIndex);
            attendants.add(new Thread(new FlightAttendant(i, sublist)));
        }
    }

    public void startSimulation() {
        // Start Passenger Threads
        List<Thread> passengerThreads = new ArrayList<>();
        for (Passenger passenger : passengers) {
            Thread thread = new Thread(passenger);
            passengerThreads.add(thread);
            thread.start();
        }

        // Wait for all passengers to arrive
        for (Thread thread : passengerThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Start Check-In Counter Threads
        for (Thread counter : counters) {
            counter.start();
        }

        // Wait for all counters to finish processing
        for (Thread counter : counters) {
            try {
                counter.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Start Boarding Process
        for (Thread attendant : attendants) {
            attendant.start();
        }

        // Wait for all attendants to finish
        for (Thread attendant : attendants) {
            try {
                attendant.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("All passengers have been boarded.");
    }

    public static void main(String[] args) {
        int numPassengers = 50;
        int numCounters = 3;
        int numAttendants = 2;
        FlightSimulation simulation = new FlightSimulation(numPassengers, numCounters, numAttendants);
        simulation.startSimulation();
    }
}
