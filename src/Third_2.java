import java.util.*;

//package com.journaldev.readfileslinebyline;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


class Node {
    int row;
    int col;
    int value;

    public Node(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }

    @Override
    public String toString() {
        return "{" + value +
                "[" + row +
                ", " + col +
                "]}";
    }
}

class SparseMatrix{
    LinkedList<Node> list;
    int lenrows;
    int lencols;

    public SparseMatrix(int[][] matrix){

        assert matrix.length > 0;
        this.lencols = matrix.length;
        this.lenrows = matrix[0].length;
        list = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] != 0){
                    Node tmp = new Node(i, j, matrix[i][j]);
                    list.add(tmp);
                }
            }
    }

    public SparseMatrix(LinkedList<Node> list) {
        this.list = list;
    }

    public SparseMatrix add(SparseMatrix other){
        LinkedList<Node> result = new LinkedList<>();

        ListIterator<Node> it1 = list.listIterator();
        ListIterator<Node> it2 = other.list.listIterator();

        while (it1.hasNext() || it2.hasNext()) {
            if (!it1.hasNext()) {
                Node cur = it2.next();
//                Node tmp = new Node(it2.g().row, it2.next().col, it2.previous().value);
                result.add(cur);
            } else if (!it2.hasNext()) {
                Node cur = it1.next();
//                Node tmp = new Node(it1.next().row, it1.next().col, it1.previous().value);
                result.add(cur);
            } else {
                Node node1 = it1.next();
                Node node2 = it2.next();
                if (node1.col == node2.col && node1.row == node2.row) {
                    Node sum = new Node(node1.row, node1.col, node1.value + node2.value);
                    result.add(sum);
                } else if (node1.row < node2.row | (node1.row == node2.row & node1.col < node2.col)) {
                    result.add(node1);
                    it2.previous();
                } else {
                    result.add(node2);
                    it1.previous();
                }
            }
        }
        return new SparseMatrix(result);
    }

    public SparseMatrix mul(SparseMatrix other){

        assert (lenrows == other.lencols);
        LinkedList<Node> result = new LinkedList<>();

        for (int i = 0; i < lenrows; i++) {
            for (int j = 0; j < other.lencols; j++) {
//                System.out.println("(" + i + "; " + j + ")");
                int val = 0;
                for (Node cur : list) {
//                    System.out.println("\tit1: " + cur);
                    if (cur.row == i) {
                        for (Node cur_2 : other.list) {
//                            System.out.println("\tit2: " + cur_2);
                            if (cur_2.col == j && cur_2.row == cur.col) {
                                val += cur.value * cur_2.value;
//                                System.out.println(" [" + i + " " + j + "] = " + cur.value * cur_2.value);
                                break;
                            }
                        }
                    }
                }
                if (val > 0) {
                    result.add(new Node(i, j, val));
                }
            }
        }



//        ListIterator<Node> it2 = other.list.listIterator();
//        result.add(node2);
        return new SparseMatrix(result);
    }

    public void print(){
        ListIterator<Node> it1 = list.listIterator();
        while (it1.hasNext()) {
            Node cur = it1.next();
            System.out.print(cur + " ");
        }
    }
}


class ReaderFile{
    public int[][] readFile(String filename){

        try {
            Scanner scanner = new Scanner(new File(filename));
            String sizes = "";
            if (scanner.hasNextLine()) {
                sizes = scanner.nextLine();
            }
            int nrows = Integer.parseInt(sizes.split(" ")[0]);
            int ncols = Integer.parseInt(sizes.split(" ")[1]);
            int[][] arr = new int[nrows][ncols];
            int i = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                for (int j = 0; j < ncols; j++) {
                    arr[i][j] = Integer.parseInt(line.split(" ")[j]);
                }
                i++;
            }

            System.out.println(Arrays.deepToString(arr));
            return arr;
//            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

public class Third_2 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Введите длину массива n: ");
//        int length = scanner.nextInt();
//
//        int[][] a = {{1, 0, 0}, {0, 0, 0}, {0, 1, 0}};
//        int[][] b = {{0, 1, 0}, {0, 0, 0}, {1, 0, 0}};
        ReaderFile reader = new ReaderFile();
        SparseMatrix a = new SparseMatrix(reader.readFile("matrix.txt"));
        SparseMatrix b = new SparseMatrix(reader.readFile("matrix_2.txt"));
        System.out.println("list a: " + a.list);
        System.out.println("list b: " + b.list);

        SparseMatrix sum = a.add(b);
        System.out.println("sum: " + sum.list);

        SparseMatrix mul = a.mul(b);
        System.out.println("mul: " + mul.list);
    }
}