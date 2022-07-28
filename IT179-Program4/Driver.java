package edu.ilstu;

/**
 * Class to utilize the Calculator class to act as a calculator that evaluates expressions
 * entered by the user
 * 
 * Created 3/24/2022
 * 
 * ULID: gpnewco
 * @author Grayson Newcomer
 */

import java.util.NoSuchElementException;
import java.util.Scanner;

import edu.ilstu.Calculator.SyntaxErrorException;

public class Driver
{

    public static void main(String[] args)
    {
        String expression = null;
        Scanner keyboard = new Scanner(System.in);
        // try-catch block to catch various exceptions
        try
        {

            // ask user for input of an expression
            System.out.print("Enter an expression. Enter -1 to quit: ");
            expression = keyboard.nextLine();

            // while the user does not enter the sentinel value to quit
            while (!expression.equals("-1"))
            {
                // print out the result of the calculation using the evaluate method from the
                // Calculator class
                System.out.println("Result: " + Calculator.evaluate(expression));
                // reprompt user
                System.out.print("Enter an expression. Enter -1 to quit: ");
                expression = keyboard.nextLine();
            }
        }
        catch (UnsupportedOperationException uoe)
        {
            System.out.println("Error: Divide by 0");
        }
        catch (SyntaxErrorException see)
        {
            System.out.println("Error: Unexpected Character: " + see.toString().charAt(0));
        }
        catch (NoSuchElementException nsee)
        {
            char[] tokens = expression.toCharArray();
            for (int i = 0; i < tokens.length; i++)
            {
                if (!Character.isDigit(tokens[i]) && !Calculator.isOperator(tokens[i]))
                {
                    System.out.println("Error: Unexpected Character Encountered: " + tokens[i]);
                    break;
                }
            }
        }
        finally
        {
            keyboard.close();
        }

    }

}
