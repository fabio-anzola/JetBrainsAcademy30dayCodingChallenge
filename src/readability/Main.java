package readability;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    /**
     * Stage four of the project
     */
    public static void stage4(String[] args) throws IOException {
        int words = 0;
        int sentences = 0;
        int characters = 0;
        int syllables = 1;
        double score = 0;
        int polysyllables = 0;
        double L;
        double S;
        String inp = "";
        ArrayList<String> wordArr = new ArrayList<>();
        ArrayList<Integer> syl = new ArrayList<>();
        String[] ages = new String[]{"6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "24", "24+"};


        Scanner sc = new Scanner(System.in);

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
                inp += line;
            }

            String[] sentence = inp.split("[!?.]");
            sentences += sentence.length;
            for (String s : sentence) {
                if (s.charAt(0) == ' ') {
                    s = s.substring(1);
                }
                words += s.split(" ").length;
                wordArr.addAll(Arrays.asList(s.split(" ")));
            }

            for (String s : wordArr) {
                ArrayList<String> tokens = new ArrayList<>();
                String regexp = "[bcdfghjklmnpqrstvwxz]*[aeiouy]+[bcdfghjklmnpqrstvwxz]*";
                Pattern p = Pattern.compile(regexp);
                Matcher m = p.matcher(s.toLowerCase());
                while (m.find()) {
                    tokens.add(m.group());
                }
                if (tokens.size() > 1 && tokens.get(tokens.size() - 1).equals("e")) {
                    syl.add(tokens.size() - 1);
                    syllables += tokens.size() - 1;
                } else {
                    syllables += tokens.size();
                    syl.add(tokens.size());
                }
            }

            for (Integer integer : syl) {
                if (integer > 2) {
                    polysyllables++;
                }
            }

            System.out.println();
            System.out.println("Words: " + words);
            System.out.println("Sentences: " + sentences);
            System.out.println("Characters: " + characters);
            System.out.println("Syllables: " + syllables);
            System.out.println("Polysyllables: " + polysyllables);

            System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all):");
            switch (sc.nextLine()) {
                case "FK":
                    score = 0.39 * (double) words / (double) sentences + 11.8 * (double) syllables / (double) words - 15.59;
                    System.out.println(String.format("Flesch–Kincaid readability tests: %.2f (about %s year olds).", score, ages[(int) Math.round(score)]));
                    break;
                case "ARI":
                    score = (4.71F * ((double) characters / (double) words)) + (0.5F * ((double) words / (double) sentences)) - 21.43F;
                    System.out.println(String.format("Automated Readability Index: %.2f (about %s year olds).", score, ages[(int) Math.round(score)]));
                    break;
                case "SMOG":
                    score = 1.043 * Math.sqrt((double) polysyllables * 30.0 / (double) sentences) + 3.1291;
                    System.out.println(String.format("Simple Measure of Gobbledygook: %.2f (about %s year olds).", score, ages[(int) Math.round(score)]));
                    break;
                case "CL":
                    L = (double) characters / (double) words * 100;
                    S = (double) sentences / (double) words * 100;
                    score = 0.0588 * L - 0.296 * S - 15.8;
                    System.out.println(String.format("Coleman–Liau index: %.2f (about %s year olds).", score, ages[(int) Math.round(score)]));
                    break;
                case "all":
                    score = (4.71F * ((double) characters / (double) words)) + (0.5F * ((double) words / (double) sentences)) - 21.43F;
                    System.out.println(String.format("Automated Readability Index: %.2f (about %s year olds).", score, ages[(int) Math.round(score)]));
                    score = 0.39 * (double) words / (double) sentences + 11.8 * (double) syllables / (double) words - 15.59;
                    System.out.println(String.format("Flesch–Kincaid readability tests: %.2f (about %s year olds).", score, ages[(int) Math.round(score)]));
                    score = 1.043 * Math.sqrt((double) polysyllables * 30.0 / (double) sentences) + 3.1291;
                    System.out.println(String.format("Simple Measure of Gobbledygook: %.2f (about %s year olds).", score, ages[(int) Math.round(score)]));
                    L = (double) characters / (double) words * 100;
                    S = (double) sentences / (double) words * 100;
                    score = 0.0588 * L - 0.296 * S - 15.8;
                    System.out.println(String.format("Coleman–Liau index: %.2f (about %s year olds).", score, ages[(int) Math.round(score)]));
                    break;
            }
        }
    }
}
