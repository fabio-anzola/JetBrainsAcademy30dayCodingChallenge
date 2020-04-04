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
        System.out.println(decimal +  " = " + binary);
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
            System.out.println(ret.substring(ret.length()-1));
        } else {
            System.out.println(ret);
        }
    }
}
