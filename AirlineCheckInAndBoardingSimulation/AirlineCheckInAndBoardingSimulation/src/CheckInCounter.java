// Manages check-in process

import java.util.List;
import java.util.Random;

class CheckInCounter implements Runnable {
    private final int counterId;
    private final List<Passenger> passengers;

    public CheckInCounter(int counterId, List<Passenger> passengers) {
        this.counterId = counterId;
        this.passengers = passengers;
    }

    @Override
    public void run() {
        for (Passenger passenger : passengers) {
            if (passenger.getCheckedInCounterId() == -1) { // Passenger hasn't checked in yet
                passenger.checkIn(counterId);
                try {
                    Thread.sleep(new Random().nextInt(500));  // Simulate processing time
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}