import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

class ObjectToOpen {
    boolean isClosed;
    int width;
    int height;

    ObjectToOpen(int width, int height){
        this.width = width;
        this.height = height;
        this.isClosed = true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, height);
    }

    public void close() {
        this.isClosed = true;
    }

    public void open() {
        this.isClosed = false;
    }
}

class Window extends ObjectToOpen{


    Window(int width, int height) {
        super(width, height);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Window window = (Window) o;
        return width == window.width && height == window.height;
    }


    @Override
    public String toString() {
        return "Window{" +
                "isClosed=" + isClosed +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}

class Door extends ObjectToOpen {

    Door(int width, int height) {
        super(width, height);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Door door = (Door) o;
        return width == door.width && height == door.height;
    }

    @Override
    public String toString() {
        return "Door{" +
                "isClosed=" + isClosed +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}

class House {
    Door[] doors;
    Window[] windows;
    double square;

    public House(Window[] windows, Door[] doors, double square) {
        this.windows = windows;
        this.doors = doors;
        this.square = square;
    }

    @Override
    public String toString() {
        return "House{" +
                "doors=" + Arrays.toString(doors) +
                ", windows=" + Arrays.toString(windows) +
                ", square=" + square +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return Double.compare(square, house.square) == 0 && Arrays.equals(doors, house.doors) && Arrays.equals(windows, house.windows);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(square);
        result = 31 * result + Arrays.hashCode(doors);
        result = 31 * result + Arrays.hashCode(windows);
        return result;
    }

    public void close(){
        for (Door door : doors) door.close();
        for (Window window : windows) window.close();
    }

    public void open(){
        for (Door door : doors) door.open();
        for (Window window : windows) window.open();
    }

    public int doorsCount(){
        return doors.length;
    }

    public void printDoors(){
        System.out.println("Число дверей: " + this.doorsCount());
    }

    public int windowsCount(){
        return windows.length;
    }

    public void printWindows(){
        System.out.println("Число окон: " + this.windowsCount());
    }
}

public class Fourth_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите площадь дома (м^2): ");
        double square = scanner.nextDouble();

        System.out.print("Введите число окон: ");
        int n_win = scanner.nextInt();

        Window[] windows = new Window[n_win];
        for (int i = 0; i < n_win; i++){
            System.out.print("\tВведите ширину и высоту (через пробел) окна " + (i+1) + ": ");
            int width = scanner.nextInt();
            int height = scanner.nextInt();
            windows[i] = new Window(width, height);
        }

        System.out.print("Введите число дверей: ");
        int n_door = scanner.nextInt();
        Door[] doors = new Door[n_door];
        for (int i = 0; i < n_door; i++){
            System.out.print("\tВведите ширину и высоту (через пробел) двери " + (i+1) + ": ");
            int width = scanner.nextInt();
            int height = scanner.nextInt();
            doors[i] = new Door(width, height);
        }

        House house = new House(windows, doors, square);
        house.open();
        System.out.println(house);
        house.close();
        System.out.println(house);
        house.printWindows();
        house.printDoors();
    }
}
