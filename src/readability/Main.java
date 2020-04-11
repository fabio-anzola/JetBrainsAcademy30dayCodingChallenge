package readability;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * The Readability Score project
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
        Scanner sc = new Scanner(System.in);
        if (sc.nextLine().length() > 100) {
            System.out.println("HARD");
        } else {
            System.out.println("EASY");
        }
    }

    /**
     * Stage two of the project
     */
    public static void stage2() {
        Scanner sc = new Scanner(System.in);
        String[] sentence = sc.nextLine().split("[!\\?\\.]");
        int average = 0;
        for (String s : sentence) {
            average += s.split(" ").length;
        }
        if ((average / sentence.length) > 10) {
            System.out.println("HARD");
        } else {
            System.out.println("EASY");
        }
    }

    /**
     * Stage three of the project
     */
    public static void stage3(String[] args) throws IOException {
        int words = 0;
        int sentences = 0;
        int characters = 0;
        try (
                BufferedReader in = Files.newBufferedReader(Paths.get(args[0]), StandardCharsets.UTF_8);

        ) {
            String line;
            System.out.println("The text is:");
            while ((line = in.readLine()) != null) {
                System.out.println(line);
                characters += line.replaceAll(" ", "").length();
                if (line.charAt(line.length() - 1) != '.' || line.charAt(line.length() - 1) != '!' || line.charAt(line.length() - 1) != '?') {
                    line += ".";
                }
                String[] sentence = line.split("[!?.]");
                sentences += sentence.length;
                for (String s : sentence) {
                    if (s.charAt(0) == ' ') {
                        s = s.substring(1);
                    }
                    words += s.split(" ").length;
                }
            }
            System.out.println();
            System.out.println("Words: " + words);
            System.out.println("Sentences: " + sentences);
            System.out.println("Characters: " + characters);
            double score = (4.71F * ((double) characters / (double) words)) + (0.5F * ((double) words / (double) sentences)) - 21.43F;
            System.out.println(String.format("The score is: %.2f", score));
            String[] ages = new String[]{"5-6", "6-7", "7-8", "8-9", "9-10", "10-11", "11-12", "12-13", "13-14", "14-15", "15-16", "16-17", "17-18", "18-24", "24+"};
            System.out.println(String.format("This text should be understood by %s year olds.", ages[(int) Math.ceil(score)]));
        }
    }
}
