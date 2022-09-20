import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Vigenere vig = new Vigenere();

        //Ignore
//        String lol = String.valueOf(vig.encrypt("I LOOVE PEANUTS", "BANANA"));
        //System.out.println(Arrays.toString(vig.encrypt("I LOOVE PEANUTS", "BANANA")));

        //String str = new String(vig.encrypt("THE BOY HAS THE TOY", "VIG"));
        //System.out.println(str);

//        str = new String(vig.decrypt("OPK WWE CIY OPK OWE", "VIG"));

        //Testing for matching outputs
//        System.out.println(Arrays.toString(vig.encrypt("I LOOVE PEANUTS", "BANANA")));
//        System.out.println(Arrays.toString(vig.decrypt("J LBOIE QENNHTT", "BANANA")));


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter plaintext to encrypt: ");
        String plaintext = scanner.nextLine();

        System.out.println("Enter the key: ");
        String key = scanner.nextLine();
        scanner.close();

        String ciphertext = String.valueOf(vig.encrypt(plaintext, key));
        System.out.println("Ciphertext: " + ciphertext);
        System.out.println("Decrypted Message: " + String.valueOf(vig.decrypt(ciphertext, key)));
    }
}