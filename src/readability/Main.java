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
}
