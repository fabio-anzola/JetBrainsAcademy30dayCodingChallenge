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

    /**
     * Stage three of the project
     */
    public static void stage3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the number of cards:");
        int stack = Integer.parseInt(sc.nextLine());
        String[][] card = new String[stack][2];
        for (int i = 0; i < card.length; i++) {
            System.out.println(String.format("The card #%d:", i + 1));
            card[i][0] = sc.nextLine();
            System.out.println(String.format("The definition of the card #%d:", i + 1));
            card[i][1] = sc.nextLine();
        }
        for (String[] strings : card) {
            System.out.println(String.format("Print the definition of \"%s\":", strings[0]));
            if (sc.nextLine().equals(strings[1])) {
                System.out.println("Correct answer.");
            } else {
                System.out.println(String.format("Wrong answer. The correct one is \"%s\".", strings[1]));
            }
        }
    }
}
