import java.util.Scanner;

class Palindrome {
    static boolean isPalindrome(String word) {
        int length = word.length();
        for (int i = 0; i < (length / 2); i++) {
            if (word.charAt(i) != word.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длину массива n: ");
        int length = scanner.nextInt();
        int[] array = new int[length];
        System.out.println("Введите элементы массива (через пробел):");
        for (int i = 0; i < length; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.print("Числа-палиндромы, значения которых в прямом и обратном порядке совпадают: ");
        for (int i = 0; i < length; i++) {
            if (Palindrome.isPalindrome(Integer.toString(array[i]))) {
                System.out.print(array[i] + ", ");
            }
        }
        System.out.println();
        System.out.print("Элементы, которые равны полусумме соседних элементов: ");
        for (int i = 1; i < length - 1; i++) {
            if (array[i] * 2 == array[i - 1] + array[i + 1]) {
                System.out.print(array[i] + ", ");
            }
        }

    }
}