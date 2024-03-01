import java.util.Scanner;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class FileLineReader {
    public static void readLinesFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

//    public static void main(String[] args) {
//        String filePath = "путь_к_файлу.txt"; // Укажите путь к файлу, который нужно прочитать
//
//        readLinesFromFile(filePath);
//    }
}


public class third_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите путь до файла: ");
        String filename = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                System.out.println("Строка: " + line);
                System.out.print("\tСлова, начинающиеся с гласной буквы: ");
                boolean found = false;
                for (String word : words) {
                    if (word.matches("[AEIOUYaeiouy]\\w*")) {
                        System.out.print(word + ", ");
                        found = true;
                    }
                }
                if (!found)
                    System.out.println("Не найдены");
                else
                    System.out.println();
//                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }


        scanner.close();
    }
}
