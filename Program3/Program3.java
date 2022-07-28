package edu.stu;

/**
 * Created on 10/6/2021
 * 
 * ULID: gpnewco
 * Class: IT168
 */
/**
 * Class to create either a rectangle or a V shape based on user input for
 * which shape to create, what character the shape will be comprised of,
 * and how many rows and columns for the rectangle, as well as how many total characters
 * for the V shape.
 *  
 * @author Grayson Newcomer
 * 
 */
import java.util.Scanner;

public class Program3 {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        // declaring variables
        int choice = 1;
        int rows;
        int columns;
        int odd = 0;
        String character;

        // enable the menu to reprompt after successfully creating a shape
        while (choice != 0) {

            // prompting user and providing menu
            System.out
                    .print("Welcome to the drawing application! \n1 - Draw a rectangle \n2 - Draw a V shape \n0 - Quit"
                            + "\nPlease enter a number: ");
            choice = keyboard.nextInt();

            // if rectangle is selected
            if (choice == 1) {
                // prompt for user input for character, rows, and columns
                System.out.print("Enter character to use in the rectangle: ");
                character = keyboard.next();
                int characterLength = character.length();

                // verify that the character is a single character
                while (characterLength != 1) {
                    System.out.print("Enter a single character to use in the rectangle: ");
                    character = keyboard.next();
                    characterLength = character.length();
                }

                // prompt for number of rows
                System.out.print("Enter number of rows: ");

                // verify correct data type for number of rows
                while (!keyboard.hasNextInt()) {
                    System.out.print("\nEnter number of rows as an integer: ");
                    keyboard.next();
                }
                rows = keyboard.nextInt();

                // prompt for number of columns
                System.out.print("Enter number of columns: ");

                // verify correct data type for number of columns
                while (!keyboard.hasNextInt()) {
                    System.out.print("\nEnter number of columns as an integer: ");
                    keyboard.next();
                }
                columns = keyboard.nextInt();

                // create rectangle based on user input
                for (int i = 1; i <= rows; i++) {
                    for (int x = 1; x <= columns; x++) {
                        System.out.print(character);
                    }
                    System.out.println();
                }
            }

            // if the V shape is selected:
            else if (choice == 2) {
                // prompt for user input for character
                System.out.print("Enter character to use in the V: ");
                character = keyboard.next();
                int characterLength = character.length();

                // verify that the character is a single character
                while (characterLength != 1) {
                    System.out.print("Enter a single character to use in the V: ");
                    character = keyboard.next();
                    characterLength = character.length();
                }

                // prompt for number of characters to appear in V shape
                System.out.print("Enter odd integer between 3-25: ");

                // verify that the number is an integer
                while (!keyboard.hasNextInt()) {
                    System.out.print("\nEnter number of rows as an integer: ");
                    keyboard.next();
                }
                odd = keyboard.nextInt();

                // verify that it is an odd integer between 3 and 25
                while (odd < 3 || odd > 25 || odd % 2 == 0) {
                    System.out.print("\nEnter an odd integer between 3 and 25: ");
                    odd = keyboard.nextInt();
                }
                int mark2Spaces = odd - 2;

                // create V shape
                for (int i = 0; i < ((odd / 2) + 1); i++) {

                    // determine where the first character of the line will be printed
                    for (int mark1 = 0; mark1 <= i; mark1++) {
                        if (mark1 == i) {
                            System.out.print(character);
                        } else {
                            System.out.print(" ");
                        }
                    }
                    // determine where the second character of the line will be printed
                    for (int mark2 = 0; mark2 <= mark2Spaces; mark2++) {
                        if (mark2 < mark2Spaces) {
                            System.out.print(" ");
                        } else {
                            System.out.println(character);
                        }
                    }

                    mark2Spaces -= 2;

                }

            }
            System.out.println("");
        }

        keyboard.close();

    }

}
