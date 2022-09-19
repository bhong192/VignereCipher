import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Vigenere {

    // empty constructor
    public Vigenere(){
    }

    public char[] encrypt(String plaintext, String key){

        // Step 1: Convert plaintext and key to char[]
        char[] message = plaintext.toCharArray();
        char[] keyChar = key.toCharArray();

        // Step 2: Map each letter in the plaintext to corresponding one in the key
        char[] mappedMessage = Arrays.copyOf(message, message.length);
        for(int i = 0, j = 0; i < message.length; i++){
            if(mappedMessage[i] != ' '){
                mappedMessage[i] = keyChar[j];
                if(j == keyChar.length-1){
                    j = 0;
                }
                else{
                    j++;
                }
            }
        }

        // Step 3: Map characters to corresponding letters in alphabet (A -> 0, etc)
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] mappedMessageNumArray = new int[mappedMessage.length];
        char letter = ' ';
        for(int i = 0; i < mappedMessage.length; i++){
            mappedMessageNumArray[i] = alphabet.indexOf(mappedMessage[i]);
        }
            // repeat for original message
        int[] messageNumArray = new int[message.length];
        for(int i = 0; i < message.length; i++){
            messageNumArray[i] = alphabet.indexOf(message[i]);
        }

        //Step 4: Add corresponding values together
        int[] cipherNumArray = new int[message.length];
        for(int i = 0; i < message.length; i++){
            if(mappedMessageNumArray[i] != -1 && messageNumArray[i] != -1){
                cipherNumArray[i] = (mappedMessageNumArray[i] + messageNumArray[i]) % 26;
                // zeroes are spaces
            }
        }

        //Step 5: Create encrypted message
        char[] ciphertextArray = new char[message.length];
        for(int i = 0; i < message.length; i++){
           if(cipherNumArray[i] == 0){
               ciphertextArray[i] = ' ';
           }
           else{
               ciphertextArray[i] = alphabet.charAt(cipherNumArray[i]);
           }
        }

        return ciphertextArray;
    }

    public char[] decrypt(String cipherText, String key){
        char[] result = new char[cipherText.length()];
        return result;
    }
}
