import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Fourth_4 {
    public static String delMaxSub(String text, char startChar, char endChar) {
        Pattern pattern = Pattern.compile("\\" + startChar + "(.*?)" + "\\" + endChar);
        Matcher matcher = pattern.matcher(text);

        int maxLength = 0;
        String maxSubstring = "";

        while (matcher.find()) {
            String substring = matcher.group(1);
            if (substring.length() > maxLength) {
                maxLength = substring.length();
                maxSubstring = substring;
            }
        }

        return text.replace(startChar + maxSubstring + endChar, "");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введи стартовый символ: ");
        char startChar = scanner.next().charAt(0);
        System.out.print("Введи стартовый символ: ");
        char endChar = scanner.next().charAt(0);
//        char startChar = '('; // Заданный символ начала подстроки
//        char endChar = ')'; // Заданный символ конца подстроки
        scanner.nextLine();
        System.out.println("Введите исходный текст:");
        String text = scanner.nextLine();
//        String text = "We need to drop from this (short) text (the longest) substring";
//        System.out.println(text);

        String modifiedText = delMaxSub(text, startChar, endChar);

        System.out.println("Текст после исключения подстроки:");
        System.out.println(modifiedText);
    }
}
