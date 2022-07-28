package edu.ilstu;

/**
 * Class to take mathematical expressions and evaluate them through the usage of stacks
 * 
 * Created 3/24/2022
 * 
 * ULID: gpnewco
 * @author Grayson Newcomer
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class Calculator
{

    // SyntaxErrorException class from the InfixToPostfixParens
    public static class SyntaxErrorException extends Exception
    {
        /**
         * Construct a SyntaxErrorException with the specified message.
         * 
         * @param message The message
         */
        public SyntaxErrorException(String message)
        {
            super(message);
        }
    }

    // instance variables
    private static final Deque<Character> operatorStack = new ArrayDeque<>();
    private static final Deque<Integer> numberStack = new ArrayDeque<>();
    private static final String OPERATORS = "-+*/()";
    private static final int[] PRECEDENCE = { 1, 1, 2, 2, -1, -1 };

    // the primary method to be used to evaluate expressions
    public static int evaluate(String expression) throws SyntaxErrorException
    {
        // break up the expression into individual characters in an array
        char[] tokens = expression.toCharArray();

        // for loop to run through the array of character tokens
        for (int i = 0; i < tokens.length; i++)
        {

            // if the character is a space, move on
            if (tokens[i] == ' ')
                continue;

            // if the token is a digit 0-9
            if (tokens[i] >= '0' && tokens[i] <= '9')
            {
                StringBuilder sb = new StringBuilder();

                // if a number has more than one digit, use this while loop to create the full
                // number as a string
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                    sb.append(tokens[i++]);
                // push the integer value of the string
                numberStack.push(Integer.parseInt(sb.toString()));

                // decrement i by 1 so an index is not skipped in the for loop
                i--;
            }

            // if the token is a left parenthesis, push it
            else if (tokens[i] == '(')
                operatorStack.push(tokens[i]);

            // if the token is a right parenthesis
            else if (tokens[i] == ')')
            {
                // while the operator on the top of the stack is not a left parenthesis
                while (operatorStack.peek() != '(')
                    // push the evaluation of the top operator and top two numbers
                    numberStack.push(evalOperator(operatorStack.pop(), numberStack.pop(), numberStack.pop()));
                operatorStack.pop();
            }

            // if the token is an operator
            else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/')
            {

                // while the operator stack is not empty and the precedence of the top operator
                // is greater than the precedence of the token
                while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) > precedence(tokens[i]))
                    // push the evaluation of top operator and top two numbers
                    numberStack.push(evalOperator(operatorStack.pop(), numberStack.pop(), numberStack.pop()));

                operatorStack.push(tokens[i]);
            }
            // otherwise, throw NoSuchElementException
            else
            {
                throw new NoSuchElementException("Invalid char: " + tokens[i]);
            }
        }

        // while the operator stack still has stuff left
        while (!operatorStack.isEmpty())
            // push the evaluation of the top operator and top two numbers
            numberStack.push(evalOperator(operatorStack.pop(), numberStack.pop(), numberStack.pop()));

        return numberStack.pop();
    }

    // precedence method from InfixToPostfixParens
    private static int precedence(char op)
    {
        return PRECEDENCE[OPERATORS.indexOf(op)];
    }

    // method to evaluate an expression using an operator and two numbers
    public static int evalOperator(char op, int secondNum, int firstNum)
    {
        switch (op)
        {
        case '+':
            return firstNum + secondNum;
        case '-':
            return firstNum - secondNum;
        case '*':
            return firstNum * secondNum;
        case '/':
            if (secondNum == 0)
                throw new UnsupportedOperationException("Error: Divide by 0. Exiting.");
            return firstNum / secondNum;
        }
        return 0;
    }

    // isOperator method from InfixToPostfixParens
    public static boolean isOperator(char ch)
    {
        return OPERATORS.indexOf(ch) != -1;
    }
}
