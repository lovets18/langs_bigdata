import java.util.Scanner;

public class Fourth_2 {
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

        int summ = 0;
        for (int i = 0; i < n; i++) {
            int count_pos = 0;
            int cur_summ = 0;
            boolean count = false;
            for (int j = 0; j < n; j++) {
                if (arr[i][j] > 0) {
                    count_pos += 1;
                    if (count_pos <= 2)
                        count = !count;
                    if (count_pos == 2)
                        summ += cur_summ;
//                    System.out.println(cur_summ);
                }
                else if (count) {
                    cur_summ += arr[i][j];
//                    System.out.println(arr[i][j]);
                }
            }
        }

        System.out.println("summ: " + summ);
    }
}
