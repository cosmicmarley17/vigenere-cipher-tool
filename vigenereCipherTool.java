/**
 * Driver for the Vigenere Cipher Tool.
 *
 * Title: Vigenere Cipher Tool
 * Summary: Encrypts and decrypts user-entered messages using the Vigenere Cipher.
 * @author Owen Sullivan  - GitHub: @Sorcerer17
 * @version 1.00, May 19 2019.
 *
**/


import java.util.Scanner; //import Scanner to get user input for messages.

public class vigenereCipherTool
{
  private static int modeChoice = 0;

  private static boolean doContinue = true;
  private static Scanner continueScanner = new Scanner(System.in);

  /**
   * Main method.
  **/
  public static void main(String [] args)
  {

    printWelcome();

    while(doContinue == true)
    {

      modeChoice = getModeChoice();

      if(modeChoice == 1) //encryption mode is chosen
      {
        doEncryption();
      }
      if(modeChoice == 2) //decryption mode is chosen
      {
        doDecryption();
      }
      getContinue(); //ask user if they want to continue
    }

    System.out.println("\n * * * Goodbye! * * *");

  }

  /**
   * Prompts user to input a message.
   * @return the message entered by the user.
  **/
  public static String getUserInput()
  {
    Scanner inputScanner = new Scanner(System.in);
    System.out.print("\nEnter a message: ");
    String input = inputScanner.nextLine();
    return input;
  }

  /**
   * Prompts user to input a password used to encrypt/decrypt.
   * @return the password entered by the user.
  **/
  public static String getUserPassword()
  {
    Scanner passwordScanner = new Scanner(System.in);
    System.out.print("Enter a password (must only contain letters, with no spaces): ");
    String password = "";

    boolean success = false; //track whether a valid password has been entered.
    while(success == false)
    {
      password = passwordScanner.nextLine(); //prompt user to enter a password.
      if(isPasswordAcceptable(password) == true) //if password is a valid password.
      {
        success = true;
        return password;
      }
      System.out.println("\nThat is not a valid password! A password must:");
      System.out.println(" * Not be blank");
      System.out.println(" * Contain only letters (no spaces, symbols, or punctuation)");
      System.out.print("Enter a password: ");
    }
    return password;
  }

  /**
   * Welcome user and ask user to choose encrypt or decrypt mode.
   * @return the number value for the chosen mode
  **/
  public static int getModeChoice()
  {
    int choice = 0;

    System.out.println("\nChoose a mode (1 or 2): ");
    System.out.println("");
    System.out.println("1) Encrypt a plaintext message...");
    System.out.println("2) Decrypt a ciphertext message...");

    boolean modeChoiceIsValid = false;
    boolean success = false;
    Scanner modeChoiceScanner = new Scanner(System.in); //Create a scanner for choosing a mode
    while(success == false)
    {
      try
      {
        while(modeChoiceIsValid == false)
        {
          System.out.print("Mode: ");
          choice = Integer.parseInt(modeChoiceScanner.nextLine()); //get user input for choosing the mode

          if(choice == 1)
          {
            modeChoiceIsValid = true;

            clearScreen(150);
            System.out.println("\nENCRYPTION MODE");
          }
          else if(choice == 2)
          {
            modeChoiceIsValid = true;

            clearScreen(150);
            System.out.println("\nDECRYPTION MODE");
          }
          else if(choice > 2 || choice < 1)
          {
            modeChoiceIsValid = false;
            System.out.println("\nThat's not a choice! Enter 1 or 2.");
          }
        }
        success = true;
      }
      //if user enters values that can't be assigned to an int
      catch(Exception e)
      {
        System.out.println("\nThat's not a choice! Enter 1 or 2.");
      }
    }
    return choice;
  }

  /**
   * Does the encryption process.
  **/
  public static void doEncryption()
  {
    cipherEncrypt encrypt = new cipherEncrypt(getUserInput(),getUserPassword());

    clearScreen(150);
    System.out.print("\n------------------------------------------------------------");
    System.out.println("\nThe plaintext message you entered was: " + encrypt.getPlaintext());
    System.out.println("The password used for encryption is: " + encrypt.getPassword());
    System.out.println("\nThe encrypted message is: " + encrypt.encrypt());
    System.out.print("------------------------------------------------------------");
  }

  /**
   * Does the decryption process.
  **/
  public static void doDecryption()
  {
    cipherDecrypt decrypt = new cipherDecrypt(getUserInput(),getUserPassword());

    clearScreen(150);
    System.out.print("\n------------------------------------------------------------");
    System.out.println("\nThe ciphertext message you entered was: " + decrypt.getCiphertext());
    System.out.println("The password used for decryption is: " + decrypt.getPassword());
    System.out.println("\nThe decrypted message is: " + decrypt.decrypt());
    System.out.print("------------------------------------------------------------");
  }

  /**
   * Verifies that a user-chosen password is eligible for use in a Vigenere Cipher.
   * (The password must only contain letters; no symbols or spaces are permitted.)
   * @param password the password to check.
   * @return true if the password is acceptable, false otherwise.
  **/
  public static boolean isPasswordAcceptable(String password)
  {
    String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";

    if(password.length() == 0) //if the password is blank
    {
      return false;
    }

    char currentLetter; //the current letter in the password being checked for acceptability
    for(int i = 0; i < password.length(); i++)
    {
      currentLetter = password.charAt(i); //the letter being checked

      //if the character is not in the alphabet
      if(upperAlphabet.indexOf(currentLetter) == -1 && lowerAlphabet.indexOf(currentLetter) == -1)
      {
        return false;
      }
    }
    return true;


  }

  /**
   * Prompts user to ask if they want to run the program again.
  **/
  public static void getContinue()
  {
    System.out.println("\nWould you like to run the program again?");
    System.out.print("Enter y or n: ");
    boolean success = false;
    while(success == false)
    {
      String input = continueScanner.nextLine();
      if(input.equalsIgnoreCase("y"))
      {
        doContinue = true;
        clearScreen(150);
        success = true;
      }
      else if(input.equalsIgnoreCase("n"))
      {
        doContinue = false;
        success = true;
      }
      else
      {
        System.out.print("That's not an option! Enter y or n: ");
      }
    }
  }

  /**
   * Prints the welcome screen.
  **/
  public static void printWelcome()
  {
    clearScreen(150);

    System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><>");
    System.out.println("         Welcome to the Vigenere Cipher Tool!");
    System.out.println("Encrypt and decrypt messages using a Vigenere Cipher!");
    System.out.println("<><><><><><><><><><><><><><><><><><><><><><><><><><><>");

  }

  /**
   * Clears the console display by printing blank lines.
   * @param lines the number of blank lines to print.
  **/
  public static void clearScreen(int lines)
  {
    for(int i = 0; i < lines; i++)
    {
      System.out.println("");
    }
  }




}
