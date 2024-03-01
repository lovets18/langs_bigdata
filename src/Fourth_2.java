import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;


class AbiturientList {
    public Abiturient[] createAbiturients(int n, Scanner scanner) {
        Abiturient[] listAb = new Abiturient[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Абитуриент " + i);
            System.out.print("\tФамилия: ");
            String surname = scanner.nextLine();

            System.out.print("\tИмя: ");
            String name = scanner.nextLine();

            System.out.print("\tОтчество: ");
            String father_name = scanner.nextLine();

            System.out.print("\tАдрес: ");
            String address = scanner.nextLine();

            System.out.print("\tТелефон: ");
            String phone = scanner.nextLine();

            System.out.print("\tОценка по математике: ");
            int math = scanner.nextInt();
            System.out.print("\tОценка по русскому: ");
            int russian = scanner.nextInt();
            System.out.print("\tОценка по информатике: ");
            int informatics = scanner.nextInt();
            scanner.nextLine();

            Marks mark = new Marks(math, russian, informatics);

            System.out.println();

            listAb[i] = new Abiturient(surname, name, father_name, address, phone, mark);

        }
        return listAb;
    }
}

class Marks {
    int math;
    int russian;
    int informatics;

    public Marks(int math, int russian, int informatics) {
        this.math = math;
        this.russian = russian;
        this.informatics = informatics;
    }

    public double getMean(){
        return (double) (math + russian + informatics) / 3;
    }

    public String toString() {
        return "(мат: " + this.math + "; рус: " + this.russian + "; инф: " + this.informatics + ")";
    }

    public boolean hasBad() {
        return (this.math < 3 | this.russian < 3 | this.informatics < 3);
    }
}

class Abiturient {
    private static final AtomicInteger count = new AtomicInteger(0);
    int id;
    String surname;
    String name;
    String father_name;
    String address;
    String phone;
    Marks marks;

    public Abiturient(
            String surname, String name, String fatherName, String address, String phone, Marks marks
    ) {
        this.id = count.incrementAndGet();
        this.surname = surname;
        this.name = name;
        this.father_name = fatherName;
        this.address = address;
        this.phone = phone;
        this.marks = marks;
    }

    public void print() {
        System.out.println("Абитуриент id: " + this.id );
        System.out.print("  |  Фамилия: " + this.surname );

        System.out.print("  |  Имя: " + this.name );

        System.out.print("  |  Отчество: " + this.father_name );

        System.out.print("  |  Адрес: " + this.address );

        System.out.print("  |  Телефон: " + this.phone );

        System.out.print("  |  Оценки: " + this.marks.toString());

        System.out.println();
    }
}

public class Fourth_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число абитуриентов: ");
        int m = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Искомый средний балл: ");
        double mean_mark = scanner.nextDouble();
        System.out.print("Введите топ-абитуериентов (n): ");
        int n = scanner.nextInt();
        scanner.nextLine();

        AbiturientList abiturientCreator = new AbiturientList();
        Abiturient[] abiturients = abiturientCreator.createAbiturients(m, scanner);

        for (int i = 0; i < m; i++){
            abiturients[i].print();
        }

        System.out.println("Абитуриенты с плохими оценками:");
        for (int i = 0; i < m; i++){
            if (abiturients[i].marks.hasBad())
                abiturients[i].print();
        }

        System.out.println("Абитуриенты со средним быллом выше " + mean_mark);
        for (int i = 0; i < m; i++){
            if (abiturients[i].marks.getMean() > mean_mark)
                abiturients[i].print();
        }

        double[] mean_marks = new double[m];
        for (int i = 0; i < m; i++){
            for (int j = i; j < m; j++) {
                if (abiturients[i].marks.getMean() < abiturients[j].marks.getMean()){
                    Abiturient tmp = abiturients[i];
                    abiturients[i] = abiturients[j];
                    abiturients[j] = tmp;
                }
            }
        }

        System.out.println("Список абитурентов топ-" + n);
        for (int i = 0; i < n; i++){
                abiturients[i].print();
        }

        System.out.println("Абитуриенты с полупроходным баллом:");
        double half_entrance_mark = abiturients[n-1].marks.getMean();
        for (int i = 0; i < m; i++){
            if (abiturients[i].marks.getMean() == half_entrance_mark)
                abiturients[i].print();
        }
    }
}
