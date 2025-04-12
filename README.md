# Airline Reservation System

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

## How to use

1.  Save the code:\\ Save the Java code as _Main.java_, _Flight.java_, and _ReservationSystem.java_ in the same folder.

2.  Compile the code:\\ Open your command line or terminal and navigate to the folder where you saved the files.
 Then, run the following command:

3.  Run the program:\\ After compiling, run the program with this command:

4.  Follow the menu:\\ The program will display a menu with options. 
Enter the number corresponding to your choice and press Enter.
 The program will prompt you for any necessary information.

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
