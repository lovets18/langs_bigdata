import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class fourth_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь до файла: ");
        String filename = scanner.nextLine();
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
//
            String line;

            while ((line = reader.readLine()) != null) {
                text.append(line).append("\n");
            }

        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }

        String content = text.toString();
        System.out.println("Текст файла:\n\n" + content);

//        String text = scanner.nextLine();
        String[] words = content.split("\\s+");

        System.out.println("Слова, для которых последняя буква одного слова совпадает с первой буквой следующего:");

        for (int i = 0; i < words.length - 1; i++) {
            String currentWord = words[i];
            String nextWord = words[i + 1];

            if (!currentWord.isEmpty() && !nextWord.isEmpty()) {
                char lastChar = Character.toLowerCase(currentWord.charAt(currentWord.length() - 1));
                char firstChar = Character.toLowerCase(nextWord.charAt(0));

                if (lastChar == firstChar) {
                    System.out.println(currentWord + " " + nextWord);
                }
            }
        }

        scanner.close();
    }
}

