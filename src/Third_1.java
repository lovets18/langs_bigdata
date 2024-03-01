import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Third_1 {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число строк n: ");
        int length = scanner.nextInt();
        scanner.nextLine();
        String[] array = new String[length];
        System.out.println("Введите строки (через Enter):");
        int total_len = 0;
        for (int i = 0; i < length; i++) {
            System.out.print(i + 1 + ") " );
            array[i] = scanner.nextLine();
            total_len = total_len + array[i].length();
        }

        float mean_len = (float) total_len / length;

        System.out.println("Средняя длина строки:" + mean_len);
        System.out.println("Строки длиннее средней:");
        for (String elem : array) {
            if (elem.length() > mean_len) {
                System.out.println("\t\"" + elem + "\" (" + elem.length() + " chars)" );
            }
        }
        System.out.println("\nСтроки короче средней:");
        for (String elem : array) {
            if (elem.length() < mean_len) {
                System.out.println("\t\"" + elem + "\" (" + elem.length() + " chars)" );
            }
        }
    }
}




//Введите число строк n: 5
//Введите строки (через Enter):
//        1) a a a
//2) aaaaaaaaa
//3) aa
//4) dfjhgkjfnglnjkfgn
//5)