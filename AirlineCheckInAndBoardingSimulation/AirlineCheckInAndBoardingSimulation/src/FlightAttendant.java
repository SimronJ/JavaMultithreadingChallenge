// Flight Attendant for boarding management

import java.util.List;

class FlightAttendant implements Runnable {
    private final int attendantId;
    private final List<Passenger> passengers;

    public FlightAttendant(int attendantId, List<Passenger> passengers) {
        this.attendantId = attendantId;
        this.passengers = passengers;
    }

    @Override
    public void run() {
        for (Passenger passenger : passengers) {
            if (passenger.getCheckedInCounterId() != -1) { // Only guide checked-in passengers
                System.out.println("Attendant " + attendantId + " guiding Passenger " + passenger.getPassengerId() + " onto the plane.");
                try {
                    Thread.sleep(200);  // Simulate time to board
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}