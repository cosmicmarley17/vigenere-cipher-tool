# Vigenere Cipher Tool

## About
Vigenere Cipher Tool is a program written in Java that encrypts and decrypts user-entered messages using the Vigenere Cipher. 
There are three main components:
* vigenereCipherTool: the driver class. Sends output to the console and handles user input.
* cipherEncrypt: Encrypts the message using the Vigenere Cipher.
* cipherDecrypt: Decrypts the message using the Vigenere Cipher.

cipherEncrypt and cipherDecrypt are designed to work independent of the driver class, so the driver class can be replaced with another.

## Installation

Download and compile all the .java files.

## Usage

Run the driver class, "vigenereCipherTool", in a console environment.
For example, in a BASH command line:

```bash
java vigenereCipherTool
```
Alternatively the cipherEncrypt and cipherDecrypt files could be used with a new driver class other than vigenereCipherTool.

## License
GNU General Public License v3.0. See LICENSE for details.
