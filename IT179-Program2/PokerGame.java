package edu.ilstu;

/**
 * Class to extract the aces from each suit of a shuffled deck of cards through a reversal process
 * 
 * Created 2/16/22
 * 
 * @author Grayson Newcomer
 * ULID: gpnewco
 */

import java.util.ArrayList;

public class PokerGame
{

    public static void main(String[] args)
    {

        // get shuffled deck
        PokerDeck pd = new PokerDeck();

        // create four ArrayList objects to print the original deck in a proper format
        ArrayList<Card> first13 = new ArrayList<>();
        ArrayList<Card> second13 = new ArrayList<>();
        ArrayList<Card> third13 = new ArrayList<>();
        ArrayList<Card> fourth13 = new ArrayList<>();

        for (int i = 0; i < 13; i++)
        {
            first13.add(i, pd.getDeck().get(i));
        }
        int count = 0;

        for (int i = 13; i < 26; i++)
        {

            second13.add(count, pd.getDeck().get(i));
        }
        count = 0;

        for (int i = 26; i < 39; i++)
        {
            third13.add(count, pd.getDeck().get(i));
        }
        count = 0;

        for (int i = 39; i < 52; i++)
        {
            fourth13.add(count, pd.getDeck().get(i));
        }
        System.out.println("The original deck of cards: ");
        System.out.println(first13);
        System.out.println(second13);
        System.out.println(third13);
        System.out.println(fourth13);
        System.out.println();

        // Create ArrayLists of only the suit to then sort later
        ArrayList<Card> clubsList = clubsExtraction(pd);
        ArrayList<Card> spadesList = spadesExtraction(pd);
        ArrayList<Card> diamondsList = diamondsExtraction(pd);
        ArrayList<Card> heartsList = heartsExtraction(pd);

        // get the ace from each suit
        getAce(clubsList);
        System.out.println();
        getAce(spadesList);
        System.out.println();
        getAce(diamondsList);
        System.out.println();
        getAce(heartsList);

    }

    // methods to extract only cards of that suit type for each suit
    public static ArrayList<Card> clubsExtraction(PokerDeck pd)
    {
        ArrayList<Card> newList = new ArrayList<>(pd.getDeck());

        for (int i = 0; i < newList.size(); i++)
        {
            if (getCard(newList, i).getSuit() == 'H')
            {
                newList.remove(i);
                i--;
            }
            else if (getCard(newList, i).getSuit() == 'D')
            {
                newList.remove(i);
                i--;
            }
            else if (getCard(newList, i).getSuit() == 'S')
            {
                newList.remove(i);
                i--;
            }
        }
        return newList;
    }

    public static ArrayList<Card> spadesExtraction(PokerDeck pd)
    {
        ArrayList<Card> newList = new ArrayList<>(pd.getDeck());

        for (int i = 0; i < newList.size(); i++)
        {
            if (getCard(newList, i).getSuit() == 'H')
            {
                newList.remove(i);
                i--;
            }
            else if (getCard(newList, i).getSuit() == 'D')
            {
                newList.remove(i);
                i--;
            }
            else if (getCard(newList, i).getSuit() == 'C')
            {
                newList.remove(i);
                i--;
            }
        }
        return newList;
    }

    public static ArrayList<Card> heartsExtraction(PokerDeck pd)
    {
        ArrayList<Card> newList = new ArrayList<>(pd.getDeck());

        for (int i = 0; i < newList.size(); i++)
        {
            if (getCard(newList, i).getSuit() == 'C')
            {
                newList.remove(i);
                i--;
            }
            else if (getCard(newList, i).getSuit() == 'D')
            {
                newList.remove(i);
                i--;
            }
            else if (getCard(newList, i).getSuit() == 'S')
            {
                newList.remove(i);
                i--;
            }
        }
        return newList;
    }

    public static ArrayList<Card> diamondsExtraction(PokerDeck pd)
    {
        ArrayList<Card> newList = new ArrayList<>(pd.getDeck());

        for (int i = 0; i < newList.size(); i++)
        {
            if (getCard(newList, i).getSuit() == 'H')
            {
                newList.remove(i);
                i--;
            }
            else if (getCard(newList, i).getSuit() == 'C')
            {
                newList.remove(i);
                i--;
            }
            else if (getCard(newList, i).getSuit() == 'S')
            {
                newList.remove(i);
                i--;
            }
        }
        return newList;
    }

    // methods to get the ace from each suit's ArrayList
    public static void getAce(ArrayList<Card> list)
    {

        int count = 0;

        // if statement in case first card is the ace
        if ((list.get(0).getKind() == 1))
        {
            System.out.println(list);
            System.out.println("Reverse 0 times.");
        }
        else
        {
            // perform the reversal process and print it properly to the console
            while (list.get(0).getKind() != 1)
            {
                ArrayList<Card> temp = new ArrayList<>();
                for (int i = list.get(0).getKind(); i > 0; i--)
                {
                    temp.add(list.get(i - 1));
                }
                for (int i = list.get(0).getKind(); i > 0; i--)
                {
                    list.set((i - 1), temp.get(i - 1));
                }
                System.out.println(list);
                count++;
            }

            System.out.println("Reverse " + count + " times.");

        }
    }

    // getter method to get the Card object from a specific index in an ArrayList
    private static Card getCard(ArrayList<Card> list, int index)
    {
        return list.get(index);
    }

}
