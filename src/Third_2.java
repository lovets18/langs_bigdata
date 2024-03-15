import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;


class MedCardException extends Exception {
    public MedCardException(String mess) {
        super(mess);
    }
}

class PatientList {
    public Patient[] createPatients(int n, Scanner scanner) throws MedCardException {
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
            if (card < 0){
                throw new MedCardException("номер карты должен быть больше нуля");
            }

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
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите n: ");
            int n = scanner.nextInt();
            scanner.nextLine();
            if (n < 1){
                throw new MedCardException("n должно быть больше нуля");
            }

            System.out.print("Введите искомый диагноз: ");
            String diag = scanner.nextLine();

            System.out.println("Введите интервал медицинских карт: ");
            System.out.print("\tНачало: ");
            int start = scanner.nextInt();
            if (start < 0){
                throw new MedCardException("начало интервала номеров должно быть больше нуля");
            }
            System.out.print("\tКонец: ");
            int stop = scanner.nextInt();
            scanner.nextLine();
            if (start >= stop){
                throw new MedCardException("конец интервала должен быть больше его начала");
            }

            PatientList patientCreator = new PatientList();
            Patient[] patients = patientCreator.createPatients(n, scanner);

            for (int i = 0; i < n; i++) {
                patients[i].print();
            }

            System.out.println("Пациенты с диагнозом \"" + diag + "\"");
            for (int i = 0; i < n; i++) {
                if (Objects.equals(patients[i].diagnose, diag))
                    patients[i].print();
            }

            System.out.println("Пациенты с номерами медкарт в диапазоне " + start + " - " + stop);
            for (int i = 0; i < n; i++) {
                if (patients[i].card >= start & patients[i].card <= stop)
                    patients[i].print();
            }
        } catch (MedCardException e) {
            System.out.println(e);
        } catch (InputMismatchException e) {
            System.out.println("Неверный тип данных");
        } catch (OutOfMemoryError e) {
            System.out.println("Переполнение ОП");
        }

    }
}
