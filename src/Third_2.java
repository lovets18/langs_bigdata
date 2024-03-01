import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;


class PatientList {
    public Patient[] createPatients(int n, Scanner scanner) {
        Patient[] listPat = new Patient[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Пациент " + i);
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

            System.out.print("\tНомер карты: ");
            int card = scanner.nextInt();
            scanner.nextLine();

            System.out.print("\tДиагноз: ");
            String diagnose = scanner.nextLine();

            System.out.println();

            listPat[i] = new Patient(surname, name, father_name, address, phone, card, diagnose);

        }
        return listPat;
    }
}

class Patient {
    private static final AtomicInteger count = new AtomicInteger(0);
    int id;
    String surname;
    String name;
    String father_name;
    String address;
    String phone;
    int card;
    String diagnose;

    public Patient(
            String surname, String name, String fatherName, String address, String phone, int card, String diagnose
    ) {
        this.id = count.incrementAndGet();
        this.surname = surname;
        this.name = name;
        this.father_name = fatherName;
        this.address = address;
        this.phone = phone;
        this.card = card;
        this.diagnose = diagnose;
    }

    public void print() {
        System.out.println("Пациент id: " + this.id );
        System.out.print("  |  Фамилия: " + this.surname );

        System.out.print("  |  Имя: " + this.name );

        System.out.print("  |  Отчество: " + this.father_name );

        System.out.print("  |  Адрес: " + this.address );

        System.out.print("  |  Телефон: " + this.phone );

        System.out.print("  |  Номер карты: " + this.card );

        System.out.println("  |  Диагноз: " + this.diagnose );

        System.out.println();
    }
}

public class Third_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите n: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Введите искомый диагноз: ");
        String diag = scanner.nextLine();

        System.out.println("Введите интервал медицинских карт: ");
        System.out.print("\tНачало: ");
        int start = scanner.nextInt();
        System.out.print("\tКонец: ");
        int stop = scanner.nextInt();
        scanner.nextLine();

        PatientList patientCreator = new PatientList();
        Patient[] patients = patientCreator.createPatients(n, scanner);

        for (int i = 0; i < n; i++){
            patients[i].print();
        }

        System.out.println("Пациенты с диагнозом \"" + diag + "\"");
        for (int i = 0; i < n; i++){
            if (Objects.equals(patients[i].diagnose, diag))
                patients[i].print();
        }

        System.out.println("Пациенты с номерами медкарт в диапазоне " + start + " - " + stop);
        for (int i = 0; i < n; i++){
            if (patients[i].card >= start & patients[i].card <= stop)
                patients[i].print();
        }

    }
}
