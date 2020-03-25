package bot;

import java.util.Scanner;

/**
 * The Simple Chatty Bot project
 *
 * @author fabioanzola
 */
public class SimpleBot {
    public static void main(String[] args) {
    }

    /**
     * Stage one of the project
     */
    public static void stage1() {
        System.out.println("Hello! My name is IO-Bot");
        System.out.println("I was created in 2020");
    }

    /**
     * Stage two of the project
     */
    public static void stage2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! My name is IO-Bot");
        System.out.println("I was created in 2020");
        System.out.println("Please, remind me your name.");
        String name = sc.nextLine();
        System.out.println(String.format("What a great name you have, %s!", name));
        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");
        String[] ages = sc.nextLine().split(" ");
        double age = (Double.parseDouble(ages[0]) * 70 + Double.parseDouble(ages[1]) * 21 + Double.parseDouble(ages[2]) * 15) % 105;
        System.out.println(String.format("Your age is %.0f that's a good time to start programming!", age));
    }

    /**
     * Stage three of the project
     */
    public static void stage3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! My name is IO-Bot");
        System.out.println("I was created in 2020");
        System.out.println("Please, remind me your name.");
        String name = sc.nextLine();
        System.out.println(String.format("What a great name you have, %s!", name));
        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");
        String[] ages = sc.nextLine().split(" ");
        double age = (Double.parseDouble(ages[0]) * 70 + Double.parseDouble(ages[1]) * 21 + Double.parseDouble(ages[2]) * 15) % 105;
        System.out.println(String.format("Your age is %.0f that's a good time to start programming!", age));
        System.out.println("Now I will prove to you that I can count to any number you want.");
        int countTo = sc.nextInt();
        for (int i = 0; i <= countTo; i++) {
            System.out.println(i + "!");
        }
        System.out.println("Completed, have a nice day!");
    }

    /**
     * Stage 4 of the project
     */
    public static void stage4() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! My name is IO-Bot");
        System.out.println("I was created in 2020");
        System.out.println("Please, remind me your name.");
        String name = sc.nextLine();
        System.out.println(String.format("What a great name you have, %s!", name));
        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");
        String[] ages = sc.nextLine().split(" ");
        double age = (Double.parseDouble(ages[0]) * 70 + Double.parseDouble(ages[1]) * 21 + Double.parseDouble(ages[2]) * 15) % 105;
        System.out.println(String.format("Your age is %.0f that's a good time to start programming!", age));
        System.out.println("Now I will prove to you that I can count to any number you want.");
        int countTo = sc.nextInt();
        for (int i = 0; i <= countTo; i++) {
            System.out.println(i + "!");
        }
        System.out.println("Let's test your programming knowledge.");
        System.out.println("Why do we use methods?");
        System.out.println("1. To repeat a statement multiple times.");
        System.out.println("2. To decompose a program into several small subroutines.");
        System.out.println("3. To determine the execution time of a program.");
        System.out.println("4. To interrupt the execution of a program.");
        int choice = sc.nextInt();
        while (choice != 2) {
            System.out.println("Please, try again.");
            choice = sc.nextInt();
        }
        System.out.println("Congratulations, have a nice day!");
    }
}
