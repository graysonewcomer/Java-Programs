package edu.ilstu;

/**
 * Class to create Card objects to be used in a deck of cards
 * 
 * Created 2/16/22
 * 
 * @author Grayson Newcomer ULID: gpnewco
 */

public class Card
{

    // instance variables
    private char suit;
    private int kind;

    // constructor
    public Card(char suit, int kind)
    {
        this.suit = suit;
        this.kind = kind;

    }

    // getter for kind variable
    public int getKind()
    {
        return this.kind;
    }

    // getter for suit variable
    public char getSuit()
    {
        return this.suit;
    }

    // toString method to print Card objects properly
    public String toString()
    {
        return this.suit + String.valueOf(this.kind);
    }

}
