/**************
 * Name: Noah Pengilly 21032673
 * Date: 24/05/2022
 * Purpose: ISAD1000 Project - String and number conversion program
 * File name: ISAD1000_Project.java
 * Unit: ISAD1000 - Introduction to Software Engineering
**************/

import java.util.Scanner;
import java.io.*;

public class ISAD1000_Project {
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        Scanner keyBoard = new Scanner(System.in);
        int choice = 0;
        String fileName;
        do
        {
            System.out.println("\n\n1) Convert String to upper or lower case\n2) Identify wheter numeric values are in a given string");
            System.out.println("3) Identify whether a given string is a valid number or not");
            System.out.println("4) Remove any numbers from a string and then convert to upper or lower case");
            System.out.println("5) Read a structured file\n6) Read an ordinary file\n0) Quit");
            System.out.print("Enter number to make selection: ");
            choice = keyboard.nextInt();

            switch(choice)
            {
                case 1:
                    startStringCon();
                    break;
                case 2:
                    startNumCheck();
                    break;
                case 3:
                    startStringValid();
                    break;
                case 4:
                    startCompStringOp();
                    break;
                case 5:
                    System.out.print("\nEnter file name: ");
                    fileName = keyBoard.nextLine();
                    String[] temp = readStructuredFile(fileName);
                    readFileOperations(temp);
                    break;
                case 6:
                    System.out.print("\nEnter file name: ");
                    fileName = keyBoard.nextLine();
                    readOrdinaryFile(fileName);
                    break;
                default:
                    System.out.println("\nEnding program");
                    choice = 0;
                    keyboard.close();

            }

        }while(choice != 0);
    }

    //This module runs the stringConversion method allowing for user input
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
    }

    //This module converts a string to either upper or lower case
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

    //This module runs the checkForNumbers method allowing for user input
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
    }

    //This module checks whether numeric values are in a string provided by the user returns boolean value
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

    //This module runs the stringValid method allowing for user input
    public static void startStringValid()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("\nEnter String you would like to check: ");
        String input = keyboard.nextLine();
        if(stringValid(input) == true)
        {
            System.out.println("String '" + input + "' is a valid number");
        }
        else
        {
            System.out.println("String '" + input + "' is an invalid number!!");
        }
    }

    //This module identifies if a user provided string is a valid number or not, returning a boolean value to signify this
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

    //This module removes numbers from a string and returns the string, this method is used for compoundStringOp method
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

    //This module starts the compountStringOp for the user
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
    }

    //This module is compound String operations: It removes any numerical values in a user provided string
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
        
        outString = stringConversion(outString, choice);    //Re-uses String conversion module
        
        return outString;
    }

    
    //This module starts the lengthConversion module so that the user can provide an input
    public static void startNumCon()
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("\nEnter number you would like to convert: ");
        double inNum = keyboard.nextDouble();
        System.out.print("\nWhat unit of measure is this number:\n1) Metres\n2) Feet\n3) Centimetres\n4) Inches\nEnter selection: ");
        int unitOfMeasure = keyboard.nextInt();

        try{
            System.out.println("Result: " + lengthConversion(inNum, unitOfMeasure));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }



    //This module is for category 2a. This module takes in a number that represents a length value.
        //The unit of measure is signified by the unitOfMeasure value.
        //If the unitOfMeasure is 1 it is metres and is converted to feet
        //If the unitOfMeasure is 2 it is feet and is converted to metres
        //If the unitOfMeasure is 3 it is centimetres and is converted to inches
        //If the unitOfMeasure is 4 it is inches and is converted to centimetres
    public static double lengthConversion(double inNum, int unitOfMeasure)
    {
        double result = 0;
        switch(unitOfMeasure)
        {
            case 1: //Metres to Feet
                result = inNum * 3.281;
                break;
            case 2: //Feet to Metres
                result = inNum / 3.281;
                break;
            case 3: // Centimetres to Inches
                result = inNum / 2.54;
                break;
            case 4: //Inches to Centimetres
                result = inNum * 2.54;
                break;
            default:
                result = inNum;
                throw new IllegalArgumentException("Invalud unifOfMeasure");
        }
        return result;
    }
    
    //This module is for reading in a structure file as show by structuredFile.txt
    public static String[] readStructuredFile(String fileName)
    {
        String[] fileContents = new String[6];
        String fileLine;
        String[] tempSplit;

        try{
            FileInputStream fileStream = new FileInputStream(fileName);
            DataInputStream inputStream = new DataInputStream(fileStream);
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(inputStream));

            while((fileLine = bufferRead.readLine()) != null)
            {
                if(!fileLine.startsWith("*"))
                {
                    tempSplit = fileLine.split(":");
                    switch(tempSplit[0].trim())
                    {
                        case "String 1":
                            fileContents[0] = tempSplit[1].trim();
                            break;
                        case "String 2":
                            fileContents[1] = tempSplit[1].trim();
                            break;
                        case "String 3":
                            fileContents[2] = tempSplit[1].trim();
                            break;
                        case "String 4":
                            fileContents[3] = tempSplit[1].trim();
                            break;
                        case "Integer 1":
                            fileContents[4] = tempSplit[1].trim();
                            break;
                        case "Integer 2":
                            fileContents[5] = tempSplit[1].trim();
                            break;
                    }
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        return fileContents;
    }

    //This module is for readStructuredFile, it demostrates different modules with the strings provided
    public static void readFileOperations(String[] temp)
    {
        String str1 = temp[0];
        String str2 = temp[1];
        String str3 = temp[2];
        String str4 = temp[3];
        double dub1 = Double.parseDouble(temp[4]);
        double dub2 = Double.parseDouble(temp[5]);

        System.out.println("\nConvert '" + str1 + "' \nTo lower case: " + stringConversion(str1, 2));
        System.out.println("\nDoes the String'" + str2 + "'\nContain numbers? " + checkForNumbers(str2));
        System.out.println("\nIs '" + str3 + "' a valid number: " + stringValid(str3));
        System.out.println("\nRemove numbers and convert to lowercase for string:\n'" + str4 + "'\nResult: " + compoundStringOp(str4, 2));
        
        System.out.println("\nConvert: " + dub1 + " metres, to feet\nResult: " + lengthConversion(dub1, 1));
        System.out.println("\nConvert: " + dub2 + " centimetres, to inches\nResult: " + lengthConversion(dub2, 3));
    }

    public static void readOrdinaryFile(String fileName)
    {
        String tempString;
        try{
            File file = new File(fileName);
            Scanner fileReader = new Scanner(file);

            while(fileReader.hasNextLine())
            {
                tempString = fileReader.nextLine();
                tempString = tempString.trim();
                System.out.println("\n\nOperating on String: " + tempString);
                System.out.println("\nConverted to uppercase: " + stringConversion(tempString, 1));
                System.out.println("Check for numbers: Contains numbers: " + checkForNumbers(tempString));
                System.out.println("Check if valid number: " + stringValid(tempString));
                System.out.println("Remove numbers and convert to lowercase: " + compoundStringOp(tempString, 2));
            }
            fileReader.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

    }
}
    



