package edu.ilstu;

/**
 * Created 1/23/2022
 * 
 * ULID: gpnewco
 * 
 * @author Grayson Newcomer
 * 
 *         Class to create Sedan objects to be used in other classes. Subclass
 *         of the Auto class
 */
public class Sedan extends Auto
{

    private String type;
    private int capactiy;

    // constructor for creating Sedan objects
    public Sedan(String VIN, String make, String model, int year, double price, String type, int capacity)
    {
        super(VIN, make, model, year, price);
        this.type = type;
        this.capactiy = capacity;
    }

    public String getType()
    {
        return this.type;
    }

    public String toString()
    {
        return super.toString();
    }

}
