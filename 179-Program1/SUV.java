package edu.ilstu;

/**
 * Created 1/23/2022
 * 
 * ULID: gpnewco
 * 
 * @author Grayson Newcomer
 * 
 *         Class to create SUV objects to be used in other classes. Subclass of
 *         the Auto class
 */
public class SUV extends Auto
{

    private String type;
    private boolean offRoad;

    // constructor for creating SUV objects
    public SUV(String VIN, String make, String model, int year, double price, String type, boolean offRoad)
    {
        super(VIN, make, model, year, price);
        this.type = type;
        this.offRoad = offRoad;
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
