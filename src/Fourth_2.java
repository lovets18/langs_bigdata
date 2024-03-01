import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Fourth_2 {
    public static void main(String[] args) {
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";

        String[] sentences = text.split("\\.\\s*");

        for (String sentence : sentences) {
            Map<Character, Integer> vowelFrequency = new HashMap<>();
            Map<Character, Integer> consonantFrequency = new HashMap<>();
            Pattern pattern = Pattern.compile("[a-zA-Z]");
            Matcher matcher = pattern.matcher(sentence);

            while (matcher.find()) {
                char c = Character.toLowerCase(matcher.group().charAt(0));
                if ("aeiou".contains(String.valueOf(c))) {
                    vowelFrequency.put(c, vowelFrequency.getOrDefault(c, 0) + 1);
                } else {
                    consonantFrequency.put(c, consonantFrequency.getOrDefault(c, 0) + 1);
                }
            }

            int vowelCount = vowelFrequency.values().stream().mapToInt(Integer::intValue).sum();
            int consonantCount = consonantFrequency.values().stream().mapToInt(Integer::intValue).sum();

            System.out.println("Предложение: " + sentence);
            if (vowelCount > consonantCount) {
                System.out.println("Больше гласных букв");
            } else if (consonantCount > vowelCount) {
                System.out.println("Больше согласных букв");
            } else {
                System.out.println("Гласных и согласных букв одинаковое количество");
            }
            System.out.println("Гласных: " + vowelCount + " | Согласных: " + consonantCount);
            System.out.println();
        }
    }

}
