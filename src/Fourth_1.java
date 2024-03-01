import java.util.Scanner;

class Exhibition {
    boolean isOpen = false;

    public void close(){
        this.isOpen = false;
    }

    public void open(){
        this.isOpen = true;
    }

    class Art {
        String name;
        String author;
        int year;

        public Art(String name, String author, int year) {
            this.name = name;
            this.author = author;
            this.year = year;
        }

        @Override
        public String toString() {
            return name + ", written by " + author +" in " + year + ", available = " + isOpen;
        }
    }
}

public class Fourth_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Exhibition expo = new Exhibition();

        System.out.println("Введите информацию картине 1:");
        System.out.print("\tname: ");
        String name = scanner.nextLine();
        System.out.print("\tauthor: ");
        String author = scanner.nextLine();
        System.out.print("\tyear: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        Exhibition.Art art1 = expo.new Art(name, author, year);


        System.out.println("Введите информацию картине 2:");
        System.out.print("\tname: ");
        name = scanner.nextLine();
        System.out.print("\tauthor: ");
        author = scanner.nextLine();
        System.out.print("\tyear: ");
        year = scanner.nextInt();
        scanner.nextLine();

        Exhibition.Art art2 = expo.new Art(name, author, year);

        System.out.println("До открытия:");
        System.out.println(art1);
        System.out.println(art2);

        expo.open();

        System.out.println("\nОткрытие!");
        System.out.println(art1);
        System.out.println(art2);

    }
}
