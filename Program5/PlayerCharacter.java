package edu.ilstu;

/**
 * Created 11/8/2021
 * 
 * ULID: gpnewco
 * 
 * @author Grayson Newcomer
 */
/**
 * Class to create PlayerCharacter objects that can be used as characters to
 * guess in the Guess Who? game through the Driver.
 */

public class PlayerCharacter
{

    // instance variables
    private String name;
    private boolean[] feature;
    public static final String[] FEATURES = { "wear glasses ", "wear a hat ", "wear earrings ", "have blue eyes ",
            "have brown eyes ", "have green eyes ", "have a moustache ", "have a beard ", "have blonde hair ",
            "have brown hair ", "have a birthmark " };

    // constructor of PlayerCharacter class that sets the name of the character and
    // the length of the boolean array
    public PlayerCharacter(String name)
    {
        this.name = name;
        int length = FEATURES.length;
        feature = new boolean[length];
    }

    // getter method to get the name of the PlayerCharacter object
    public String getName()
    {
        return this.name;
    }

    // setter method to set a feature of a PlayerCharacter object to true or false
    public void setFeature(int index, boolean featureBoolean)
    {
        feature[index] = featureBoolean;
    }

    // getter method to get the boolean value of the PlayerCharacter objects
    // features at index
    public boolean getValue(int index)
    {
        return feature[index];
    }

    // setter method to set all the features of the boolean array to the values that
    // were passed in
    public void setAll(boolean[] arr)
    {
        for (int i = 0; i < this.feature.length; i++)
            feature[i] = arr[i];
    }

    // toString method for the PlayerCharacter class
    public String toString()
    {
        String feature1 = "";
        String feature2 = "";
        String feature3 = "";
        String feature4 = "";
        String feature5 = "";
        String feature6 = "";
        String feature7 = "";
        String feature8 = "";
        String feature9 = "";
        String feature10 = "";
        String feature11 = "";

        if (feature[0])
            feature1 = FEATURES[0];
        if (feature[1])
            feature2 = FEATURES[1];
        if (feature[2])
            feature3 = FEATURES[2];
        if (feature[3])
            feature4 = FEATURES[3];
        if (feature[4])
            feature5 = FEATURES[4];
        if (feature[5])
            feature6 = FEATURES[5];
        if (feature[6])
            feature7 = FEATURES[6];
        if (feature[7])
            feature8 = FEATURES[7];
        if (feature[8])
            feature9 = FEATURES[8];
        if (feature[9])
            feature10 = FEATURES[9];
        if (feature[10])
            feature11 = FEATURES[10];

        return "Character name: " + name + "\nFeatures: " + feature1 + feature2 + feature3 + feature4 + feature5
                + feature6 + feature7 + feature8 + feature9 + feature10 + feature11;

    }

}
