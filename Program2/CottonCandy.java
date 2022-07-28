package edu.ilstu;

/**
 * Created on 9/22/2021
 * 
 * ULID: gpnewco
 * Class: IT168
 */
/**
 * Class to manage cotton candy orders for a small store
 * 
 * @author Grayson Newcomer
 * 
 */
import java.util.Scanner;

import java.text.NumberFormat;

public class CottonCandy {

    public static void main(String[] args) {

        // using constructors to get scanner for gathering user input, and number
        // formats to format prices and discount percents
        Scanner keyboard = new Scanner(System.in);
        NumberFormat nF = NumberFormat.getCurrencyInstance();
        NumberFormat percent = NumberFormat.getPercentInstance();

        // declaring constants for the discounts and sales tax
        final double BIG_DISCOUNT = 0.15, SMALL_DISCOUNT = 0.10, SALES_TAX = 0.0725;

        // welcoming message
        System.out.println("Welcome to the Rainbow City Candy Store! \nWe're ready to take your cotton candy order.");

        // gather user input for their order: name, candies, day of the week
        System.out.print("\nPlease enter your name: ");
        String name = keyboard.nextLine();
        System.out.print("\nEnter the number of Delicious Strawberry Candies: ");
        int strawCandies = keyboard.nextInt();
        System.out.print("Enter the number of Blueberry Delicacy Candies: ");
        int blueCandies = keyboard.nextInt();
        System.out.print("Enter the number of Rainbow Magic Candies: ");
        int rainCandies = keyboard.nextInt();
        System.out.print("Enter the day of the week you will pick up your order: ");
        String dayOfWeek = keyboard.next();

        // declaring variables
        boolean discount = false;
        double strawberryCost = 2.00;
        double blueberryCost = 2.50;
        double rainbowCost = 3.00;
        double newSubtotal;
        double discountAmount = 0;
        double discountUsed = 0;
        double tax;
        double finalCost;
        int totalCandies = (blueCandies + strawCandies + rainCandies);
        double subtotal = (strawCandies * strawberryCost) + (blueCandies * blueberryCost) + (rainCandies * rainbowCost);

        // determine if discount applies and determining
        // new subtotals afterwards
        if (totalCandies >= 12 && totalCandies < 36) {
            discount = true;
            discountAmount = subtotal * SMALL_DISCOUNT;
            discountUsed = SMALL_DISCOUNT;
            newSubtotal = subtotal - discountAmount;
            tax = newSubtotal * SALES_TAX;
        } else if (totalCandies >= 36) {
            discount = true;
            discountAmount = subtotal * BIG_DISCOUNT;
            discountUsed = BIG_DISCOUNT;
            newSubtotal = subtotal - discountAmount;
            tax = newSubtotal * SALES_TAX;
        } else {
            newSubtotal = subtotal;
            tax = newSubtotal * SALES_TAX;
        }
        finalCost = newSubtotal + tax;

        // order summary and only applying text if candies were ordered
        System.out.println("\n\tOrder Summary");
        if (strawCandies >= 1) {
            System.out.println("\nDelicious Strawberry Candies: " + strawCandies + " for "
                    + nF.format(strawberryCost * strawCandies));
        }
        if (blueCandies >= 1) {
            System.out.println(
                    "Blueberry Delicacy Candies: " + blueCandies + " for " + nF.format(blueberryCost * blueCandies));
        }
        if (rainCandies >= 1) {
            System.out
                    .println("Rainbow Magic Candies: " + rainCandies + " for " + nF.format(rainbowCost * rainCandies));
        }
        System.out.printf("%n%-30s%6s", "Subtotal:", nF.format(newSubtotal));
        if (discount) {
            System.out.printf("%n%-30s%7s", "Discounted percentage:", percent.format(discountUsed));
            System.out.printf("%n%-30s%6s", "Discount amount:", nF.format(discountAmount));
            System.out.printf("%n%-30s%6s", "Discounted subtotal:", nF.format(newSubtotal));

        }
        System.out.printf("%n%-30s%6s", "Tax:", nF.format(tax));
        System.out.printf("%n%n%-30s%6s", "Total cost:", nF.format(finalCost));
        System.out.println("\nThis order will be available for pickup \nBy: " + name + "\nOn: " + dayOfWeek);

        keyboard.close();
    }

}
