/**************
 * Name: Noah Pengilly 21032673
 * Date: 24/05/2022
 * Purpose: ISAD1000 Project - String and number conversion program
 * File name: ISAD1000_Project.java
 * Unit: ISAD1000 - Introduction to Software Engineering
**************/

import java.util.Scanner;

public class ISAD1000_Project {
    public static void main(String[] args)
    {
        startCompStringOp();
        //startStringValid();
        //startNumCheck();
        //startStringCon();
    }

    //This method runs the stringConversion method allowing for user input
    public static void startStringCon()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter string you would like to convert: ");
        String inString = keyboard.nextLine();
        System.out.print("\nEnter 1 for uppercase 2 for lowercase: ");
        int choice = keyboard.nextInt();
        try{
            System.out.println("Result: " + stringConversion(inString, choice));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        keyboard.close();
    }

    //This method converts a string to either upper or lower case
    //The user is able to choose which conversion they wold like to do by entering '1' for uppercase or '2' for lowercase
    public static String stringConversion(String inString, int choice)
    {
        String outString = "";
        if(choice == 1)
        {
            outString = inString.toUpperCase();
        }
        else if(choice == 2)
        {
            outString = inString.toLowerCase();
        }
        else
        {
            throw new IllegalArgumentException("Invalid choice: must be 1 or 2");
        }

        return outString;
    }

    //This method runs the checkForNumbers method allowing for user input
    public static void startNumCheck()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("\nEnter String you would like to check for numbers: ");
        String inString = keyboard.nextLine();
        if(checkForNumbers(inString) == true)
        {
            System.out.println("String contains numbers");
        }
        else
        {
            System.out.println("String does not contain numbers");
        }
        keyboard.close();
    }

    //This method checks whether numeric values are in a string provided by the user returns boolean value
    public static boolean checkForNumbers(String inString)
    {
        boolean containsNumbers = false;
        String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        for(int i = 0; i < numbers.length; i++)
        {
            if(inString.contains(numbers[i]))
            {
                containsNumbers = true;
            }
        }

        return containsNumbers;
    }

    //This method runs the stringValid method allowing for user input
    public static void startStringValid()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("\nInput: ");
        String input = keyboard.nextLine();
        if(stringValid(input) == true)
        {
            System.out.println("String '" + input + "' is a valid number");
        }
        else
        {
            System.out.println("String '" + input + "' is an invalid number!!");
        }
        keyboard.close();
    }

    //This method identifies if a user provided string is a valid number or not, returning a boolean value to signify this
    public static boolean stringValid(String inString)
    {
        boolean valid = false;
        try{
            Integer.parseInt(inString);
            valid = true;
        }
        catch(Exception e)
        {
            valid = false;
        }

        return valid;
    }

    //This method removes numbers from a string and returns the string, this method is used for compoundStringOp method
    public static String removeNumbersFromString(String inString)
    {
        String outString = "";

        char[] array = inString.toCharArray();
        
        for(int i = 0; i < array.length; i++)
        {
            if(Character.isDigit(array[i]) == false)
            {
                outString = outString + array[i];
            }
        }

        return outString;
    }

    public static void startCompStringOp()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter string you would like to operate on: ");
        String inString = keyboard.nextLine();
        System.out.print("\nEnter 1 for uppercase 2 for lowercase: ");
        int choice = keyboard.nextInt();

        try{
            System.out.println("Result: " + compoundStringOp(inString, choice));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        keyboard.close();
    }

    //This method is compound String operations: It removes any numerical values in a user provided string
            //It then converts the string to upper or lower case, again the users choice
    public static String compoundStringOp(String inString, int choice)
    {
        String outString = "";
        
        if(checkForNumbers(inString) == true)
        {
            outString = removeNumbersFromString(inString);
        }
        else
        {
            outString = inString;
        }
        
        outString = stringConversion(outString, choice);    //Re-uses String conversion method
        
        return outString;
    }

    

    
}
    



