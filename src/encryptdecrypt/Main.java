package encryptdecrypt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * The Encrypt-Decrypt project
 *
 * @author fabioanzola
 */
public class Main {
    public static void main(String[] args) throws IOException {
    }

    /**
     * Stage one of the project
     */
    public static void stage1() {
        String in = "we found a treasure!";
        String out = "";
        String resource = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder rev = new StringBuilder(resource);
        String revResource = rev.reverse().toString();
        for (int i = 0; i < in.length(); i++) {
            if (resource.contains("" + in.charAt(i))) {
                for (int j = 0; j < resource.length(); j++) {
                    if (in.charAt(i) == resource.charAt(j)) {
                        out += revResource.charAt(j);
                        break;
                    }
                }
            } else {
                out += in.charAt(i);
            }
        }
        System.out.println(out);
    }

    /**
     * Stage two of the project
     */
    public static void stage2() {
        Scanner userIn = new Scanner(System.in);
        String in = userIn.nextLine();
        int shift = userIn.nextInt();
        String out = "";
        String resource = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < in.length(); i++) {
            if (resource.contains("" + in.charAt(i))) {
                for (int j = 0; j < resource.length(); j++) {
                    int k = j + shift;
                    if (in.charAt(i) == resource.charAt(j)) {
                        if ((k) >= resource.length()) {
                            out += resource.charAt(k - resource.length());
                        } else {
                            out += resource.charAt(k);
                        }
                        break;
                    }
                }
            } else {
                out += in.charAt(i);
            }
        }
        System.out.println(out);
    }

    /**
     * Stage three of the project
     */
    public static void stage3() {
        Scanner userIn = new Scanner(System.in);
        String encDev = userIn.nextLine();
        String in = userIn.nextLine();
        int shift = userIn.nextInt();
        String out = "";
        for (int i = 0; i < in.length(); i++) {
            if (encDev.equals("enc")) {
                out += (char) (((int) in.charAt(i)) + shift);
            } else {
                out += (char) (((int) in.charAt(i)) - shift);
            }
        }
        System.out.println(out);
    }

    /**
     * Stage 4 of the project
     *
     * @param args The input-parameters (from main)
     */
    public static void stage4(String[] args) {
        String encDev = "enc";
        String in = "";
        int shift = 0;
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-mode")) {
                encDev = args[i + 1];
            }
            if (args[i].equals("-key")) {
                shift = Integer.parseInt(args[i + 1]);
            }
            if (args[i].equals("-data")) {
                in = args[i + 1];
            }
        }
        String out = "";
        for (int i = 0; i < in.length(); i++) {
            if (encDev.equals("enc")) {
                out += (char) (((int) in.charAt(i)) + shift);
            } else {
                out += (char) (((int) in.charAt(i)) - shift);
            }
        }
        System.out.println(out);
    }

    /**
     * Stage 5 of the project
     *
     * @param args The input-parameters (from main)
     */
    public static void stage5(String[] args) {
        String encDev = "enc";
        int shift = 0;
        String in = "";
        String out = "";
        String inFile = "";
        String outFile = "";
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-mode")) {
                encDev = args[i + 1];
            }
            if (args[i].equals("-key")) {
                shift = Integer.parseInt(args[i + 1]);
            }
            if (args[i].equals("-data")) {
                in = args[i + 1];
            }
            if (args[i].equals("-in")) {
                inFile = args[i + 1];
            }
            if (args[i].equals("-out")) {
                outFile = args[i + 1];
            }
        }
        try {
            if (!in.equals("")) {
                for (int i = 0; i < in.length(); i++) {
                    if (encDev.equals("enc")) {
                        out += (char) (((int) in.charAt(i)) + shift);
                    } else {
                        out += (char) (((int) in.charAt(i)) - shift);
                    }
                }
            } else {
                try (
                        BufferedReader br = Files.newBufferedReader(Paths.get(inFile), StandardCharsets.UTF_8);
                        BufferedWriter bw = Files.newBufferedWriter(Paths.get(outFile), StandardCharsets.UTF_8)

                ) {
                    String line;

                    while ((line = br.readLine()) != null) {
                        out = "";
                        for (int i = 0; i < line.length(); i++) {
                            if (encDev.equals("enc")) {
                                out += (char) (((int) line.charAt(i)) + shift);
                            } else {
                                out += (char) (((int) line.charAt(i)) - shift);
                            }
                        }
                        bw.write(out + System.lineSeparator());
                    }
                }
            }
            for (int i = 0; i < in.length(); i++) {
                if (encDev.equals("enc")) {
                    out += (char) (((int) in.charAt(i)) + shift);
                } else {
                    out += (char) (((int) in.charAt(i)) - shift);
                }
            }
            System.out.println(out);
        }
        catch (Exception e) {
            System.out.println("Sorry, an error occurred. Please check your input.");
        }
    }

    /**
     * Stage 6 of the prject (final stage)
     *
     * @param args The input-parameters (from main)
     * @throws IOException if an error occurs
     */
    public static void stage6(String[] args) throws IOException {
        String encDev = "enc";
        int shift = 0;
        String in = "";
        String out = "";
        String inFile = "";
        String outFile = "";
        String algorithm = "bin";
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-mode")) {
                encDev = args[i + 1];
            }
            if (args[i].equals("-key")) {
                shift = Integer.parseInt(args[i + 1]);
            }
            if (args[i].equals("-data")) {
                in = args[i + 1];
            }
            if (args[i].equals("-in")) {
                inFile = args[i + 1];
            }
            if (args[i].equals("-out")) {
                outFile = args[i + 1];
            }
            if (args[i].equals("-alg")) {
                algorithm = args[i + 1];
            }
        }
        if (!in.equals("")) {
            if (algorithm.equals("shift")) {
                Shift sh = new Shift(in, shift, encDev.equals("enc"));
                out = sh.toString();
            } else {
                Unicode un = new Unicode(in, shift, encDev.equals("enc"));
                out = un.toString();
            }
            System.out.println(out);
        } else {
            try (
                    BufferedReader br = Files.newBufferedReader(Paths.get(inFile), StandardCharsets.UTF_8);
                    BufferedWriter bw = Files.newBufferedWriter(Paths.get(outFile), StandardCharsets.UTF_8);
            ) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (algorithm.equals("shift")) {
                        Shift sh = new Shift(line, shift, encDev.equals("enc"));
                        out = sh.toString();
                    } else {
                        Unicode un = new Unicode(line, shift, encDev.equals("enc"));
                        out = un.toString();
                    }
                    bw.write(out);
                }
            }
        }
    }
}
