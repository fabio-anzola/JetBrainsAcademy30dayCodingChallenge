package solver;

import java.util.Scanner;

/**
 * The Linear Equations Solver project
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
        // a * x = b
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        double a = Double.parseDouble(input.split(" ")[0]);
        double b = Double.parseDouble(input.split(" ")[1]);
        double x = b / a;
        System.out.println(x);
    }

    /**
     * Stage two of the project
     */
    public static void stage2() {
        // ax + by = c
        // dx + ey = f
        // -----------
        // ax + by = c
        // y = (f - c * d / a) / (e - b * d / a)
        // -----------
        // x = (c - b * y) / a
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String line2 = sc.nextLine();
        double a = Double.parseDouble(line1.split(" ")[0]);
        double b = Double.parseDouble(line1.split(" ")[1]);
        double c = Double.parseDouble(line1.split(" ")[2]);
        double d = Double.parseDouble(line2.split(" ")[0]);
        double e = Double.parseDouble(line2.split(" ")[1]);
        double f = Double.parseDouble(line2.split(" ")[2]);
        double y = (f - c * d / a) / (e - b * d / a);
        double x = (c - b * y) / a;
        System.out.println(x + " " + y);
    }
}
