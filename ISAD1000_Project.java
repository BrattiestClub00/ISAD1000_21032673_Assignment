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
        startStringValid();
        //startNumCheck();
        //startStringCon();
    }

    //This method runs the stringConversion methods allowing for user input
    public static void startStringCon()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter string you would like to convert: ");
        String inString = keyboard.nextLine();
        System.out.print("\nEnter 1 for uppercase 2 for lowercase: ");
        int choice = keyboard.nextInt();

        System.out.println("Result: " + stringConversion(inString, choice));
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
            outString = "INVALID INPUT";
        }

        return outString;
    }

    //This method runs the checkForNumbers methods allowing for user input
    public static void startNumCheck()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("\nEnter String you would like to check for numbers: ");
        String inString = keyboard.nextLine();
        checkForNumbers(inString);
        keyboard.close();
    }

    //This method checks whether numeric values are in a string provided by the user
    public static void checkForNumbers(String inString)
    {
        boolean containsNumbers = false;
        String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        String[] numbersFound = new String[inString.length()];

        for(int i = 0; i < numbers.length; i++)
        {
            if(inString.contains(numbers[i]))
            {
                containsNumbers = true;
                numbersFound[i] = numbers[i];
            }
        }

        if(containsNumbers == true)
        {
            System.out.println("Numbers were found: \n");
            for(int i = 0; i < numbersFound.length; i++)
            {
                if(numbersFound[i] != null)
                {
                    System.out.printf("%s ,", numbersFound[i]);
                }
            }
        }
        else
        {
            System.out.println("NO numbers were found");
        }
    }

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

    
}
    



