import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Third_2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";

        Map<Character, Integer> charFrequency = new HashMap<>();
        Pattern pattern = Pattern.compile("\\S");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            char c = matcher.group().charAt(0);
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            int maxCount = 0;
            char mostFrequentChar = ' ';
            for (Entry<Character, Integer> entry : charFrequency.entrySet()) {
                if (entry.getValue() > maxCount) {
                    maxCount = entry.getValue();
                    mostFrequentChar = entry.getKey();
                }
            }

            System.out.println("Символ: " + mostFrequentChar + ", Количество: " + maxCount);
            charFrequency.remove(mostFrequentChar);
        }
    }

}
