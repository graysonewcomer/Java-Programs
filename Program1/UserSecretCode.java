package edu.ilstu;

/**
 * Created on 9/2/2021
 * 
 * ULID: gpnewco
 * Class: IT168
 */
/**
 * Class to generate username and secret code based on user input
 * 
 * @author Grayson Newcomer
 * 
 */
import java.util.Scanner;
import java.util.Random;

public class UserSecretCode
{

    public static void main(String[] args)
    {

        // import Scanner class

        Scanner keyboard = new Scanner(System.in);

        // declaring variables

        String firstName;
        String lastName;

        // taking user input for first and last name and storing it to previously
        // declared variables
        System.out.print("Please enter your first name > ");
        firstName = keyboard.next();
        System.out.print("Please enter your last name > ");
        lastName = keyboard.next();

        // declaring variables
        String firstLetter = firstName.substring(0, 1);
        firstLetter = firstLetter.toLowerCase();
        String firstFive = lastName.substring(0, 4);
        firstFive = firstFive.toLowerCase();
        Random random = new Random();
        int randomNumber = random.nextInt(99 - 10 + 1) + 10;
        String username = firstLetter + firstFive + randomNumber;

        // Accepting phone number from user and printing
        System.out.print("Please enter your phone number with dashes: xxx-xxx-xxxx > ");
        String phoneNumber = keyboard.next();

        System.out.println();

        // declaring variables
        String lastFour = phoneNumber.substring(8);
        Integer secondRandom = random.nextInt(999 - 100 + 1) + 100;
        String firstThree = phoneNumber.substring(0, 3);
        String stringSecondRandom = secondRandom.toString();
        String primitiveCode = (lastFour + stringSecondRandom + firstThree);

        // replacing characters
        String secretCode = primitiveCode.replace("9", "$");
        secretCode = secretCode.replace("3", "S");
        secretCode = secretCode.replace("4", "A");

        // outputting final variables and data
        System.out.println("Random number: " + randomNumber);
        System.out.println("The username is: " + username);
        System.out.println("Random number: " + stringSecondRandom);
        System.out.println("Your secret code is: " + secretCode);

        keyboard.close();

    }

}
