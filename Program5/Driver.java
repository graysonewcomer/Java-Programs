package edu.ilstu;

/**
 * Created 11/8/2021
 * 
 * ULID: gpnewco
 * 
 * @author Grayson Newcomer
 */
/**
 * Class to utilize the other classes of this package to operate
 * a game of Guess Who? by accepting user input and calling
 * proper methods to execute the options as needed.
 */

import java.util.Scanner;

public class Driver
{

    public static Scanner keyboard = new Scanner(System.in);
    public static Game game;

    public static void main(String[] args)
    {

        // Welcome message and get the name of the player
        System.out.print("Welcome to Guess Who! \nPlease enter your name: ");
        String yourName = keyboard.next();
        game = new Game(yourName);

        // get the choice of what the user wants to do from the main menu
        int menuChoice = game.getMainMenu().getChoice();
        // while loop to continue the game running until the option to exit is selected
        while (menuChoice != 5)
        {
            // switch statement to call methods based on main menu selection
            switch (menuChoice)
            {
            case 1:
                // if they choose to display characters, display the characters
                game.displayCharacters();
                break;

            case 2:
                // if they choose to add a character, hopefully it adds a character
                addCharacter();
                // still broken
                break;

            case 3:
                // if they choose to play a game, start the game
                game.startGame();
                break;

            case 4:
                // if they choose to view the high score, display the high score
                game.displayHighScore();
                break;

            default:
            {
                // if they select something else, reprompt them
                System.out.print("Please enter your choice(1-5): ");
                menuChoice = keyboard.nextInt();
            }
            }
            // reprompt after successful completion of method
            menuChoice = game.getMainMenu().getChoice();
        }
    }

    // method to accept user input to create a character with all of its features to
    // pass into the Game class' addCharacter method
    public static void addCharacter()
    {
        // get the name of the new character
        System.out.print("Please enter name: ");
        String name = keyboard.next();

        boolean[] array = new boolean[11];
        String[] array2 = new String[11];

        game.loadArray(array2);

        // for loop to ask questions of if they have the feature and store boolean
        // answers into array
        for (int i = 0; i < array2.length; i++)
        {
            System.out.println(array2[i]);
            String yesOrNo = keyboard.next();
            while (!yesOrNo.equalsIgnoreCase("yes") && !yesOrNo.equalsIgnoreCase("no"))
            {
                System.out.print("Please enter yes or no: ");
                yesOrNo = keyboard.next();
            }
            if (yesOrNo.equalsIgnoreCase("yes"))
            {
                array[i] = true;
            }
            else if (yesOrNo.equalsIgnoreCase("no"))
            {
                array[i] = false;
            }
        }
        // after creation of character, call the addCharacter method from the Game class
        // to add to characters array
        game.addCharacter(name, array);

    }

}
