import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Fourth_1 {
    public static void main(String[] args) {
        String text = " this line tests regex algo";
        int wordLength = 5;
        String replacement = "*****";

        Pattern pattern = Pattern.compile("\\b\\w{" + wordLength + "}\\b");
        Matcher matcher = pattern.matcher(text);

        StringBuffer result = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(result, replacement);
        }
        matcher.appendTail(result);

        System.out.println(result.toString());
    }

}
