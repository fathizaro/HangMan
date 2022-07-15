/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static String[] words = new String[]{"ant", "baboon", "badger", "bat", "bear", "beaver", "camel", "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer", "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat", "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose", "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", "python", "rabbit", "ram", "rat", "raven", "rhino", "salmon", "seal", "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan", "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf", "wombat", "zebra"};
    public static String[] gallows = new String[]{"+---+\n|   |\n    |\n    |\n    |\n    |\n=========\n", "+---+\n|   |\nO   |\n    |\n    |\n    |\n=========\n", "+---+\n|   |\nO   |\n|   |\n    |\n    |\n=========\n", " +---+\n |   |\n O   |\n/|   |\n     |\n     |\n =========\n", " +---+\n |   |\n O   |\n/|\\  |\n     |\n     |\n =========\n", " +---+\n |   |\n O   |\n/|\\  |\n/    |\n     |\n =========\n", " +---+\n |   |\n O   |\n/|\\  |\n/ \\  |\n     |\n =========\n"};

    public Hangman() {
    }

    public static void main(String[] var0) {
        HashMap var1 = new HashMap();
        ArrayList var2 = new ArrayList();
        int var3 = 0;
        boolean var4 = false;
        boolean var6 = false;
        boolean var7 = false;
        String var8 = randomWord(words);
        System.out.println(var8 + "\n");
        new ArrayList();

        while(true) {
            do {
                char var5 = getGuess(var3, gallows, var8, var2, var1);
                var7 = checkForInput(var8, var5, var1, var2, var7);
                gameIsOver(var3, var1, var8, gallows);
            } while(!var7);

            ++var3;
        }
    }

    public static String randomWord(String[] var0) {
        Random var1 = new Random();
        int var2 = var1.nextInt(64);
        String var3 = var0[var2];
        return var3;
    }

    public static char getGuess(int var0, String[] var1, String var2, ArrayList<Character> var3, HashMap<Integer, Character> var4) {
        System.out.println("\n" + var1[var0]);
        System.out.print("\n Word: \t");

        int var5;
        for(var5 = 0; var5 < var2.length(); ++var5) {
            if (var4.get(var5) == null) {
                System.out.print("_");
            } else {
                System.out.print(var4.get(var5));
            }
        }

        System.out.print("\n\n Misses: ");

        for(var5 = 0; var5 < var3.size(); ++var5) {
            System.out.print(var3.get(var5));
        }

        System.out.print("\n\n Guess: ");
        Scanner var7 = new Scanner(System.in);
        char var6 = var7.next().charAt(0);
        var7.nextLine();
        ++var0;
        return var6;
    }

    public static boolean checkForInput(String var0, char var1, HashMap<Integer, Character> var2, ArrayList<Character> var3, boolean var4) {
        int var5 = 0;
        char[] var6 = var0.toCharArray();

        for(int var7 = 0; var7 < var6.length; ++var7) {
            if (var6[var7] == var1) {
                var2.put(var7, var1);
                ++var5;
            }
        }

        if (var5 == 0) {
            var3.add(var1);
            return true;
        } else {
            return false;
        }
    }

    public static void gameIsOver(int var0, HashMap<Integer, Character> var1, String var2, String[] var3) {
        StringBuilder var4 = new StringBuilder();

        for(int var5 = 0; var5 < var1.size(); ++var5) {
            var4.append(var1.get(var5));
        }

        String var6 = var4.toString();
        if (var6.equals(var2)) {
            System.out.println("\n You won!");
            System.exit(0);
        }

        if (var0 >= 5) {
            System.out.println("\n You lose :(");
            System.out.println("\n" + var3[var0 + 1]);
            System.exit(0);
        }

    }
}
