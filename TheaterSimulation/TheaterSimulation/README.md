# Java Multithreading Theater Booking Simulation

## Project Overview

This project is designed to simulate a theater booking process using Java multithreading. The simulation includes patrons booking seats, counters processing bookings concurrently, and ushers guiding patrons to their seats. It serves as a practical demonstration of Java's concurrency framework.

## What You'll Learn

- **Java Threading Basics**: Understanding of how threads are created and managed in Java.
- **Concurrency Control**: Use of synchronization techniques like `ReentrantLock` to manage access to shared resources.
- **Thread Coordination**: How to use `Thread.join()` and other mechanisms to coordinate actions across threads.
- **Handling Shared Resources**: Safely manage shared resources in multithreaded applications.
- **Practical Application**: Simulates a real-world task using Java multithreading, showing application of theoretical concepts.

## Project Structure

- **`Seat` class**: Represents individual seats, tracks their booking status.
- **`Patron` class**: Simulates a patron arriving and attempting to book a seat.
- **`TicketCounter` class**: Manages the booking process for seats at a theater.
- **`Usher` class**: Guides patrons to their confirmed seats.
- **`TheaterSimulation` class**: Handles the initialization and simulation of the booking process.

## Customization

- Adjust the number of patrons, counters, ushers, and seats directly in the `TheaterSimulation` class.
- Modify the random arrival and processing times to explore different concurrency scenarios.

## Contributions

Feel free to fork the repository, improve the simulation, and submit pull requests for any enhancements or fixes.

## License

This project is open-source and available under the MIT License. Feel free to use and modify it for your learning or development.

Enjoy exploring Java multithreading with this simulation challenge!