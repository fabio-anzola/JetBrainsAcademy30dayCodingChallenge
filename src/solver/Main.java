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
}
