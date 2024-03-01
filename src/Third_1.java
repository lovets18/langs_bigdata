import java.util.Arrays;
import java.util.Scanner;

class Matrix {
    int[][] mat;
    int n;


    public Matrix(int n) {
        this.n = n;
        mat = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n ; j++) {
                mat[i][j] = (int) (Math.random() * 10);
            }
    }

    public Matrix(int n, int val) {
        this.n = n;
        mat = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n ; j++) {
                mat[i][j] = val;
            }
    }

    public Matrix(int[][] arr) {
        this.n = arr.length;
        mat = new int[this.n][this.n];
        for (int i = 0; i < n; i++)
            System.arraycopy(arr[i], 0, mat[i], 0, n);
    }

    public Matrix add(Matrix other) {
        int[][] summa = new int[this.n][this.n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                summa[i][j] = this.mat[i][j] + other.mat[i][j];
            }
        return new Matrix(summa);
    }

    public Matrix sub(Matrix other) {
        int[][] sub = new int[this.n][this.n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                sub[i][j] = this.mat[i][j] - other.mat[i][j];
            }
        return new Matrix(sub);
    }

    public Matrix mul(Matrix other) {
        int[][] mul = new int[this.n][this.n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                int line_sum = 0;
                for (int k = 0; k < n; k++){
                    line_sum += this.mat[i][k] * other.mat[k][j];
                }
                mul[i][j] = line_sum;
            }
        return new Matrix(mul);
    }

    public int l1() {
        int max = -99999999;
        for (int i = 0; i < n; i++) {
            int cur_sum = 0;
            for (int j = 0; j < n; j++) {
                cur_sum += mat[i][j];
            }
            if (cur_sum > max)
                max = cur_sum;
        }
        return max;
    }

    public int l2() {
        int max = -99999999;
        for (int j = 0; j < n; j++) {
            int cur_sum = 0;
            for (int i = 0; i < n; i++) {
                cur_sum += mat[i][j];
            }
            if (cur_sum > max)
                max = cur_sum;
        }
        return max;
    }

    public void printMat() {
        for (int i = 0; i < this.n; i++)
            System.out.println(Arrays.toString(this.mat[i]));
        System.out.println();
    }
}

public class Third_1 {
    public static void main(String[] args) {
        int n = 0;
        Scanner scanner = new Scanner(System.in);
        boolean correct_n = false;
        System.out.print("Введите n: ");
        if(scanner.hasNextInt()) { // возвращает истину если с потока ввода можно считать целое число
            n = scanner.nextInt();
            scanner.nextLine();
            if (n > 0)
                correct_n = true;
            else
                System.out.println("n должно быть больше нуля");
        } else {
            System.out.println("Вы ввели не целое число");
        }

        boolean correct_m = false;
        int m = 0;
        System.out.print("Введите m (число матриц > 2): ");
        if(scanner.hasNextInt()) { // возвращает истину если с потока ввода можно считать целое число
            m = scanner.nextInt();
            if (m > 0)
                correct_m = true;
            else
                System.out.println("m должно быть больше нуля");
        } else {
            System.out.println("Вы ввели не целое число");
        }

        if (correct_n & correct_m) {
            scanner.nextLine();
            Matrix[] array = new Matrix[m];

            int l1_min = 999999999;
            int l2_min = 999999999;
            int l1_id = -1, l2_id = -1;

            for (int i = 0; i < m; i++) {
                array[i] = new Matrix(n);

                int l1 = array[i].l1();
                if (l1 < l1_min) {
                    l1_min = l1;
                    l1_id = i;
                }

                int l2 = array[i].l2();
                if (l2 < l2_min) {
                    l2_min = l2;
                    l2_id = i;
                }

                System.out.println("Matrix " + (i + 1));
                array[i].printMat();
            }

            System.out.println("Min l1: " + l1_min + ". It has matrix number " + (l1_id + 1));
            System.out.println("Min l1: " + l2_min + ". It has matrix number " + (l2_id + 1));

            Matrix add = array[0].add(array[1]);
            System.out.println("Matrix 1 add 2");
            add.printMat();
            Matrix sub = array[0].sub(array[2]);
            System.out.println("Matrix 1 substract 3:");
            sub.printMat();
            Matrix mul = array[1].mul(array[2]);
            System.out.println("Matrix 2 mul 3: ");
            mul.printMat();
        }
        scanner.close();
    }
}
