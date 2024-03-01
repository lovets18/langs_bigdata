import java.io.*;
import java.util.Scanner;

public class Third_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите путь к файлу Java-программы:");
        String inputFilePath = scanner.nextLine();

        File inputFile = new File(inputFilePath);

        if (!inputFile.exists() || !inputFile.isFile()) {
            System.err.println("Указанный файл не существует или не является файлом.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            StringBuilder processedContent = new StringBuilder();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (word.length() > 2) {
                        processedContent.append(word.toUpperCase()).append(" ");
                    } else {
                        processedContent.append(word).append(" ");
                    }
                }
                processedContent.append("\n");
            }

            String outputDirectoryPath = "output_directory";
            File outputDirectory = new File(outputDirectoryPath);
            outputDirectory.mkdir();

            String outputFilePath = outputDirectoryPath + "/processed_java_program.java";
            File outputFile = new File(outputFilePath);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                writer.write(processedContent.toString());
                System.out.println("Результаты обработки сохранены в файл: " + outputFilePath);
            } catch (IOException e) {
                System.err.println("Ошибка при записи в файл: " + e.getMessage());
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }

        scanner.close();
    }
}

