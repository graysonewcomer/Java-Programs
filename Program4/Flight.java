package edu.ilstu;

/**
 * Created 10/24/2021
 * 
 * ULID: gpnewco
 * 
 * @author Grayson Newcomer
 * 
 *         Class to create Flight objects and use various methods to reserve
 *         seats and display information about the flights
 */
public class Flight {

    // delcare variables and constants
    private String flightNumber;
    private String originCity;
    private String destinationCity;
    private int maximumSeats;
    private int currentlyReserved;
    public static int flightsCreatedCount;

    public static final String FIRST_AIRCRAFT_TYPE = "747-400";
    public static final String SECOND_AIRCRAFT_TYPE = "C123";
    public static final String THIRD_AIRCRAFT_TYPE = "AB-410";

    /**
     * Constructor
     * 
     * @param flightNumber
     * @param originCity
     * @param destinationCity
     * @param aircraftType
     */
    public Flight(String flightNumber, String originCity, String destinationCity, String aircraftType) {
        this.flightNumber = flightNumber;
        this.originCity = originCity;
        this.destinationCity = destinationCity;
        this.currentlyReserved = 0;
        flightsCreatedCount++;
        calcMaximumSeats(aircraftType);
    }

    /**
     * toString method for the Flight class
     * 
     * @return formatted information about the flight object
     */
    public String toString() {
        return "\nFlight number: " + flightNumber + "\nOrigin City: " + originCity + "\nDestination city: "
                + destinationCity + "\nSeats available: " + (getSeatsAvailable());
    }

    /**
     * Getter for number of seats available to reserve
     * 
     * @return number of seats available
     */
    public int getSeatsAvailable() {
        return (maximumSeats - currentlyReserved);
    }

    /**
     * Method to reserve number of seats on a flight
     * 
     * @param numberOfSeats
     * @return whether or not the reservations were possible
     */
    public boolean reserve(int numberOfSeats) {
        if (numberOfSeats <= getSeatsAvailable()) {
            currentlyReserved += numberOfSeats;
            return true;
        } else
            return false;
    }

    /**
     * Method to verify that the flight number entered is a proper one
     * 
     * @param flightNumber
     * @return true or false of whether or not it is a valid flight number
     */
    public static boolean validateFlightNumber(String flightNumber) {

        if (flightNumber.length() == 5) {
            Character char1 = flightNumber.charAt(0);
            Character char2 = flightNumber.charAt(1);
            Character char3 = flightNumber.charAt(2);
            Character char4 = flightNumber.charAt(3);
            Character char5 = flightNumber.charAt(4);

            if (Character.isAlphabetic(char1) && Character.isAlphabetic(char2) && Character.isDigit(char3)
                    && Character.isDigit(char4) && Character.isDigit(char5))
                return true;
            else
                return false;

        } else if (flightNumber.length() == 6) {
            Character char1 = flightNumber.charAt(0);
            Character char2 = flightNumber.charAt(1);
            Character char3 = flightNumber.charAt(2);
            Character char4 = flightNumber.charAt(3);
            Character char5 = flightNumber.charAt(4);
            Character char6 = flightNumber.charAt(5);

            if (Character.isAlphabetic(char1) && Character.isAlphabetic(char2) && Character.isDigit(char3)
                    && Character.isDigit(char4) && Character.isDigit(char5) && Character.isDigit(char6))
                return true;
            else
                return false;

        } else
            return false;
    }

    /**
     * Getter for flight number
     * 
     * @return flight number
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * Method to calculate the maximum number of seats that can be reserved based on
     * aircraft type
     * 
     * @param aircraftType
     * @return number of seats on that aircraft
     */
    private int calcMaximumSeats(String aircraftType) {
        if (aircraftType.equals(FIRST_AIRCRAFT_TYPE))
            maximumSeats = 200;
        else if (aircraftType.equals(SECOND_AIRCRAFT_TYPE))
            maximumSeats = 125;
        else if (aircraftType.equals(THIRD_AIRCRAFT_TYPE))
            maximumSeats = 90;
        else
            maximumSeats = 0;

        return maximumSeats;
    }
}
