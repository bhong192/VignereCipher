import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Vigenere vig = new Vigenere();


        String lol = String.valueOf(vig.encrypt("I LOOVE PEANUTS", "BANANA"));
        System.out.println(lol);
    }
}