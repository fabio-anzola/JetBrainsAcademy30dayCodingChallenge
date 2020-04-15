package solver;

import java.io.File;
import java.io.PrintWriter;
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

    /**
     * Stage three of the project
     */
    public static void stage3(String[] args) throws Exception {
        //a11 x1 + a12 x2 + ... + a1n xn = b1
        //a21 x1 + a22 x2 + ... + a2n xn = b2
        //...
        //an1 x1 + an2 x2 + ... + ann xn = bn

        double epsilon = 1.0e-10;
        File in = null;
        File out = null;
        String outName = "";

        //get & process input
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-in") && i + 1 < args.length) {
                in = new File(args[i + 1]);
            }

            if (args[i].equals("-out") && i + 1 < args.length) {
                outName = args[i + 1];
                out = new File(outName);
            }
        }

        //define the matrix
        double[][] matrix = null;

        //fill the matrix (possibleException thrown)
        Scanner sc = new Scanner(in);
        int order = sc.nextInt();
        matrix = new double[order][order + 1];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = sc.nextDouble();
            }
        }

        //solve equation
        System.out.println("Start solving the equation.");
        System.out.println("Rows manipulation:");

        for (int i = 0; i < matrix.length; i++) {
            if (Math.abs(matrix[i][i] - 0.0) <= epsilon) {
                for (int j = i + 1; j < matrix[i].length; j++) {
                    if (!(Math.abs(matrix[j][i] - 0.0) <= epsilon)) {

                        for (int k = i; k < matrix[i].length; k++) {
                            matrix[i][k] += matrix[j][k];
                        }

                        System.out.printf("R%d + R%d -> R%d\n", i + 1, j + 1, i + 1);

                        break;
                    }
                }
            }

            if (!(Math.abs(matrix[i][i] - 1) <= epsilon)) {
                double coefficient = matrix[i][i];

                if (!(Math.abs(coefficient - 0) <= epsilon)) {
                    System.out.printf("%.1f * R%d -> R%d\n", coefficient, i + 1, i + 1);
                    for (int j = i; j < matrix[i].length; j++) {
                        matrix[i][j] /= coefficient;
                    }
                }
            }

            for (int j = i + 1; j < matrix.length; j++) {

                if (Math.abs(matrix[i][i] - 0) <= epsilon) {
                    throw new IllegalArgumentException();
                }

                double coefficient = -(matrix[j][i] / matrix[i][i]);

                if (!(Math.abs(coefficient - 0) <= epsilon)) {
                    System.out.printf("%.1f * R%d + R%d -> R%d\n", coefficient, i + 1, j + 1, j + 1);
                    for (int k = i; k < matrix[i].length; k++) {
                        matrix[j][k] += matrix[i][k] * coefficient;
                    }
                }
            }
        }

        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = i; j > 0; j--) {
                double coefficient = -matrix[j - 1][i];

                if (!(Math.abs(matrix[i][i] - 0.0) <= epsilon)) {
                    for (int k = matrix[i].length - 1; k > 0; k--) {
                        matrix[j - 1][k] += matrix[i][k] * coefficient;
                    }

                    System.out.printf("%.1f * R%d + R%d -> R%d\n", coefficient, i + 1, j + 1, j + 1);
                }
            }
        }

        //define result array
        double[] result = new double[matrix.length];

        //fill result array
        for (int i = 0; i < matrix.length; i++) {
            result[i] = matrix[i][matrix[i].length - 1];
        }

        //print the solution
        System.out.print("The solution is: (");
        for (int i = 0; i < result.length; i++) {
            if (i != result.length - 1) {
                System.out.printf("%.1f, ", result[i]);
            } else {
                System.out.printf("%.1f)\n", result[i]);
            }
        }

        //print to be saved to file
        System.out.println("Saved to file " + outName);

        try (PrintWriter pw = new PrintWriter(out)) {
            for (double v : result) {
                pw.println(v);
            }

        }
    }
}
