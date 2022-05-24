import javax.lang.model.util.ElementScanner6;

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
        startNumCheck();
        startStringCon();
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
            throw new IllegalArgumentException("Invalid choice: Please enter 1 or 2");
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


    
}
    



