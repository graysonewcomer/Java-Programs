package edu.ilstu;

/**
 * Created 10/24/2021
 * 
 * ULID: gpnewco
 * 
 * @author Grayson Newcomer
 * 
 * Driver class to create flight objects of the flight class and utilize
 * a menu to list and reserve seats on flights that have been created.
 */
import java.util.Scanner;

public class Driver {

    static Scanner keyboard = new Scanner(System.in);

    // declaring variables and flight objects
    static Flight flight1;
    static Flight flight2;
    static Flight flight3;
    static String flightNumber;
    static String destinationCity;
    static String originCity;
    static String aircraftType;
    public static final String FIRST_AIRCRAFT_TYPE = "747-400";
    public static final String SECOND_AIRCRAFT_TYPE = "C123";
    public static final String THIRD_AIRCRAFT_TYPE = "AB-410";

    public static void main(String[] args) {

        // creating flights using the addFlight method then instantiating the flight
        // then creating the object from user input for 3 flights
        addFlight();

        flight1 = new Flight(flightNumber, originCity, destinationCity, aircraftType);

        addFlight();

        flight2 = new Flight(flightNumber, originCity, destinationCity, aircraftType);

        addFlight();

        flight3 = new Flight(flightNumber, originCity, destinationCity, aircraftType);

        // displaying menu and offering service until quit option is selected
        String menuChoice = "Empty";
        System.out.println("\nWelcome to First Flight Reservations.\nPlease choose one of the following:");
        while (!menuChoice.equalsIgnoreCase("Q")) {

            // display menu and take user input
            System.out.println(displayMenu());
            menuChoice = keyboard.next();
            Character menuChoiceChar = menuChoice.charAt(0);

            // validation of menu choice
            while (menuChoice.length() != 1) {
                System.out.println("Enter R, L, or Q: ");
                menuChoice = keyboard.next();
            }
            while (!Character.isAlphabetic(menuChoiceChar)) {
                System.out.println("Enter R, L, or Q: ");
                menuChoice = keyboard.next();
                menuChoiceChar = menuChoice.charAt(0);
            }
            while (!menuChoiceChar.equals('R') && !menuChoiceChar.equals('L') && !menuChoiceChar.equals('Q')) {
                System.out.print("Enter R, L, or Q: ");
                menuChoice = keyboard.next();
                menuChoiceChar = menuChoice.charAt(0);

                while (menuChoice.length() != 1) {
                    System.out.println("Enter R, L, or Q: ");
                    menuChoice = keyboard.next();
                }
                while (!Character.isAlphabetic(menuChoiceChar)) {
                    System.out.println("Enter R, L, or Q: ");
                    menuChoice = keyboard.next();
                    menuChoiceChar = menuChoice.charAt(0);
                }
            }

            // when the reserve option is selected:
            if (menuChoice.equalsIgnoreCase("R")) {
                System.out.print("How many seats would you like to reserve: ");
                String reserveAmount = keyboard.next();
                // verify the amount of seats to be reserved that was entered
                while (!Character.isDigit(reserveAmount.charAt(0))) {
                    System.out.print("Please enter a number: ");
                    reserveAmount = keyboard.next();
                }
                // enter flight to reserve seats on
                int numberToReserve = Integer.parseInt(reserveAmount);
                System.out.print("Please enter flight number to reserve seats on: ");
                String flightNumberEntered = keyboard.next();

                // validate flight number
                boolean isEqual = false;
                while (!isEqual) {
                    if (flightNumberEntered.equals(flight1.getFlightNumber())) {
                        flight1.reserve(numberToReserve);
                        isEqual = true;
                    } else if (flightNumberEntered.equals(flight2.getFlightNumber())) {
                        flight2.reserve(numberToReserve);
                        isEqual = true;
                    } else if (flightNumberEntered.equals(flight3.getFlightNumber())) {
                        flight3.reserve(numberToReserve);
                        isEqual = true;
                    } else {
                        System.out.print("Does not match any flights, please try again: ");
                        flightNumberEntered = keyboard.next();
                    }
                }
                System.out.println("Reservations made.");
            }
            // if the list flights option is selected it will display flight information for
            // flights with available seats
            else if (menuChoice.equalsIgnoreCase("L")) {
                System.out.println(output(flight1));
                System.out.println(output(flight2));
                System.out.println(output(flight3));

            }
            // if the quit option is selected print a goodbye message
            else if (menuChoice.equalsIgnoreCase("Q")) {

                System.out.println("Thank you. Goodbye.");
            }
            // more input validation for menu choice selection
            else {
                System.out.print("Enter R, L, or Q: ");
                menuChoice = keyboard.next();
                menuChoiceChar = menuChoice.charAt(0);

                while (menuChoice.length() != 1) {
                    System.out.println("Enter R, L, or Q: ");
                    menuChoice = keyboard.next();
                }
                while (!Character.isAlphabetic(menuChoiceChar)) {
                    System.out.println("Enter R, L, or Q: ");
                    menuChoice = keyboard.next();
                    menuChoiceChar = menuChoice.charAt(0);
                }
            }
        }
    }

