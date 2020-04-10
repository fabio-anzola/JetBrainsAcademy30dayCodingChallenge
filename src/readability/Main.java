package readability;

import java.util.Scanner;

/**
 * The Readability Score project
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
        Scanner sc = new Scanner(System.in);
        if (sc.nextLine().length() > 100) {
            System.out.println("HARD");
        } else {
            System.out.println("EASY");
        }
    }

    /**
     * Stage two of the project
     */
    public static void stage2() {
        Scanner sc = new Scanner(System.in);
        String[] sentence = sc.nextLine().split("[!\\?\\.]");
        int average = 0;
        for (String s : sentence) {
            average += s.split(" ").length;
        }
        if ((average / sentence.length) > 10) {
            System.out.println("HARD");
        } else {
            System.out.println("EASY");
        }
    }
}
