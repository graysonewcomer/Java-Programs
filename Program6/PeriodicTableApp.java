package edu.ilstu;

/**
 * Created 11/25/2021
 * 
 * ULID: gpnewco
 * 
 * @author Grayson Newcomer
 */
/**
 * Driver class for the PeriodicTable and Element classes
 */

import java.util.Scanner;

public class PeriodicTableApp
{
    public static void main(String[] args)
    {
        // create a new PeriodicTable object to use its methods then read in the data
        // from the file to prepare the array of Element objects
        PeriodicTable pt = new PeriodicTable();
        pt.read("PeriodicTableData.txt");

        // use the menu method to determine what the program should do next based on
        // user input
        menu(pt);
    }

    public static void menu(PeriodicTable pt)
    {
        // variable declaration
        String symbol;
        double threshold;
        String name;

        // create a String array of options for the user to be used in a TextMenu object
        String[] menuItems = { "Display element information",
                "Display particle information(# of protons, electrons, neutrons)",
                "Get element with highest boiling point", "Get element with lowest melting point",
                "Output elements to file based on a threshold value", "Quit" };

        // create TextMenu object to use its methods
        TextMenu mainMenu = new TextMenu(menuItems);

        // get the choice of what the user would like to do next from the menu
        int choice = mainMenu.getChoice();

        Scanner keyboard = new Scanner(System.in);

        // while the user has not selected the Quit option:
        while (choice != 6)
        {
            // switch statement to determine what will happen based upon the user's
            // selection
            switch (choice)
            {
            // if the user chooses option 1:
            case 1:
                // get the symbol of the element from the user and call the elementInfo method
                System.out.print("Please enter symbol of element: ");
                symbol = keyboard.next();
                pt.elementInfo(symbol);
                break;
            // if the user chooses option 2:
            case 2:
                // get the symbol of the element from the user and call the particleInfo method
                System.out.print("Please enter symbol of element: ");
                symbol = keyboard.next();
                pt.particleInfo(symbol);
                break;
            // if the user chooses option 3:
            case 3:
                // get the name of the element with the highest boiling point then print to
                // screen
                name = pt.getHighestBP().getName();
                System.out.println("The element with the highest boiling point is: " + name);
                break;
            // if the user chooses option 4:
            case 4:
                // get the name of the element with the lowest melting point then print to
                // screen
                name = pt.getLowestMP().getName();
                System.out.println("The element with the lowest melting point is: " + name);
                break;
            // if the user chooses option 5:
            case 5:
                // prompt user for a threshold to be used
                System.out.print("Please enter threshold: ");
                // validate that they entered a numeric value
                while (!keyboard.hasNextDouble())
                {
                    System.out.print("Invalid input. Please enter a number: ");
                }
                // use the threshold from the user to call the write method with it
                threshold = keyboard.nextDouble();
                pt.write(threshold);
                break;
            // if the user chooses an option that does not exist nothing happens and it will
            // reprompt
            default:
                break;
            }
            // reprompt the user until they enter 6
            choice = mainMenu.getChoice();
        }
        // after they choose the Quit option, say Goodbye and exit the program
        System.out.println("\nGoodbye!");
        keyboard.close();
    }

}

/**
 * Thank you for a great semester -Grayson Newcomer
 */
