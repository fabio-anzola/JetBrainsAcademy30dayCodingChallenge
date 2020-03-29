package flashcards;

import java.util.Scanner;

/**
 * The Flashcards project
 *
 * @author fabioanzola
 */
public class Main {
    public static void main(String[] args) {
    }

    /**
     * Stage one of the project
     */
    public static void stage1() {
        String word = "Italy";
        String definition = "Rome";
        System.out.println("Card: \n" + word);
        System.out.println("Definition: \n" + definition);
    }

    /**
     * Stage two of the project
     */
    public static void stage2() {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        String def = sc.nextLine();
        String answer = sc.nextLine();
        if (answer.equals(def)) {
            System.out.println("Your answer is right!");
        } else {
            System.out.println("Your answer is wrong...");
        }
    }
}
