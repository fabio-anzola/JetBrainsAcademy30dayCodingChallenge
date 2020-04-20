package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

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
                index = i + 1;
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

    /**
     * Stage three of the project
     */
    public static void stage3() {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> resource = new ArrayList<>();
        System.out.println("Enter the number of people:");
        int people = Integer.parseInt(sc.nextLine());
        System.out.println("Enter all people:");
        for (int i = 0; i < people; i++) {
            String name = sc.nextLine();
            resource.add(name);
        }

        while (true) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Find a person\n"
                    + "2. Print all people\n"
                    + "0. Exit");
            switch (Integer.parseInt(sc.nextLine())) {
                case 1:
                    System.out.println("Enter a name or email to search all suitable people.");
                    boolean foundSomething = false;
                    String searchString = sc.nextLine().trim();
                    for (String s : resource) {
                        if (s.toLowerCase().contains(searchString.toLowerCase())) {
                            System.out.println(s);
                            foundSomething = true;
                        }
                    }
                    if (!foundSomething) {
                        System.out.println("No matching people found.");
                    }
                    break;

                case 2:
                    System.out.println("=== List of people ===");
                    for (String s : resource) {
                        System.out.println(s);
                    }
                    break;

                case 0:
                    System.out.println("Bye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Incorrect option! Try again.");
                    break;
            }
        }
    }

    /**
     * Stage four of the project
     */
    public static void stage4(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> resource = new ArrayList<>();
        String pathToPersons = "";
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("--data")) {
                pathToPersons = args[i + 1];
            }
        }
        try (
                BufferedReader in = Files.newBufferedReader(Paths.get(pathToPersons), StandardCharsets.UTF_8);

        ) {
            String line;

            while ((line = in.readLine()) != null) {
                resource.add(line);
            }
        }

        while (true) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Find a person\n"
                    + "2. Print all people\n"
                    + "0. Exit");
            switch (Integer.parseInt(sc.nextLine())) {
                case 1:
                    System.out.println("Enter a name or email to search all suitable people.");
                    boolean foundSomething = false;
                    String searchString = sc.nextLine().trim();
                    for (String s : resource) {
                        if (s.toLowerCase().contains(searchString.toLowerCase())) {
                            System.out.println(s);
                            foundSomething = true;
                        }
                    }
                    if (!foundSomething) {
                        System.out.println("No matching people found.");
                    }
                    break;

                case 2:
                    System.out.println("=== List of people ===");
                    for (String s : resource) {
                        System.out.println(s);
                    }
                    break;

                case 0:
                    System.out.println("Bye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Incorrect option! Try again.");
                    break;
            }
        }
    }

    /**
     * Stage five of the project
     */
    public static void stage5(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        List<String> resource = new ArrayList<>();
        Map<String, ArrayList<Integer>> map = new LinkedHashMap<>();
        String pathToPersons = "";
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("--data")) {
                pathToPersons = args[i + 1];
            }
        }
        try (
                BufferedReader in = Files.newBufferedReader(Paths.get(pathToPersons), StandardCharsets.UTF_8);

        ) {
            String line;

            while ((line = in.readLine()) != null) {
                resource.add(line);
            }
        }

        int i = 0;
        while (i < resource.size()) {
            for (String item : resource.get(i).split(" ")) {
                if (map.containsKey(item)) {
                    map.get(item).add(i);
                } else {
                    ArrayList<Integer> integerList = new ArrayList<>();
                    integerList.add(i);
                    map.put(item, integerList);
                }
            }
            ++i;
        }
        for (String item : map.keySet()) {
            System.out.println(item + map.get(item).toString());
        }
        while (true) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Find a person\n"
                    + "2. Print all people\n"
                    + "0. Exit");
            switch (Integer.parseInt(sc.nextLine())) {
                case 1:
                    System.out.println("Enter a name or email to search all suitable people.");
                    String searchString = sc.nextLine().trim();
                    List<String> found = new ArrayList<>();
                    if (map.containsKey(searchString)) {
                        for (Integer findKey : map.get(searchString)) {
                            found.add(resource.get(findKey));
                        }
                    }
                    if (found.size() > 0) {
                        System.out.println(found.size() + " persons found: ");
                        for (String item : found) {
                            System.out.println(item);
                        }
                    } else {
                        System.out.println("No matching people found.");
                    }
                    break;
                case 2:
                    System.out.println("=== List of people ===");
                    for (String s : resource) {
                        System.out.println(s);
                    }
                    break;

                case 0:
                    System.out.println("Bye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Incorrect option! Try again.");
                    break;
            }
        }
    }
}
