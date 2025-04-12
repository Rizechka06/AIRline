import java.io.*;
import java.util.*;

class Flight {
    String number;
    String origin;
    String destination;
    String date;
    int capacity;
    int booked;

    public Flight(String number, String origin, String destination, String date, int capacity) {
        this.number = number;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.capacity = capacity;
        this.booked = 0;
    }

    public boolean bookSeat() {
        if (booked < capacity) {
            booked++;
            return true;
        }
        return false;
    }

    public boolean cancelSeat() {
        if (booked > 0) {
            booked--;
            return true;
        }
        return false;
    }

    public String toString() {
        return number + "," + origin + "," + destination + "," + date + "," + capacity + "," + booked;
    }
}

class ReservationSystem {
    ArrayList<Flight> flights = new ArrayList<>();
    String fileName = "flights.csv";

    public void loadFlights() {
        try {
            Scanner fileScanner = new Scanner(new File(fileName));
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                Flight flight = new Flight(parts[0], parts[1], parts[2], parts[3], Integer.parseInt(parts[4]));
                flight.booked = Integer.parseInt(parts[5]);
                flights.add(flight);
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            // file may not exist - that's okay
        }
    }

    public void saveFlights() {
        try {
            PrintWriter writer = new PrintWriter(fileName);
            for (Flight f : flights) {
                writer.println(f.toString());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    public void createFlight(Scanner scanner) {
        System.out.print("Flight number: ");
        String number = scanner.nextLine();
        System.out.print("Origin: ");
        String origin = scanner.nextLine();
        System.out.print("Destination: ");
        String destination = scanner.nextLine();
        System.out.print("Date: ");
        String date = scanner.nextLine();
        System.out.print("Capacity: ");
        int capacity = Integer.parseInt(scanner.nextLine());

        flights.add(new Flight(number, origin, destination, date, capacity));
        saveFlights();
        System.out.println("Flight added.");
    }

    public void showFlight(Scanner scanner) {
        System.out.print("Enter flight number: ");
        String number = scanner.nextLine();
        for (Flight f : flights) {
            if (f.number.equals(number)) {
                System.out.println("Flight: " + f.number + ", " + f.origin + " -> " + f.destination + ", Date: " + f.date + ", Capacity: " + f.capacity + ", Booked: " + f.booked);
                return;
            }
        }
        System.out.println("Flight not found.");
    }

    public void bookSeat(Scanner scanner) {
        System.out.print("Enter flight number: ");
        String number = scanner.nextLine();
        for (Flight f : flights) {
            if (f.number.equals(number)) {
                if (f.bookSeat()) {
                    saveFlights();
                    System.out.println("Seat booked.");
                } else {
                    System.out.println("No available seats.");
                }
                return;
            }
        }
        System.out.println("Flight not found.");
    }

    public void cancelSeat(Scanner scanner) {
        System.out.print("Enter flight number: ");
        String number = scanner.nextLine();
        for (Flight f : flights) {
            if (f.number.equals(number)) {
                if (f.cancelSeat()) {
                    saveFlights();
                    System.out.println("Seat canceled.");
                } else {
                    System.out.println("No booked seats to cancel.");
                }
                return;
            }
        }
        System.out.println("Flight not found.");
    }

    public void deleteFlight(Scanner scanner) {
        System.out.print("Enter flight number to delete: ");
        String number = scanner.nextLine();
        flights.removeIf(f -> f.number.equals(number));
        saveFlights();
        System.out.println("Flight deleted.");
    }

    public void showReport() {
        System.out.println("Total flights: " + flights.size());
    }

    public void showAllFlights() {
        if (flights.isEmpty()) {
            System.out.println("No available flights.");
            return;
        }
        for (Flight f : flights) {
            System.out.println("Flight: " + f.number + ", " + f.origin + " -> " + f.destination + ", Date: " + f.date + ", Capacity: " + f.capacity + ", Booked: " + f.booked);
        }
    }

    public void searchByOrigin(Scanner scanner) {
        System.out.print("Enter origin city: ");
        String origin = scanner.nextLine().trim();
        boolean found = false;
        for (Flight f : flights) {
            if (f.origin.equalsIgnoreCase(origin)) {
                System.out.println("Flight: " + f.number + ", " + f.origin + " -> " + f.destination + ", Date: " + f.date + ", Capacity: " + f.capacity + ", Booked: " + f.booked);
                found = true;
            }
        }
        if (!found) System.out.println("No flights found from " + origin + ".");
    }

    public void searchByDate(Scanner scanner) {
        System.out.print("Enter date (same format as used when adding): ");
        String date = scanner.nextLine().trim();
        boolean found = false;
        for (Flight f : flights) {
            if (f.date.equals(date)) {
                System.out.println("Flight: " + f.number + ", " + f.origin + " -> " + f.destination + ", Date: " + f.date + ", Capacity: " + f.capacity + ", Booked: " + f.booked);
                found = true;
            }
        }
        if (!found) System.out.println("No flights found on " + date + ".");
    }
}

public class Main {
    public static void main(String[] args) {
        ReservationSystem system = new ReservationSystem();
        Scanner scanner = new Scanner(System.in);
        system.loadFlights();

        while (true) {
            System.out.println("\n1. Add flight");
            System.out.println("2. Show flight");
            System.out.println("3. Book seat");
            System.out.println("4. Cancel seat");
            System.out.println("5. Delete flight");
            System.out.println("6. Report");
            System.out.println("7. Exit");
            System.out.println("8. Show all flights");
            System.out.println("9. Search by origin city");
            System.out.println("10. Search by date");
            System.out.print("Choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) system.createFlight(scanner);
            else if (choice.equals("2")) system.showFlight(scanner);
            else if (choice.equals("3")) system.bookSeat(scanner);
            else if (choice.equals("4")) system.cancelSeat(scanner);
            else if (choice.equals("5")) system.deleteFlight(scanner);
            else if (choice.equals("6")) system.showReport();
            else if (choice.equals("7")) {
                System.out.println("Goodbye!");
                break;
            }
            else if (choice.equals("8")) system.showAllFlights();
            else if (choice.equals("9")) system.searchByOrigin(scanner);
            else if (choice.equals("10")) system.searchByDate(scanner);
            else System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}
