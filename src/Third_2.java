import java.util.Arrays;
import java.util.Scanner;

public class Third_2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите n: ");
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = (int) (Math.random() * 2 * n - n);
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

        int max_seq = 1;
        int cur_seq = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (j == 0 & i > 0) {
                    if (arr[i][j] > arr[i - 1][n - 1]) {
                        cur_seq++;
                    }
                    else {
                        if (cur_seq > max_seq) {
                            max_seq = cur_seq;

                            System.out.println(i + " " + j);
                        }
                        cur_seq = 1;
                    }
                } else if (j > 0) {
                    if (arr[i][j] > arr[i][j - 1])
                        cur_seq++;
                    else {
                        if (cur_seq > max_seq) {
                            max_seq = cur_seq;
                            System.out.println(i + " " + j);
                        }
                        cur_seq = 1;
                    }
                }
            }
        }

        System.out.println("max " + max_seq);
    }
}
