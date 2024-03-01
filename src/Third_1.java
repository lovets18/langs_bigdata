import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Mobile{
    String manufactor;

    public Mobile(String manufactor) {
        this.manufactor = manufactor;
    }


    class Info {
        String model;
        int year;
        int cpu;
        double weigth;
        int memory;
        double display;

        public Info(String model, int year, int cpu, double weight, int memory, double display) {
            this.model = model;
            this.year = year;
            this.cpu = cpu;
            this.weigth = weight;
            this.memory = memory;
            this.display = display;
        }

        @Override
        public String toString() {
            return manufactor + " " + model +
                    ", year=" + year +
                    ", cpu=" + cpu +
                    ", weight=" + weigth +
                    ", memory=" + memory +
                    ", display=" + display;
        }
    }



}

public class Third_1 {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите информацию о телефоне");


        System.out.print("Введите название производителя: ");
        String manufactor = scanner.nextLine();

        Mobile iphone = new Mobile(manufactor);

        System.out.print("Введите название модели: ");
        String model = scanner.nextLine();

        System.out.print("Введите год выпуска: ");
        int year = scanner.nextInt();

        System.out.print("Введите число ядер: ");
        int cpu = scanner.nextInt();

        System.out.print("Введите вес: ");
        double weight = scanner.nextDouble();

        System.out.print("Введите память (ГБ): ");
        int memory = scanner.nextInt();

        System.out.print("Введите диагональ дисплея (дюймы): ");
        double display = scanner.nextDouble();

        Mobile.Info info = iphone.new Info(model, year, cpu, weight, memory, display);

        System.out.println(info);



    }
}