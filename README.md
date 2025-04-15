# Airline Reservation System
## description:
This is a simple Java program that manages airline flight reservations. It allows you to:

* **Add flights:** Create new flight entries with details like flight number, origin, destination, date, and capacity.
* **Show flight details:** View information about a specific flight.
* **Book seats:** Reserve seats on a flight.
* **Cancel seats:** Remove seat reservations.
* **Delete flights:** Remove flight entries.
* **Generate reports:** See a summary of the total number of flights.
* **Show all flights:** List all available flights.
* **Search flights by origin:** Find flights departing from a specific city.
* **Search flights by date:** Find flights on a specific date.


# Objectives:
The goal of this project is to create a simple flight reservation system. It allows users to add flights, book and cancel seats, view flight details, search for flights, and save all the information in a file. The main aim is to make it easy to manage flights using a text-based menu.


# Documentation:

#Flight Class (Represents a Single Flight)

*Methods:*

* **bookSeat()* — Books a seat if there are still available seats.

* **cancelSeat()* — Cancels a seat booking if there's at least one booked seat.

* **toString()* — Formats the flight as a CSV-compatible string for saving to a file.


# ReservationSystem Class (Main System Logic)

* **This class contains the main logic — it manages all flights and the operations on them.

# loadFlights() — Loads flights from the flights.csv file.

* **Reads the file line by line.*
* **Splits each line by commas.*
* **Creates a Flight object from the data and adds it to the flights list.*


# saveFlights() — Saves all flights back to the file.

* **Simply writes all Flight objects to the CSV file in string format.

# showFlight() — Searches for a flight by number.

* **Asks the user for a flight number.*

* **If found, displays the flight info.*


# bookSeat() — Books a seat.

* **Finds the specified flight.*

* **If seats are available, increases booked, saves, and prints "Seat booked".*

# cancelSeat() — Cancels a seat booking.

* **Similar to booking: finds the flight, decreases booked, and saves.

# deleteFlight() — Deletes a flight.

* **Removes the flight by number from the list and saves changes.

# showReport() — Basic report.

* **Just shows the total number of flights.

# showAllFlights() — Displays all available flights.

 # searchByOrigin() — Searches flights by departure city.

 # searchByDate() — Searches flights by date.

# Main Class

* **Creates the reservation system object.*

* **Loads flight data from file.*


# Data storage

The program stores flight data in a file named _flights.csv_ in the same folder as the program. Each line in the file represents a flight, with the data separated by commas.

# Example usage

* To add a flight, enter //1 and provide the flight details when prompted.
* To see the details of flight AA123, enter //2 and then enter //AA123.
* To book a seat on flight AA123, enter //3 and then enter //AA123.
* To exit the program, enter //7.

# Notes

* The program assumes that the //flights.csv// file may or may not exist when it starts. If it exists, the data is loaded.
* If there is an error saving the file, an error message is displayed.
* Input validation is basic. You need to provide the correct data format.
* Search is case insensitive for origin city.
* Date search needs the same date format that was used when the flight was created.


# I used three classes:
* class Flights - saves data, checks that there are no more reservations than seats on the plane
* class ReservationSystem - saves written data to a csv file.
* public class Main - the main class that is responsible for everything, which allows other classes to workЮ

# Сhallenges faced

cause of I didn't listen to the last couple of classes, I had to face difficulties as a "writer"csv.file,
since I didn't know how to make a csv from txt, I had to look on the Internet and ask my classmates
