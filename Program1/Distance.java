package edu.ilstu;

import java.text.DecimalFormat;

/**
 * Created on 9/2/2021
 * 
 * ULID: gpnewco
 * Class: IT168
 */
/**
 *Class to calculate distance between two points on a graph
 *  
 * @author Grayson Newcomer
 * 
 */
import java.util.Scanner;

public class Distance
{

    public static void main(String[] args)
    {

        Scanner keyboard = new Scanner(System.in);

        // declaring variables
        int firstXValue;
        int firstYValue;
        int secondXValue;
        int secondYValue;

        // accepting user input
        System.out.print("Enter the first x value: ");
        firstXValue = keyboard.nextInt();
        System.out.print("Enter the first y value: ");
        firstYValue = keyboard.nextInt();
        System.out.print("Enter the second x value: ");
        secondXValue = keyboard.nextInt();
        System.out.print("Enter the second y value: ");
        secondYValue = keyboard.nextInt();

        // calculate distance
        double differenceX = (secondXValue - firstXValue);
        int differenceY = (secondYValue - firstYValue);
        double xSquared = Math.pow(differenceX, 2);
        double ySquared = Math.pow(differenceY, 2);
        double xPlusY = (xSquared + ySquared);
        double distance = Math.sqrt(xPlusY);

        // format answer
        Double doubleDistance = distance;
        doubleDistance.toString();
        DecimalFormat df = new DecimalFormat("#.##");
        String formattedDistance = df.format(doubleDistance);

        // output answer
        System.out.println("The distance of (" + firstXValue + ", " + firstYValue + ") and (" + secondXValue + ", "
                + secondYValue + ") is " + formattedDistance);

        keyboard.close();

    }
}
