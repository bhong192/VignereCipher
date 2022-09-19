import java.util.ArrayList;

public class Vigenere {

    // empty constructor
    public Vigenere(){
    }

    public char[] encrypt(String plaintext, String key){

        String result = "";

        // Step 1: Convert plaintext and key to char[]
        char[] message = plaintext.toCharArray();
        char[] keyChar = key.toCharArray();

//        // Step 2: Keep track of where the spaces are
//        ArrayList<Integer> spaceLocations = new ArrayList<>();
//        for(int i = 0; i < message.length; i++){
//            if(message[i] == ' '){
//                spaceLocations.add(i);
//            }
//        }

        // map each letter in the plaintext to corresponding one in the key
        for(int i = 0, j = 0; i < message.length; i++){
            if(message[i] != ' '){
                message[i] = keyChar[j];
                if(j == keyChar.length-1){
                    j = 0;
                }
                else{
                    j++;
                }
            }
        }


        return message;
    }
}
