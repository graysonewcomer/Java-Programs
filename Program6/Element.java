package edu.ilstu;

/**
 * Created 11/25/2021
 * 
 * ULID: gpnewco
 * 
 * @author Grayson Newcomer
 */
/**
 * Class to create Element objects from the periodic table text file
 */
public class Element
{

    // variable declarations
    private String name;
    private int atomNum;
    private String symbol;
    private double boilPoint;
    private double meltPoint;
    private double density;
    private double weight;

    // constructor for the Element class
    public Element(String name, int atomNum, String symbol, double boilPoint, double meltPoint, double density,
            double weight)
    {
        // sets values for the Element object
        this.name = name;
        this.atomNum = atomNum;
        this.symbol = symbol;
        this.boilPoint = boilPoint;
        this.meltPoint = meltPoint;
        this.density = density;
        this.weight = weight;
    }

    // getter for the name variable
    public String getName()
    {
        return this.name;
    }

    // getter for the atomic number variable
    public int getAtomNum()
    {
        return this.atomNum;
    }

    // getter for the symbol variable
    public String getSymbol()
    {
        return this.symbol;
    }

    // getter for the boiling point variable
    public double getBoilPoint()
    {
        return this.boilPoint;
    }

    // getter for the melting point variable
    public double getMeltPoint()
    {
        return this.meltPoint;
    }

    // getter for the density variable
    public double getDensity()
    {
        return this.density;
    }

    // getter for the weight variable
    public double getWeight()
    {
        return this.weight;
    }

    // toString method for the Element class
    public String toString()
    {
        // variable declaration
        String boilPointString;
        String meltPointString;
        String densityString;

        // if else statements to only print a numeric value if one exists for that
        // element, otherwise indicate one does not exist for that element with "N/A"
        if (boilPoint == 0)
        {
            boilPointString = "N/A";
        }
        else
        {
            boilPointString = Double.toString(boilPoint);
        }

        if (meltPoint == 0)
        {
            meltPointString = "N/A";
        }
        else
        {
            meltPointString = Double.toString(meltPoint);
        }

        if (density == 0)
        {
            densityString = "N/A";
        }
        else
        {
            densityString = Double.toString(density);
        }

        return "\nElement Name: " + name + "\nAtomic Number: " + atomNum + "\nSymbol: " + symbol + "\nBoiling Point: "
                + boilPointString + "\nMelting Point: " + meltPointString + "\nDensity: " + densityString + " g/L"
                + "\nWeight: " + weight + " g/mol";
    }

}
