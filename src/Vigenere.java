import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Vigenere {

    // empty constructor
    public Vigenere(){
    }

    public String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

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
            //key
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

        //Step 1: convert ciphertext to int[]
        int[] ciphertextNumArray = new int[cipherText.length()];
        for(int i = 0; i < ciphertextNumArray.length; i++){
            ciphertextNumArray[i] = alphabet.indexOf(cipherText.charAt(i));

            // to get rid of -1 mapped from spaces in ciphertext
//            if(ciphertextNumArray[i] == -1){
//                ciphertextNumArray[i] = 0;
//            }
        }
        //repeat for key

        //map characters in the key to the ciphertext again
        char[] ciphertextCharArray = cipherText.toCharArray();
        char[] keyChar = key.toCharArray();
        for(int i = 0, j = 0; i < cipherText.length(); i++){
            if(ciphertextCharArray[i] != ' '){
                ciphertextCharArray[i] = keyChar[j];
                if(j == keyChar.length-1){
                    j = 0;
                }
                else{
                    j++;
                }
            }
        }
        // convert message mapped to key chars to int[]
        int[] keyNumArray = new int[cipherText.length()];
        for(int i = 0; i < ciphertextCharArray.length; i++){
            keyNumArray[i] = alphabet.indexOf(ciphertextCharArray[i]);
//            if(keyNumArray[i]==-1){
//                keyNumArray[i] = 0;
//            }
        }

        //System.out.println(Arrays.toString(keyNumArray));

        //subtract values from int[] of ciphertext and mapped message
        int[] decryptedIntArray = new int[cipherText.length()];
        for(int i = 0; i < cipherText.length(); i++){
            if(ciphertextNumArray[i] != -1 && keyNumArray[i] != -1){
                decryptedIntArray[i] = Math.floorMod((ciphertextNumArray[i] - keyNumArray[i]), 26);
                //decryptedIntArray[i] = (ciphertextNumArray[i] - keyNumArray[i]) % 26;
                // zeroes are spaces
            }
        }

        //System.out.println("decrypted int array: " + Arrays.toString(decryptedIntArray));

        // create decrypted message array
        // keep track of indexes of where spaces are
        ArrayList<Integer> spaceLocations = new ArrayList<>();
        for(int i = 0; i < cipherText.length(); i++){
            if(ciphertextCharArray[i] == ' '){
                spaceLocations.add(i);
            }
        }
        char[] decryptedArray = new char[cipherText.length()];
        for(int i = 0; i < cipherText.length(); i++){
            if(spaceLocations.contains(i)){
                decryptedArray[i] =  ' ';
            }
            else{
                decryptedArray[i] = alphabet.charAt(decryptedIntArray[i]);
            }
        }

        return decryptedArray;
    }
}
