import java.util.Scanner;

class UniqChars {
    public static int count(String word) {
        int num_char = 0;
        StringBuilder charset = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (charset.toString().indexOf(word.charAt(i)) == -1) {
                charset.append(word.charAt(i));
                num_char++;
            }
        }

        return num_char;
    }
}

public class Fourth_1 {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число слов n: ");
        int length = scanner.nextInt();
        scanner.nextLine();
        String[] array = new String[length];
        System.out.println("Введите слова (через пробел):");
        int min_chars = 999999999;
        String min_word = "";
        for (int i = 0; i < length; i++) {
            array[i] = scanner.next();
            int cur_chars_num = UniqChars.count(array[i]);
            if (cur_chars_num < min_chars) {
                min_chars = cur_chars_num;
                min_word = array[i];
            }
        }
        System.out.println("Слово \"" + min_word + "\" имеет наименьшее число различных символов: " + min_chars);
    }
}


//Введите число слов n: 6
//Введите слова (через пробел):
//abcde aaaaaa a abewjakbfjdbrelwqfh aabbcc djkbv
//Слово "aaaaaa" имеет наименьшее число различных символов: 1
