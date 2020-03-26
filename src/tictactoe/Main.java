package tictactoe;

import java.util.Scanner;

/**
 * The Tic-Tac-Toe project
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
        char[][] field = new char[3][3];
        field = new char[][]{
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'X', 'O', 'X'}
        };

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
                if (j != field[i].length - 1) {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }

    /**
     * Stage two of the project
     */
    public static void stage2() {
        char[][] field = new char[3][3];

        Scanner sc = new Scanner(System.in);

        char[] in = sc.nextLine().toCharArray();

        for (int i = 0, n = 0; i < 3; i++) {
            System.arraycopy(in, n, field[i], 0, 3);
            n += 3;
        }

        System.out.println("---------");
        for (char[] chars : field) {
            for (int j = 0; j < chars.length; j++) {
                if (j == 0) {
                    System.out.print("| ");
                }
                System.out.print(chars[j]);
                System.out.print(' ');
                if (j == chars.length - 1) {
                    System.out.print('|');
                }
            }
            System.out.println();
        }
        System.out.println("---------");
    }
}
