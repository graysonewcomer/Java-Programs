package edu.ilstu;

/**
 * Created 1/23/2022
 * 
 * ULID: gpnewco
 * 
 * @author Grayson Newcomer
 * 
 * Class to allow users to view vehicles and details of them from a file 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AutoInventory
{

    public static void main(String[] args)
    {
        // creating the Auto array with size 10
        Auto[] autoArr = new Auto[10];

        // use the array loading method to create the array to then be used for
        // displaying a menu for the user
        int numElements = arrayLoad(autoArr);
        // displayMenu method will run the main part of the program and will lock user
        // in a loop until sentinel value is entered
        displayMenu(autoArr, numElements);
        System.out.println("\nSee you again!");

    }

    // method to display a menu and receive user input to determine what actions
    // will be performed
    public static void displayMenu(Auto[] autoArr, int numElements)
    {
        String[] infoArr = { "Information: This city SUV does everything for you.",
                "Information: This 5-passenger sedan is your family's best friend!",
                "Information: The towing capacity of this truck is 5,000 lbs.", "Information: Enjoy the adventures!",
                "Information: This sedan allows a maximum of 4 passengers and offers a luxury ride!",
                "Information: This heavy-duty vehicle can tow up to 20,000 lbs." };

        Scanner keyboard = new Scanner(System.in);
        String[] menuItems = { "Show Sedans", "Show SUVs", "Show Trucks", "Show vehicles based on your budget",
                "Quit" };
        TextMenu menu = new TextMenu(menuItems);

        // textMenu method to get display a menu and get a validated choice from the
        // user
        int choice = menu.getChoice();
        // do while statement to repeat the menu prompt and selection until the Quit
        // number is entered
        do
        {
            // if statement to prevent prompting twice if 5 is the first number entered
            if (choice != 5)
            {
                // switch statement to perform necessary actions based upon which menu option is
                // selected
                switch (choice)
                {
                case 1:
                {
                    // display sedans
                    for (int i = 0; i < numElements; i++)
                    {
                        if (autoArr[i].getType().equals("Sedan"))
                            System.out.println(autoArr[i] + "\n" + infoArr[i]);
                    }
                    break;
                }
                case 2:
                {
                    // display SUVs
                    for (int i = 0; i < numElements; i++)
                    {
                        if (autoArr[i].getType().equals("SUV"))
                            System.out.println(autoArr[i] + "\n" + infoArr[i]);
                    }
                    break;
                }
                case 3:
                {
                    // display trucks
                    for (int i = 0; i < numElements; i++)
                    {
                        if (autoArr[i].getType().equals("Truck"))
                            System.out.println(autoArr[i] + "\n" + infoArr[i]);
                    }
                    break;
                }
                case 4:
                {
                    // requests a budget then uses the class' validation method to validate
                    System.out.print("\nPlease enter your budget: ");
                    String input = keyboard.next();

                    double budget = getValidatedBudget(input);
                    while (budget == 0)
                    {
                        System.out.print("That is not a valid choice. Please enter your budget: ");
                        input = keyboard.next();
                        budget = getValidatedBudget(input);
                    }

                    // print the info of all vehicles under the budget
                    int count = 0;
                    for (int i = 0; i < numElements; i++)
                    {
                        if (autoArr[i].calcMSRP() <= budget)
                        {
                            System.out.println();
                            System.out.println(autoArr[i]);
                            count++;
                        }
                    }
                    if (count == 0)
                    {
                        System.out.println("Sorry, there is no vehicle under the current budget.");
                    }
                    else
                    {
                        System.out.println("\nCongratulations! We found " + count
                                + " vehicles that are under your current budget!");
                    }
                    break;
                }
                case 5:
                    break;
                }

                choice = menu.getChoice();
            }
        } while (choice != 5);

    }

    // method to return a validated budget entered by the user
    public static double getValidatedBudget(String input)
    {

        double budget;

        // try catch statement to validate and then return a correct value
        try
        {
            budget = Double.parseDouble(input);
        }
        catch (NumberFormatException nfe)
        {
            budget = 0;
        }
        return budget;
    }

    // method to load an entered array of Auto objects from a text file
    public static int arrayLoad(Auto[] autoArr)
    {
        int arrCount = 0;
        // try catch statement to read file and create objects to be loaded into an
        // array from the file
        try
        {
            Scanner file = new Scanner(new File("Auto_Inventory.csv"));

            file.useDelimiter(",");

            file.nextLine();

            while (file.hasNext())
            {
                // gathering all the data
                String VIN = file.next();
                String make = file.next();
                String model = file.next();

                String stringYear = file.next();
                int year = Integer.parseInt(stringYear);

                String type = file.next();

                String stringPrice = file.next();
                double price = Double.parseDouble(stringPrice);

                // if else statements because some have empty fields for these parameters
                int capacity = 0;
                String stringPassCapacity = file.next();
                if (stringPassCapacity.equals("N/A"))
                {
                    stringPassCapacity = null;
                }
                else
                {
                    capacity = Integer.parseInt(stringPassCapacity);
                }

                int towingCapacity = 0;
                String stringTowingCapacity = file.next();
                if (stringTowingCapacity.equals("N/A"))
                {
                    stringTowingCapacity = null;
                }
                else
                {
                    towingCapacity = Integer.parseInt(stringTowingCapacity);
                }

                boolean offRoad = false;
                String stringOffRoad = file.nextLine();
                if (stringOffRoad.equals(",N/A"))
                {
                    stringOffRoad = null;
                }
                else if (stringOffRoad.equals(",Yes"))
                {
                    offRoad = true;
                }
                else if (stringOffRoad.equals(",No"))
                {
                    offRoad = false;
                }

                // if else for creating object of proper vehicle type
                if (type.equals("SUV"))
                {
                    autoArr[arrCount] = new SUV(VIN, make, model, year, price, type, offRoad);
                    arrCount++;
                }
                else if (type.equals("Sedan"))
                {
                    autoArr[arrCount] = new Sedan(VIN, make, model, year, price, type, capacity);
                    arrCount++;
                }
                else if (type.equals("Truck"))
                {
                    autoArr[arrCount] = new Truck(VIN, make, model, year, price, type, towingCapacity);
                    arrCount++;
                }
            }
        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println("File does not exist.");
        }
        return arrCount;
    }

}
