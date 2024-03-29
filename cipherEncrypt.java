/**
 * Encrypts plaintext into ciphertext using the Vigenere Cipher.
**/

public class cipherEncrypt
{

  //Declare global variables
  private String plaintext; //the message to be encrypted.
  private String password;  //the password used to encrypt the plaintext.

  private String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";


  /**
   * Constructor method.
   * @param inputMsg the message to encrypt.
   * @param inputPassword the password to encrypt with.
  **/
  public cipherEncrypt(String inputMsg, String inputPassword)
  {
    plaintext = inputMsg;
    password = inputPassword.toLowerCase(); //converts password to all lowercase.
  }

  /**
   * Gets the plaintext message.
   * @return the plaintext message.
  **/
  public String getPlaintext()
  {
    return plaintext;
  }

  /**
   * Gets the password.
   * @return the password
  **/
  public String getPassword()
  {
    return password;
  }

  /**
   * Applies the Vigenere Cipher to encrypt the plaintext.
   * @return the encrypted message.
  **/
  public String encrypt()
  {
    String ciphertext = "";

    String currentAlphabet = ""; // which alphabet is being used for the current letter (lowercase or uppercase)
    char currentLetter; //the character being encrypted.
    char currentKey; //the character being used in the password.
    int passwordPlace = 0; //the index of the character in the password to use.

    int shiftAmount = 0; //the amount to shift the letter.
    int letterPlace = 0; //the place in the alphabet of the current letter.
    int cipherPlace = 0; //the place in the alphabet to set the ciphered letter to.

    for(int i = 0; i < plaintext.length(); i++)
    {
      currentLetter = plaintext.charAt(i); //the current letter being encrypted.
      currentKey = password.charAt(passwordPlace); //the current letter in the password being used.


      //(if indexOf() doesn't find the char, it returns -1 as the index.)
      if(upperAlphabet.indexOf(currentLetter) > -1) //if the plaintext letter is uppercase
      {
          currentAlphabet = upperAlphabet;
      }
      else if(lowerAlphabet.indexOf(currentLetter) > -1) //if the plaintext letter is lowercase
      {
          currentAlphabet = lowerAlphabet;
      }
      else //if the plaintext letter is not a letter.
      {
        //whitespaces and special characters are unchanged, skip to next character
        ciphertext += currentLetter;
        continue;
      }
      shiftAmount = lowerAlphabet.indexOf(currentKey);
      letterPlace = currentAlphabet.indexOf(currentLetter);

      cipherPlace = (letterPlace + shiftAmount) % 26; //shift it to another uppercase letter

      ciphertext += currentAlphabet.charAt(cipherPlace); //add the encrypted letter to the ciphertext string

      passwordPlace = (passwordPlace + 1) % password.length(); //cycle to the next letter in the password.

    }

    return ciphertext;
  }

}
