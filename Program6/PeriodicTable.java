package edu.ilstu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created 11/25/2021
 * 
 * ULID: gpnewco
 * 
 * @author Grayson Newcomer
 */
/**
 * Class to read data from a file to create an array of elements of the periodic
 * table of elements
 */

public class PeriodicTable
{

    // variable declaration
    public final int ELEMENT_SIZE = 120;
    private Element[] elements;
    private int count;
    private String name;
    private int atomNum;
    private String symbol;
    private double boilPoint;
    private double meltPoint;
    private double density;
    private double weight;

    // constructor for the PeriodicTable class
    public PeriodicTable()
    {
        // create new Element array with the constant size given
        this.elements = new Element[ELEMENT_SIZE];
    }

    // method to read data from a file and fill an Element array from the data
    public void read(String filename)
    {
        // try block to try reading in the file and storing data into variables from it
        try
        {
            Scanner file = new Scanner(new File(filename));
            // file is comma delimited so using the useDelimiter method and designating the
            // comma as the delimiter here
            file.useDelimiter(",");

            // while the file has more data to be read:
            while (file.hasNext())
            {
                // the name will be what comes first in the line on the file
                name = file.next();

                // if else statements to only take numeric value from fields that have them
                String atomNumString = file.next();
                if (!atomNumString.equals(""))
                {
                    atomNum = Integer.parseInt(atomNumString);
                }
                symbol = file.next();

                String boilPointString = file.next();
                if (!boilPointString.equals(""))
                {
                    boilPoint = Double.parseDouble(boilPointString);
                }
                // else statements that are used to format the toString method of the Element
                // class by setting to a specific value if a value does not already exist
                else
                {
                    boilPoint = 0;
                }

                String meltPointString = file.next();
                if (!meltPointString.equals(""))
                {
                    meltPoint = Double.parseDouble(meltPointString);
                }
                else
                {
                    meltPoint = 0;
                }

                String densityString = file.next();
                if (!densityString.equals(""))
                {
                    density = Double.parseDouble(densityString);
                }
                else
                {
                    density = 0;
                }

                String weightString = file.nextLine();
                if (!weightString.equals(""))
                {
                    String weightSub = weightString.substring(1);
                    weight = Double.parseDouble(weightSub);
                }

                // create array of Element objects and append newest Element object to array
                elements[count] = new Element(name, atomNum, symbol, boilPoint, meltPoint, density, weight);
                // increase the count of how many Elements have been added by 1
                count++;
            }
            file.close(); // close the scanner
        }
        // in the case that the file does not exist, tell the user and catch the
        // exception
        catch (FileNotFoundException fnfe)
        {
            System.out.println("File does not exist");
        }

    }

    // getter to return the Element object that has the highest boiling point
    public Element getHighestBP()
    {

        Element max = elements[0];
        // for loop to check each Element object to see if the boiling point is higher
        // than the current highest
        for (int i = 1; i < count; i++)
        {
            if (elements[i].getBoilPoint() > max.getBoilPoint())
                max = elements[i];
        }

        return max;
    }

    // getter to return the Element object that has the lowest melting point
    public Element getLowestMP()
    {
        Element min = elements[0];
        // for loop to check each Element object to see if the melting point is lower
        // than the current lowest
        for (int i = 1; i < count; i++)
        {
            if (elements[i].getMeltPoint() < min.getMeltPoint())
                min = elements[i];
        }

        return min;
    }

    // method to print the information of the Element object after the user enters a
    // chemical symbol to find
    public void elementInfo(String symbol)
    {
        Element e = null;

        // for loop to traverse elements array and if the symbol entered by the user
        // matches a symbol from an element, print out its information
        for (int i = 0; i < count; i++)
        {
            if (symbol.equals(elements[i].getSymbol()))
            {
                e = elements[i];
                System.out.println(e.toString());
                break;
            }
        }
        // if the symbol entered by the user does not match the symbol of any elements,
        // tell the user that no element was found
        if (e == null)
            System.out.println("Element not found.");

    }

    // method to print the information about a single particle of an element
    public void particleInfo(String symbol)
    {
        Element e = null;
        // for loop to traverse elements array and if the symbol entered by the user
        // matches a symbol from an element, print out the particle information
        for (int i = 0; i < count; i++)
        {
            if (symbol.equals(elements[i].getSymbol()))
            {
                e = elements[i];
                // particle information as came from the directions
                System.out.println("\nNumber of protons: " + e.getAtomNum() + "\nNumber of electrons: " + e.getAtomNum()
                        + "\nNumber of neutrons: " + (int) (Math.ceil(e.getWeight())));
                break;
            }
        }
        // if the symbol entered by the user does not match the symbol of any elements,
        // tell the user that no element was found
        if (e == null)
            System.out.println("Element not found.");
    }

    // method to write to a file based on a threshold entered by the user
    public void write(double threshold)
    {
        // call the findByWeight method to create an array of Element objects that have
        // a weight above the user-entered threshold
        Element[] aboveThreshElements = findByWeight(threshold);

        FileWriter fw;
        File filename = new File("ElementsOutput.txt");

        // try block to write all elements that are in the aboveThreshElements array
        try
        {

            fw = new FileWriter(filename, false);

            // for loop to traverse aboveThreshElements array and write each field to a file
            // that is also comma delimited
            for (int i = 0; i < aboveThreshElements.length; i++)
            {
                fw.write(aboveThreshElements[i].getName() + "," + aboveThreshElements[i].getAtomNum() + ","
                        + aboveThreshElements[i].getSymbol() + "," + aboveThreshElements[i].getBoilPoint() + ","
                        + aboveThreshElements[i].getMeltPoint() + "," + aboveThreshElements[i].getDensity() + ","
                        + aboveThreshElements[i].getWeight());
                fw.write("\n");
            }
            fw.close();
        }

        // catch block to catch any invalid input
        catch (IOException ioe)
        {
            System.out.println("Input Mismatch");
        }

    }

    // method to traverse an array of Element objects and return a new array that
    // only contains Element objects with a weight above the threshold
    private Element[] findByWeight(double threshold)
    {
        int numOfElements = 0;
        // for loop to traverse elements array and find the number of elements that are
        // above the threshold by using numOfElements as a counter
        for (int i = 0; i < count; i++)
        {
            if (elements[i].getWeight() > threshold)
            {
                numOfElements++;
            }
        }
        // create new Element array with the exact size as there are of Element objects
        // whose weight is above the threshold
        Element[] aboveThreshElements = new Element[numOfElements];
        int counter = 0;
        // for loop to traverse elements array and add Element objects to the new array
        // that have a weight above the threshold
        for (int i = 0; i < count; i++)
        {
            if (elements[i].getWeight() > threshold)
            {
                // using a counter variable to only add the Element objects to the next
                // available space in the array. If i was used instead, it would crash due to
                // out of bounds indices
                aboveThreshElements[counter] = elements[i];
                counter++;
            }
        }
        return aboveThreshElements;

    }

}
