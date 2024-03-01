import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Third_3 {
    public static void main(String[] args) {
        String text = "Java is a popular akk programming language. It is used for developing various applications. Java provides many features for developers.";

        String[] sentences = text.split("\\.\\s*");

        Set<String> uniqueWordsFirstSentence = new HashSet<>();
        Set<String> uniqueWordsOtherSentences = new HashSet<>();

        // Находим уникальные слова в первом предложении
        Pattern wordPattern = Pattern.compile("\\b\\w+\\b");
        Matcher matcher = wordPattern.matcher(sentences[0]);
        while (matcher.find()) {
            uniqueWordsFirstSentence.add(matcher.group().toLowerCase());
        }

        // Находим уникальные слова в остальных предложениях
        for (int i = 1; i < sentences.length; i++) {
            matcher = wordPattern.matcher(sentences[i]);
            while (matcher.find()) {
                uniqueWordsOtherSentences.add(matcher.group().toLowerCase());
            }
        }

        // Находим слово, которое есть только в первом предложении
        uniqueWordsFirstSentence.removeAll(uniqueWordsOtherSentences);

        if (!uniqueWordsFirstSentence.isEmpty()) {
            System.out.println("Слово(-а), которое(-ые) есть только в первом предложении: ");
            for (String element : uniqueWordsFirstSentence) {
                System.out.print(element + ", ");
            }
//            uniqueWordsFirstSentence.iterator().next());
        } else {
            System.out.println("В первом предложении нет слов, которых нет ни в одном из остальных предложений.");
        }
    }

}
