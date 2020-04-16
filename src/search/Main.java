package search;

import java.util.Scanner;

/**
 * The Simple Search Engine project
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
        String[] words = sc.nextLine().split(" ");
        String searchPhrase = sc.nextLine();
        int index = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(searchPhrase)) {
                index = i+1;
            }
        }
        System.out.println((index == -1) ? "Not found" : String.valueOf(index));
    }
}