    // reserve seat method
    public static void reserveSeats() {
        System.out.print("Enter flight number: ");
        String flightNumber = keyboard.nextLine();
        // gather user input for flight to reserve seats on and reserve seats if flight
        // number matches a flight
        if (flightNumber.equals(flight1.getFlightNumber())) {
            System.out.print("Enter number of seats to reserve: ");
            int numberOfSeats = keyboard.nextInt();
            flight1.reserve(numberOfSeats);
        } else if (flightNumber.equals(flight2.getFlightNumber())) {
            System.out.print("Enter number of seats to reserve: ");
            int numberOfSeats = keyboard.nextInt();
            flight2.reserve(numberOfSeats);
        } else if (flightNumber.equals(flight3.getFlightNumber())) {
            System.out.print("Enter number of seats to reserve: ");
            int numberOfSeats = keyboard.nextInt();
            flight3.reserve(numberOfSeats);
        }
    }

    // find flight method to determine if the flight number entered matches the
    // number of the flight
    public boolean findFlight(String flightNumber, Flight flight) {
        if (flightNumber.equals(flight.getFlightNumber())) {
            return true;
        } else
            return false;
    }

    // add flight method
    public static void addFlight() {
        // gather user input for flight number and use the validateFlightNumber method
        // to validate it
        System.out.print("Enter the flight number: ");
        flightNumber = keyboard.next();
        while (!Flight.validateFlightNumber(flightNumber)) {
            System.out.print("Enter the flight number: ");
            flightNumber = keyboard.next();
        }
        // gather user input for the rest of parameters required to construct a flight
        // object
        System.out.print("Enter the origin city: ");
        originCity = keyboard.next();
        System.out.print("Enter the destination city: ");
        destinationCity = keyboard.next();
        System.out.println("Enter an aircraft type: ");
        System.out.println(displayAircraftMenu());

        while (!keyboard.hasNextInt()) {
            System.out.print("Enter an aircraft type as a number: ");
            keyboard.next();
        }
        // verify input for aircraft choice and set aircraft type based on input
        int aircraftChoice = keyboard.nextInt();
        while (aircraftChoice < 1 || aircraftChoice > 3) {
            System.out.print("Enter number 1, 2, or 3: ");
            aircraftChoice = keyboard.nextInt();
        }

        switch (aircraftChoice) {
            case 1:
                aircraftType = FIRST_AIRCRAFT_TYPE;
                break;
            case 2:
                aircraftType = SECOND_AIRCRAFT_TYPE;
                break;
            case 3:
                aircraftType = THIRD_AIRCRAFT_TYPE;
                break;
            default:
                aircraftType = null;

        }

    }

    // display menu method to display selection menu
    public static String displayMenu() {
        return "L - List all available flights \nR - Reserve seats on a flight \nQ - Quit";
    }

    // method to display different aircraft selections
    public static String displayAircraftMenu() {

        return "1 - 747-400 \n2 - C123 \n3 - AB-410";
    }

    // output method to display flight toString method if it has available seats
    public static String output(Flight flight) {
        if (flight.getSeatsAvailable() > 0)
            return flight.toString();
        else
            return "No flights found";
    }

}
