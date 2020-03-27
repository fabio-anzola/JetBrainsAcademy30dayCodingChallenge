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

    /**
     * Stage three of the project
     */
    public static void stage3() {
        char[][] field = new char[3][3];

        Scanner sc = new Scanner(System.in);

        char[] in = sc.nextLine().toCharArray();

        for (int i = 0, n = 0; i < field.length; i++) {
            System.arraycopy(in, n, field[i], 0, field.length);
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

        boolean xWins = false;
        boolean oWins = false;
        boolean impossible = false;
        int counterX = 0;
        int counterO = 0;

        for (char[] chars : field) {
            for (char aChar : chars) {
                if (aChar == 'O') {
                    counterO++;
                }
                if (aChar == 'X') {
                    counterX++;
                }
            }
        }
        if (Math.abs(counterO - counterX) > 1) {
            impossible = true;
        }
        if (!impossible) {
            //Check rows
            for (char[] chars : field) {
                if (chars[0] == (chars[1])) {
                    if (chars[0] == (chars[2])) {
                        if (chars[0] == ('X')) {
                            xWins = true;
                        }
                        if (chars[0] == ('O')) {
                            oWins = true;
                        }
                    }
                }
            }

            //Check columns
            for (int i = 0; i < field.length; i++) {
                if (field[0][i] == (field[1][i])) {
                    if (field[0][i] == (field[2][i])) {
                        if (field[0][i] == ('X')) {
                            xWins = true;
                        }
                        if (field[0][i] == ('O')) {
                            oWins = true;
                        }
                    }
                }
            }

            //Diagonals
            if (field[0][0] == (field[1][1])) {
                if (field[0][0] == (field[2][2])) {
                    if (field[0][0] == ('X')) {
                        xWins = true;
                    }
                    if (field[0][0] == ('O')) {
                        oWins = true;
                    }
                }
            }
            if (field[2][0] == (field[1][1])) {
                if (field[2][0] == (field[0][2])) {
                    if (field[2][0] == ('X')) {
                        xWins = true;
                    }
                    if (field[2][0] == ('O')) {
                        oWins = true;
                    }
                }
            }
        }

        //Game status
        if (impossible || xWins && oWins) {
            System.out.println("Impossible");
        } else {
            if (xWins) {
                System.out.println("X wins");
            } else if (oWins) {
                System.out.println("O wins");
            } else if ((counterO + counterX) != 9) {
                System.out.println("Game not finished");
            } else {
                System.out.println("Draw");
            }
        }
    }

    /**
     * Stage four of the project
     */
    public static void stage4() {
        char[][] field = new char[3][3];

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter cells: ");
        char[] in = sc.nextLine().toCharArray();

        for (int i = 0, n = 0; i < field.length; i++) {
            System.arraycopy(in, n, field[i], 0, field.length);
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

        boolean xWins = false;
        boolean oWins = false;
        boolean impossible = false;
        int counterX = 0;
        int counterO = 0;
        boolean out = false;

        for (int f = 0; f < 9; f++) {

            System.out.print("Enter the coordinates: ");
            String[] inp = sc.nextLine().split(" ");
            if (!inp[0].matches("\\d+") || !inp[1].matches("\\d+") || inp.length != 2) {
                System.out.println("You should enter numbers!");
            } else {

                int y = Integer.parseInt(inp[0]) - 1;
                int x = 3 - Integer.parseInt(inp[1]);

                if (x > 2 || x < 0 || y > 2 || y < 0) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else {

                    if (field[x][y] != '_') {
                        System.out.println("This cell is occupied! Choose another one!");
                    } else {
                        counterX = 0;
                        counterO = 0;

                        field[x][y] = 'X';

                        for (char[] chars : field) {
                            for (char aChar : chars) {
                                if (aChar == 'O') {
                                    counterO++;
                                }
                                if (aChar == 'X') {
                                    counterX++;
                                }
                            }
                        }
                        if (Math.abs(counterO - counterX) > 1) {
                            impossible = true;
                        }
                        if (!impossible) {
                            //Check rows
                            for (char[] chars : field) {
                                if (chars[0] == (chars[1])) {
                                    if (chars[0] == (chars[2])) {
                                        if (chars[0] == ('X')) {
                                            xWins = true;
                                        }
                                        if (chars[0] == ('O')) {
                                            oWins = true;
                                        }
                                    }
                                }
                            }

                            //Check columns
                            for (int i = 0; i < field.length; i++) {
                                if (field[0][i] == (field[1][i])) {
                                    if (field[0][i] == (field[2][i])) {
                                        if (field[0][i] == ('X')) {
                                            xWins = true;
                                        }
                                        if (field[0][i] == ('O')) {
                                            oWins = true;
                                        }
                                    }
                                }
                            }

                            //Diagonals
                            if (field[0][0] == (field[1][1])) {
                                if (field[0][0] == (field[2][2])) {
                                    if (field[0][0] == ('X')) {
                                        xWins = true;
                                    }
                                    if (field[0][0] == ('O')) {
                                        oWins = true;
                                    }
                                }
                            }
                            if (field[2][0] == (field[1][1])) {
                                if (field[2][0] == (field[0][2])) {
                                    if (field[2][0] == ('X')) {
                                        xWins = true;
                                    }
                                    if (field[2][0] == ('O')) {
                                        oWins = true;
                                    }
                                }
                            }
                        }
                        if (!out) {
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
                        out = true;
                    }
                }
            }
        }
    }

    /**
     * Stage five of the project
     */
    public static void stage5() {
        char[][] field = new char[3][3];

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                field[i][j] = ' ';
            }
        }

        Scanner sc = new Scanner(System.in);

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

        boolean xWins = false;
        boolean oWins = false;
        boolean draw = false;
        int turn = 0;

        while (!xWins && !oWins && !draw) {

            System.out.print("Enter the coordinates: ");
            String[] inp = sc.nextLine().split(" ");
            if (inp.length != 2 || !inp[0].matches("\\d+") || !inp[1].matches("\\d+")) {
                System.out.println("You should enter numbers!");
            } else {
                int y = Integer.parseInt(inp[0]) - 1;
                int x = 3 - Integer.parseInt(inp[1]);

                if (x > 2 || x < 0 || y > 2 || y < 0) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else {
                    if (field[x][y] != ' ') {
                        System.out.println("This cell is occupied! Choose another one!");
                    } else {

                        turn++;

                        if (turn % 2 != 0) {
                            field[x][y] = 'X';
                        } else {
                            field[x][y] = 'O';
                        }

                        //Check rows
                        for (char[] chars : field) {
                            if (chars[0] == (chars[1])) {
                                if (chars[0] == (chars[2])) {
                                    if (chars[0] == ('X')) {
                                        xWins = true;
                                    }
                                    if (chars[0] == ('O')) {
                                        oWins = true;
                                    }
                                }
                            }
                        }

                        //Check columns
                        for (int i = 0; i < field.length; i++) {
                            if (field[0][i] == (field[1][i])) {
                                if (field[0][i] == (field[2][i])) {
                                    if (field[0][i] == ('X')) {
                                        xWins = true;
                                    }
                                    if (field[0][i] == ('O')) {
                                        oWins = true;
                                    }
                                }
                            }
                        }

                        //Diagonals
                        if (field[0][0] == (field[1][1])) {
                            if (field[0][0] == (field[2][2])) {
                                if (field[0][0] == ('X')) {
                                    xWins = true;
                                }
                                if (field[0][0] == ('O')) {
                                    oWins = true;
                                }
                            }
                        }
                        if (field[2][0] == (field[1][1])) {
                            if (field[2][0] == (field[0][2])) {
                                if (field[2][0] == ('X')) {
                                    xWins = true;
                                }
                                if (field[2][0] == ('O')) {
                                    oWins = true;
                                }
                            }
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

                    if (xWins) {
                        System.out.println("X wins");
                    } else if (oWins) {
                        System.out.println("O wins");
                    } else if (turn == 9) {
                        draw = true;
                        System.out.println("Draw");
                    }
                }
            }
        }
    }
}
