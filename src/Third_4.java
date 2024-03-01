import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Third_4 {
    public static List<String> sortWordsByLengthAndVowels(String text) {
        List<String> words = new ArrayList<>();
        Pattern wordPattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = wordPattern.matcher(text);

        while (matcher.find()) {
            words.add(matcher.group());
        }

        words.sort(new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                if (word1.length() != word2.length()) {
                    return Integer.compare(word2.length(), word1.length());
                } else {
                    int vowelsCount1 = countVowels(word1);
                    int vowelsCount2 = countVowels(word2);
                    return Integer.compare(vowelsCount1, vowelsCount2);
                }
            }
        });

        return words;
    }

    public static int countVowels(String word) {
        int count = 0;
        Pattern vowelPattern = Pattern.compile("[aeiouy]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = vowelPattern.matcher(word);

        while (matcher.find()) {
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите исходный текст:");
        String text = scanner.nextLine();
//        String text = "You can use the text for sortiAg vowel letters";

        List<String> sortedWords = sortWordsByLengthAndVowels(text);

        System.out.println("Отсортированные слова:");
        for (String word : sortedWords) {
            System.out.println(word);
        }
    }
}
