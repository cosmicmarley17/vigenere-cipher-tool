/**
 * Decrypts ciphertext into plaintext using the Vigenere Cipher.
**/

public class cipherDecrypt
{

  //Initialize global variables
  private String ciphertext; //the message to be decrypted
  private String password;  //the password used to decrypt the ciphertext.

  private String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  private String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";


  /**
   * Constructor method.
   * @param inputMsg the ciphertext to decrypt.
   * @param inputPassword the password used to decrypt
  **/
  public cipherDecrypt(String inputMsg, String inputPassword)
  {
    ciphertext = inputMsg;
    password = inputPassword.toLowerCase(); //converts password to all lowercase
  }

  /**
   * Gets the ciphertext message.
   * @return the ciphertext message.
  **/
  public String getCiphertext()
  {
    return ciphertext;
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
   * Applies the Vigenere Cipher to decrypt the ciphertext.
   * @return the decrypted message.
  **/
  public String decrypt()
  {
    String plaintext = "";

    char currentLetter; //the character being decrypted.
    char currentKey; //the character being used in the password.
    int passwordPlace = 0; //the index of the character in the password to use.

    int shiftAmount = 0; //the amount to shift the letter.
    int letterPlace = 0; //the place in the alphabet of the current letter.
    int plaintextPlace = 0; //the place in the alphabet to set the plaintext letter to.

    for(int i = 0; i < ciphertext.length(); i++)
    {
      currentLetter = ciphertext.charAt(i); //the current letter being decrypted.
      currentKey = password.charAt(passwordPlace); //the current letter in the password being used.


      //(if indexOf() doesn't find the char, it returns -1 as the index.)
      if(upperAlphabet.indexOf(currentLetter) > -1) //if the ciphertext letter is uppercase
      {
        shiftAmount = lowerAlphabet.indexOf(currentKey);
        letterPlace = upperAlphabet.indexOf(currentLetter);

        plaintextPlace = letterPlace - shiftAmount; //shift it to another uppercase letter

        if(plaintextPlace < 0) //if it gets shifted outside of the alphabet
        {
          plaintextPlace = plaintextPlace + 26; //loop it back to the end of the alphabet
        }
        plaintext += upperAlphabet.charAt(plaintextPlace); //add the decrypted letter to the plaintext string
      }

      else if(lowerAlphabet.indexOf(currentLetter) > -1) //if the ciphertext letter is lowercase
      {
        shiftAmount = lowerAlphabet.indexOf(currentKey);
        letterPlace = lowerAlphabet.indexOf(currentLetter);

        plaintextPlace = letterPlace - shiftAmount; //shift it to another uppercase letter

        if(plaintextPlace < 0) //if it gets shifted outside of the alphabet
        {
          plaintextPlace = plaintextPlace + 26; //loop it back to the end of the alphabet
        }
        plaintext += lowerAlphabet.charAt(plaintextPlace); //add the decrypted letter to the plaintext string
      }

      else //if the ciphertext letter is not a letter.
      {
        passwordPlace--; //don't increase the place in the password. (negates increasing it later.)
        plaintext += currentLetter;
      }



      passwordPlace++; //go to the next letter in the password.
      if(passwordPlace >= password.length()) { passwordPlace = 0; } //loop back to the first letter of the password if the end has been reached.

    }

    return plaintext;
  }



}
