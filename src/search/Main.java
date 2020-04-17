package search;

import java.util.ArrayList;
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

    /**
     * Stage two of the project
     */
    public static void stage2() {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> resource = new ArrayList<>();
        System.out.println("Enter the number of people:");
        int people = Integer.parseInt(sc.nextLine());
        System.out.println("Enter all people:");
        for (int i = 0; i < people; i++) {
            String name = sc.nextLine();
            resource.add(name);
        }
        sc.reset();
        System.out.println("Enter the number of search queries:");
        int searches = Integer.parseInt(sc.nextLine());
        sc.reset();
        if (searches < 1 || resource.size() == 0) {
            return;
        }
        boolean foundSomething = false;
        for (int i = 0; i < searches; i++) {
            System.out.println("Enter data to search people:");
            String searchString = sc.nextLine().trim();
            for (int j = 0; j < resource.size(); j++) {
                if (resource.get(j).toLowerCase().contains(searchString.toLowerCase())) {
                    if (!foundSomething) {
                        System.out.println("Found people:");
                    }
                    System.out.println(resource.get(j));
                    foundSomething = true;
                }
            }
            if (!foundSomething) {
                System.out.println("No matching people found.");
            }
            foundSomething = false;
        }
    }
}
