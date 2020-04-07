package converter;

import java.util.Scanner;

/**
 * The Numeral System Converter project
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
        String decimal = "" + 10;
        String binary = "0b" + Integer.toBinaryString(Integer.parseInt(decimal));
        System.out.println(decimal + " = " + binary);
    }

    /**
     * Stage two of the project
     */
    public static void stage2() {
        Scanner sc = new Scanner(System.in);
        String res = "";
        int dec = sc.nextInt();
        int base = 8;
        int rem;
        if (dec == 0) {
            res = "0";
        }
        while (dec > 0) {
            rem = dec % base;
            if (base == 16) {
                if (rem == 10)
                    res += 'A';
                else if (rem == 11)
                    res += 'B';
                else if (rem == 12)
                    res += 'C';
                else if (rem == 13)
                    res += 'D';
                else if (rem == 14)
                    res += 'E';
                else if (rem == 15)
                    res += 'F';
                else
                    res += rem;
            } else
                res += rem;

            dec /= base;
        }
        String ret = new StringBuilder(res).reverse().toString();
        if (ret.length() > 1) {
            System.out.println(ret.substring(ret.length() - 1));
        } else {
            System.out.println(ret);
        }
    }

    /**
     * Stage three of the project
     */
    public static void stage3() {
        Scanner sc = new Scanner(System.in);
        String res = "";
        int in = sc.nextInt();
        int base = sc.nextInt();
        int rem;
        if (in == 0) {
            res = "0";
        }
        while (in > 0) {
            rem = in % base;
            if (base == 16) {
                if (rem == 10)
                    res += 'a';
                else if (rem == 11)
                    res += 'b';
                else if (rem == 12)
                    res += 'c';
                else if (rem == 13)
                    res += 'd';
                else if (rem == 14)
                    res += 'e';
                else if (rem == 15)
                    res += 'f';
                else
                    res += rem;
            } else
                res += rem;

            in /= base;
        }
        if (base == 16) {
            res += "x0";
        } else if (base == 2) {
            res += "b0";
        } else if (base == 8) {
            res += "0";
        }
        String ret = new StringBuilder(res).reverse().toString();
        System.out.println(ret);
    }

    /**
     * Stage four of the project
     */
    public static void stage4() {
        Scanner sc = new Scanner(System.in);
        int sourceRad = sc.nextInt();
        int sourceNum = sc.nextInt();
        int targetRad = sc.nextInt();
        String targetNum = "";

        if (sourceRad == 1 || targetRad == 1) {
            if (sourceRad == 1) {
                sourceRad = 10;
                sourceNum = String.valueOf(sourceNum).length();
                targetNum = Integer.toString(Integer.parseInt(String.valueOf(sourceNum), sourceRad), targetRad);
            }
            if (targetRad == 1) {
                for (int i = 0; i < Integer.parseInt(String.valueOf(sourceNum), sourceRad); i++) {
                    targetNum += '1';
                }
            }
        } else {
            targetNum = Integer.toString(Integer.parseInt(String.valueOf(sourceNum), sourceRad), targetRad);
        }

        System.out.println(targetNum);
    }

    /**
     * Stage five of the project
     */
    public static void stage5() {
        Scanner sc = new Scanner(System.in);
        boolean isFloat = false;
        int sourceRad = sc.nextInt();
        String sourceNum = sc.next();
        int targetRad = sc.nextInt();
        double dec;
        String targetNum = "";

        String integerPar = "";
        String fractionPar = "";

        if (sourceNum.contains(".")) {
            isFloat = true;
            integerPar = sourceNum.split("\\.")[0];
            fractionPar = sourceNum.split("\\.")[1];
        } else {
            integerPar = sourceNum;
        }

        if (sourceRad == 1) {
            dec = sourceNum.length();
        } else {
            dec = Long.parseLong(integerPar, sourceRad);
        }

        for (int i = 0; i < fractionPar.length(); i++) {
            dec += Integer.parseInt(Character.toString(fractionPar.charAt(i)), sourceRad) / Math.pow(sourceRad, i + 1);
        }

        long integerParLong = (long) dec;
        double fractionParDouble = dec - integerParLong;
        if (targetRad == 1) {
            for (int i = 0; i < integerParLong; i++) {
                targetNum += '1';
            }
        } else {
            targetNum += Long.toString(integerParLong, targetRad);

            if (isFloat) {
                targetNum += '.';
                if (fractionParDouble == 0) {
                    targetNum += '0';
                }
            }
            int k = 5;
            while (fractionParDouble > 0 && k > 0) {
                k--;
                fractionParDouble *= targetRad;
                targetNum += Long.toString((int) fractionParDouble, targetRad);
                fractionParDouble -= (int) fractionParDouble;
            }
        }

        System.out.println(targetNum);
    }
}
