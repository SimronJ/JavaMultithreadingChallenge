// Represents a Passenger in the simulation

import java.util.Random;

class Passenger implements Runnable {
    private final int passengerId;
    private int checkedInCounterId = -1;

    public Passenger(int passengerId) {
        this.passengerId = passengerId;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void checkIn(int counterId) {
        this.checkedInCounterId = counterId;
        System.out.println("Passenger " + passengerId + " has checked in through counter " + counterId + ".");
    }

    public int getCheckedInCounterId() {
        return checkedInCounterId;
    }

    @Override
    public void run() {
        try {
            // Simulate random arrival time between 1 and 3 seconds (1000 and 3000 milliseconds)
            int arrivalDelay = 1000 + new Random().nextInt(2000);
            Thread.sleep(arrivalDelay);
            System.out.println("Passenger " + passengerId + " has arrived after " + arrivalDelay + " ms.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
