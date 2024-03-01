import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fourth_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите путь к файлу с фамилиями студентов и их оценками:");
        String inputFilePath = scanner.nextLine();

        File inputFile = new File(inputFilePath);

        if (!inputFile.exists() || !inputFile.isFile()) {
            System.err.println("Указанный файл не существует или не является файлом.");
            return;
        }

        List<String> studentsAboveSeven = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");
                String name = parts[0];
                double averageGrade = Double.parseDouble(parts[1]);

                if (averageGrade > 7) {
                    studentsAboveSeven.add(name.toUpperCase());
                }
            }

            String outputDirectoryPath = "output_directory";
            File outputDirectory = new File(outputDirectoryPath);
            outputDirectory.mkdir();

            String outputFilePath = outputDirectoryPath + "/students_above_seven.txt";
            File outputFile = new File(outputFilePath);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                for (String student : studentsAboveSeven) {
                    writer.write(student + "\n");
                }
                System.out.println("Фамилии студентов с оценкой более 7 сохранены в файл: " + outputFilePath);
            } catch (IOException e) {
                System.err.println("Ошибка при записи в файл: " + e.getMessage());
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }

        scanner.close();
    }
}
