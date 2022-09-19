import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Vigenere vig = new Vigenere();

        String str = new String(vig.encrypt("THE BOY HAS THE TOY", "VIG"));
        System.out.println(str);
    }
}