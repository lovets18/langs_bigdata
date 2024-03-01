import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Fourth_3 {
    public static HashSet<String> findUniqueWords(String text, int wordLength) {
        HashSet<String> uniqueWords = new HashSet<>();

        Pattern sentencePattern = Pattern.compile("[^?!\\.]*\\?");
        Matcher sentenceMatcher = sentencePattern.matcher(text);

        while (sentenceMatcher.find()) {
            String sentence = sentenceMatcher.group();
            Pattern wordPattern = Pattern.compile("\\b\\w{" + wordLength + "}\\b");
            Matcher wordMatcher = wordPattern.matcher(sentence);

            while (wordMatcher.find()) {
                uniqueWords.add(wordMatcher.group());
            }
        }

        return uniqueWords;
    }

    public static void main(String[] args) {
        String text = "What is your name? How are you doing? Where do you live? Java is a popular akk programming language";

//        int wordLength = 3; // Заданная длина слова
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        int wordLength = scanner.nextInt();

        HashSet<String> uniqueWords = findUniqueWords(text, wordLength);

        System.out.println("Уникальные слова заданной длины во всех вопросительных предложениях:");
        for (String word : uniqueWords) {
            System.out.println(word);
        }
    }

//    public static void main(String[] args) {
//        String text = "What is your name? How are you doing? Where do you live? Java is a popular akk programming language";
//
////        Pattern questionPattern = Pattern.compile("\\b(\\w+)\\b[?]");
////        Pattern questionPattern = Pattern.compile("\\b(\\w+)\\b[?]");
////        String[] sentences = text.split("(\\\\p{Punct}\\\\s*)?(.*?)(\\\\p{Punct})*(\\\\.\\\\s*|\\\\?\\\\s*|\\\\!)");
////        String[] sentences = text.split("\\[.?!]\\s*");
//        String[] sentences = text.split("[\\.?!]\\s*");
//        System.out.println(sentences.length);
////        Matcher matcher = questionPattern.matcher(text);
//
//        Set<String> uniqueWords = new HashSet<>();
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter n: ");
//        int wordLength = scanner.nextInt();
//        for (String sent : sentences) {
//            Pattern pattern = Pattern.compile("^.+(?:\\?$)");
//            Matcher matcher = pattern.matcher(sent);
//            if (matcher.matches()) {
//                Pattern wordPattern = Pattern.compile("\\b(\\w+)\\b");
//                Matcher wordMatcher = wordPattern.matcher(sent);
//
//                while (wordMatcher.find()) {
//                    String word = wordMatcher.group(1);
//                    if (word.length() == wordLength) {
//                        uniqueWords.add(word.toLowerCase());
//                    }
//                }
//            }
//
//        }
//
//
//        if (!uniqueWords.isEmpty()) {
//            System.out.println("Слова заданной длины без повторений в вопросительных предложениях:");
//            for (String word : uniqueWords) {
//                System.out.println(word);
//            }
//        } else {
//            System.out.println("В вопросительных предложениях нет слов заданной длины.");
//        }
//    }

}
