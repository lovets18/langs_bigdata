
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Third_1 {
    public static String replaceLetterAfterR(String text) {
        Pattern pattern = Pattern.compile("pa", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        StringBuffer correctedText = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(correctedText, "po");
        }
        matcher.appendTail(correctedText);

        return correctedText.toString();
    }

    public static void main(String[] args) {
        String text = "partenship asap after apartment past";
//        String text = "Partenship ASAP after apArtment PAst";
//        String text = "Пример текста с ошибками: Раз РАз РА арАбота каР А";

        String correctedText = replaceLetterAfterR(text);

        System.out.print("Исходный текст:\t\t");
        System.out.println(text);
        System.out.print("Исправленный текст:\t");
        System.out.println(correctedText);
    }

}


