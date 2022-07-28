package edu.ilstu;

/**
 * Created 1/23/2022
 * 
 * ULID: gpnewco
 * 
 * @author Grayson Newcomer
 * 
 *         Class that implements the AutoInterface interface and defines its
 *         methods. Superclass of the Sedan, SUV, and Truck class.
 */
public class Auto implements AutoInterface
{

    private String VIN;
    private String make;
    private String model;
    private int year;
    private double originalPrice;

    // constructor for creating Auto objects
    public Auto(String VIN, String make, String model, int year, double price)
    {
        this.VIN = VIN;
        this.make = make;
        this.model = model;
        this.year = year;
        this.originalPrice = price;
    }

    // method to calculate the MSRP value to be used for determining if a vehicle is
    // within an entered budget
    public double calcMSRP()
    {
        return originalPrice - (originalPrice * ((2022 - this.year) * 0.05));
    }

    public String getType()
    {
        return null;
    }

    // toString method to be used in all subclasses, displays basic info about the
    // Auto object
    public String toString()
    {
        return "\nVIN: " + this.VIN + "\nMake: " + this.make + "\nModel: " + this.model + "\nYear: " + this.year;
    }
}
