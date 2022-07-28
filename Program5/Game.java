package edu.ilstu;

/**
 * Created 11/8/2021
 * 
 * ULID: gpnewco
 * 
 * @author Grayson Newcomer
 */
/**
 * Class to handle PlayerCharacter objects and run the Guess Who?
 * game as needed with its methods. This class is responsible for 
 * all methods used to perform the primary game functions.
 */

import java.util.Random;
import java.util.Scanner;

public class Game
{

    // instance variables
    private int size = 0;
    private PlayerCharacter[] characters;
    private String name;
    private int highScore;
    private TextMenu questions;
    private TextMenu options;
    private String[] questionsArray;
    private Scanner keyboard = new Scanner(System.in);
    private int score;
    private Random random = new Random();
    private int randomNum;
    private PlayerCharacter newCharacter;

    // constructor for the Game class
    public Game(String name)
    {
        this.name = name;
        this.characters = new PlayerCharacter[20];

        String[] optionsArray = { "Display Characters", "Add a Character", "Play a Game", "Display High Score",
                "Exit" };
        this.options = new TextMenu(optionsArray);

        int length = PlayerCharacter.FEATURES.length;

        this.questionsArray = new String[length];
        this.questionsArray = loadArray(questionsArray);
        this.questions = new TextMenu(questionsArray);
        // adding the initial ten characters to the list of characters
        addTen();
    }

    // method to create an array that can prompt questions of whether or not the
    // character has a feature
    public String[] loadArray(String[] array)
    {

        // for loop to add the "Does this character" string before the feature
        for (int i = 0; i < array.length; i++)
        {
            array[i] = "Does this character " + PlayerCharacter.FEATURES[i];
        }
        return array;
    }

    // imported method to add the first ten characters to the characters array
    private void addTen()
    {

        characters[size] = new PlayerCharacter("Tonya");
        boolean[] arr = { false, true, false, false, false, true, false, false, false, false, true };
        characters[size].setAll(arr);
        size++;
        characters[size] = new PlayerCharacter("Tim");
        boolean[] arr2 = { true, true, true, false, true, false, false, false, false, false, true };
        characters[size].setAll(arr2);
        size++;
        boolean[] arr3 = { false, false, true, false, true, false, false, false, false, true, false };
        characters[size] = new PlayerCharacter("Chantel");
        characters[size].setAll(arr3);
        size++;
        boolean[] arr4 = { false, false, false, true, false, false, true, false, false, true, true };
        characters[size] = new PlayerCharacter("Rocky");
        characters[size].setAll(arr4);
        size++;
        boolean[] arr5 = { false, false, false, true, false, false, true, false, false, true, false };
        characters[size] = new PlayerCharacter("Donte");
        characters[size].setAll(arr5);
        size++;
        boolean[] arr6 = { true, true, true, false, true, false, false, false, false, false, false };
        characters[size] = new PlayerCharacter("Shondra");
        characters[size].setAll(arr6);
        size++;
        boolean[] arr7 = { true, false, true, false, true, false, false, false, false, true, false };
        characters[size] = new PlayerCharacter("Michael");
        characters[size].setAll(arr7);
        size++;
        boolean[] arr8 = { false, false, false, false, true, false, true, false, false, true, false };
        characters[size] = new PlayerCharacter("Alexa");
        characters[size].setAll(arr8);
        size++;
        boolean[] arr9 = { true, false, true, false, true, false, true, false, false, true, false };
        characters[size] = new PlayerCharacter("Baxter");
        characters[size].setAll(arr9);
        size++;
        boolean[] arr10 = { false, false, true, false, true, true, true, false, false, true, false };
        characters[size] = new PlayerCharacter("Griswald");
        characters[size].setAll(arr10);
        size++;

    }

    // method to display the saved high score from the game session
    public void displayHighScore()
    {
        System.out.println("The high score is: " + highScore);
    }

    // getter for the high score instance variable
    public int getHighScore()
    {
        return highScore;
    }

    // getter for the questions TextMenu object
    public TextMenu getQuestions()
    {
        return questions;
    }

    // getter for the main menu TextMenu object
    public TextMenu getMainMenu()
    {
        return options;
    }

    // method to display the characters of the characters array using its toString
    // method
    public void displayCharacters()
    {
        // for loop to display all characters of the array
        for (int i = 0; i < size; i++)
        {

            System.out.println(this.characters[i].toString());
        }
    }

    // method to start the game if the user selects to play a game
    public void startGame()
    {
        score = 100;
        // select a random character from the character array
        randomNum = random.nextInt((size - 1) + 1);
        PlayerCharacter player = characters[randomNum];

        // create an array of all the character names
        String[] characterNames = new String[size];

        for (int i = 0; i < size; i++)
        {
            characterNames[i] = characters[i].getName();
        }

        // create a TextMenu object to use methods later
        TextMenu characterNameMenu = new TextMenu(characterNames);

        // while loop to keep game running until endGame method is called
        while (score > 0)
        {

            // prompt the user with options to ask question or guess the character
            System.out.println("Do you want to: \n1 - Ask a Question \n2 - Guess the Character");
            // validate their input is either 1 or 2
            while (!keyboard.hasNextInt())
            {
                System.out.print("Please enter a choice of 1 or 2: ");
                keyboard.next();
            }
            int gameChoice = keyboard.nextInt();

            // if they choose to ask a question
            if (gameChoice == 1)
            {

                // prompt them with the questions and if the question they ask if true print
                // yes, if not print no
                int choice = getQuestions().getChoice();
                if (player.getValue(choice - 1))
                    System.out.println("Yes");
                if (!player.getValue(choice - 1))
                {
                    System.out.println("No");
                }
                // reduce score by ten because each question asked is -10 points
                score -= 10;
            }
            // if they choose to guess the character
            else if (gameChoice == 2)
            {

                // get choice from character name menu from TextMenu object
                int choice = characterNameMenu.getChoice();
                // if their choice is correct
                if (choice == (randomNum + 1))
                {
                    // end the game
                    endGame();
                    break;
                }
                // if their choice is incorrect
                else
                {
                    // tell them it is incorrect, subtract 20 points for an attempt, and continue as
                    // long as the player has not run out of points
                    System.out.println("Sorry that is incorrect");
                    score -= 20;
                    if (score <= 0)
                        endGame();

                }

            }
        }
    }

    // method to add a character to the game
    public void addCharacter(String name, boolean[] array)
    {
        characters[size] = new PlayerCharacter(name);

        // create a new character and add to the characters array

        for (int i = 0; i < array.length; i++)
        {
            if (array[i])
                characters[size].setFeature(i, true);
            else if (!array[i])
                characters[size].setFeature(i, false);
        }

        characters[size].setAll(array);
        size++;

    }

    // method to display the questions and get a choice from the user
    public int displayQuestions()
    {
        return questions.getChoice();
    }

    // method to give end of game messages
    public void endGame()
    {
        // if the player guesses correctly and wins
        if (score > 0)
        {
            // print out a winning message with their score
            System.out.println(
                    "Congratulations, " + name + "!! You guessed correctly. \nGame over \nYour score is " + score);
            // if they got a new high score, tell them
            if (score > highScore)
            {
                System.out.println("Congratulations, " + name + "!! You have a new high score.");
                highScore = score;
            }
        }
        // if they did not win the game
        else
        {
            // tell them they are out of points and who the secret character is
            System.out.println(
                    "You are out of points.\nGame over!\nThe secret character is " + characters[randomNum].getName());
        }
    }

}
