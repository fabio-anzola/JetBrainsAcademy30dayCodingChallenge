package converter;

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
}
