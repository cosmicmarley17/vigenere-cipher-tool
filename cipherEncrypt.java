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
        shiftAmount = lowerAlphabet.indexOf(currentKey);
        letterPlace = upperAlphabet.indexOf(currentLetter);

        cipherPlace = letterPlace + shiftAmount; //shift it to another uppercase letter

        if(cipherPlace > 25) //if it gets shifted outside of the alphabet
        {
          cipherPlace = cipherPlace - 26; //loop it back to the beginning of the alphabet
        }
        ciphertext += upperAlphabet.charAt(cipherPlace); //add the encrypted letter to the ciphertext string
      }

      else if(lowerAlphabet.indexOf(currentLetter) > -1) //if the plaintext letter is lowercase
      {
        shiftAmount = lowerAlphabet.indexOf(currentKey);
        letterPlace = lowerAlphabet.indexOf(currentLetter);

        cipherPlace = letterPlace + shiftAmount; //shift it to another uppercase letter

        if(cipherPlace > 25) //if it gets shifted outside of the alphabet
        {
          cipherPlace = cipherPlace - 26; //loop it back to the beginning of the alphabet
        }
        ciphertext += lowerAlphabet.charAt(cipherPlace); //add the encrypted letter to the ciphertext string
      }

      else //if the plaintext letter is not a letter.
      {
        passwordPlace--; //don't increase the place in the password. (negates increasing it later.)
        ciphertext += currentLetter;
      }

      
      passwordPlace++; //go to the next letter in the password.
      if(passwordPlace >= password.length()) { passwordPlace = 0; } //loop back to the first letter of the password if the end has been reached.

    }
    
    return ciphertext;
  }
  
}
