package edu.ilstu;

/**
 * Created 3/14/2022
 * 
 * ULID: gpnewco
 * 
 * @author Grayson Newcomer
 * 
 * Driver class to create an OrderedList object using a text file
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver
{

    public static void main(String[] args)
    {

        Scanner input;
        OrderedList<String> list = new OrderedList<>();

        try
        {

            input = new Scanner(new File("text.txt"));
            while (input.hasNext())
            {
                list.add(input.next());

            }

        }
        catch (FileNotFoundException fnfe)
        {

            System.out.println("File does not exist.");
        }

        System.out.println(list);

    }

}
