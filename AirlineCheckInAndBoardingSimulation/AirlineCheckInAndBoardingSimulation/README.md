# Java Multithreading Flight Boarding Simulation

## Project Overview

This project simulates the airline check-in and boarding process using Java multithreading. The simulation handles passengers arriving, checking in, and boarding a flight, while employing concurrent processing to reflect a real-world application of Java's concurrency features.

## What You'll Learn

- **Java Threading Basics**: Learn how to create and manage threads using the `Runnable` interface and `Thread` class.
- **Concurrency Control**: Use locking mechanisms to manage shared resources and ensure thread safety.
- **Thread Coordination**: Learn how to coordinate thread execution using `sleep()` and `join()`.
- **Resource Management**: Gain insight into managing shared data effectively in a multithreaded environment.

## Project Structure

- **`Passenger` Class**: Represents passengers arriving and checking into the flight. It logs arrival time and which counter was used for check-in.
- **`CheckInCounter` Class**: Manages passenger check-in processes, distributing load across available counters.
- **`FlightAttendant` Class**: Guides passengers onto the plane once they are checked in, spreading workload across available attendants.
- **`FlightSimulation` Class**: Orchestrates the simulation setup, manages threads for each role, and ensures proper synchronization and execution flow.

## Running the Project

1. **Prerequisites**: Ensure you have Java installed on your system and it's added to the PATH.
   
2. **Compile the Code**: Navigate to the project directory and compile the code using:
   ```bash
   javac FlightSimulation.java
   ```
3. **Run the Simulation**: Execute the simulation with:
   ```bash
   java FlightSimulation
   ```

## Simulation Details

- **Passenger Arrival**: Passengers arrive at the airport in random intervals between 1 and 3 seconds, simulating a real-world scenario.
- **Check-In Process**: The check-in process is distributed across multiple counters, with each logging the passengers they process.
- **Boarding Process**: The boarding is managed by flight attendants, each responsible for guiding a group of passengers onto the plane.

## Customization

- Adjust the number of passengers, counters, and attendants by modifying the parameters in the `FlightSimulation` class.
- Experiment with different random delay intervals to simulate various operational conditions.

## Contributions

Contributions are welcome! Feel free to fork the repository, make improvements, and submit pull requests for any enhancements or bug fixes.

## License

This project is open-source and available under the MIT License. You are free to use, adapt, and distribute for educational or personal development purposes.

---

Embark on this challenge to deepen your understanding of Java multithreading and simulate an essential aspect of airline operations!
