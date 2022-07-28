package edu.ilstu;

/**
 * Class to create an ArrayList object that contains a shuffled deck of cards
 * 
 * Created 2/16/22
 * 
 * @author Grayson Newcomer
 * ULID: gpnewco
 */

import java.util.ArrayList;
import java.util.Collections;

public class PokerDeck
{

    // instance variable to create deck to be used
    private ArrayList<Card> deck = new ArrayList<>();

    // default constuctor
    public PokerDeck()
    {
        // load deck with all 13 kinds of all 4 suits
        deck.add(new Card('C', 1));
        deck.add(new Card('C', 2));
        deck.add(new Card('C', 3));
        deck.add(new Card('C', 4));
        deck.add(new Card('C', 5));
        deck.add(new Card('C', 6));
        deck.add(new Card('C', 7));
        deck.add(new Card('C', 8));
        deck.add(new Card('C', 9));
        deck.add(new Card('C', 10));
        deck.add(new Card('C', 11));
        deck.add(new Card('C', 12));
        deck.add(new Card('C', 13));
        deck.add(new Card('H', 1));
        deck.add(new Card('H', 2));
        deck.add(new Card('H', 3));
        deck.add(new Card('H', 4));
        deck.add(new Card('H', 5));
        deck.add(new Card('H', 6));
        deck.add(new Card('H', 7));
        deck.add(new Card('H', 8));
        deck.add(new Card('H', 9));
        deck.add(new Card('H', 10));
        deck.add(new Card('H', 11));
        deck.add(new Card('H', 12));
        deck.add(new Card('H', 13));
        deck.add(new Card('S', 1));
        deck.add(new Card('S', 2));
        deck.add(new Card('S', 3));
        deck.add(new Card('S', 4));
        deck.add(new Card('S', 5));
        deck.add(new Card('S', 6));
        deck.add(new Card('S', 7));
        deck.add(new Card('S', 8));
        deck.add(new Card('S', 9));
        deck.add(new Card('S', 10));
        deck.add(new Card('S', 11));
        deck.add(new Card('S', 12));
        deck.add(new Card('S', 13));
        deck.add(new Card('D', 1));
        deck.add(new Card('D', 2));
        deck.add(new Card('D', 3));
        deck.add(new Card('D', 4));
        deck.add(new Card('D', 5));
        deck.add(new Card('D', 6));
        deck.add(new Card('D', 7));
        deck.add(new Card('D', 8));
        deck.add(new Card('D', 9));
        deck.add(new Card('D', 10));
        deck.add(new Card('D', 11));
        deck.add(new Card('D', 12));
        deck.add(new Card('D', 13));

        // call this method to shuffle the loaded deck
        toArrayList();
    }

    // method to call the shuffle method and return the shuffled deck
    public ArrayList<Card> toArrayList()
    {
        shuffle();
        return deck;
    }

    private void shuffle()
    {
        // call the given Java shuffle method to shuffle the deck
        Collections.shuffle(deck);
    }

    // getter method to get the deck variable
    public ArrayList<Card> getDeck()
    {
        return this.deck;
    }

}
