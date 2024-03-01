//https://grafika.me/node/237

//https://edu.tltsu.ru/er/book_view.php?book_id=1e2&page_id=523#:~:text=Смешанным%20произведением%20векторов%20называется%20число,объему%20параллелепипеда%2C%20построенного%20на%20векторах%20.

import java.util.Scanner;

//https://skysmart.ru/articles/mathematic/vektornoe-proizvedenie-vektorov

//https://zaochnik.com/spravochnik/matematika/vektory/komplanarnye-vektory-i-uslovie-komplanarnosti/
class Point {
    double x, y, z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void printPoint() {
        System.out.print("(" + this.x + ", " + this.y + ", " + this.z + "), ");
    }
}

class PointReader {
    public Point readPoint(Scanner scanner){
//        System.out.println("");
        System.out.print("\tx=");
        double x = scanner.nextDouble();
        System.out.print("\ty=");
        double y = scanner.nextDouble();
        System.out.print("\tz=");
        double z = scanner.nextDouble();

        return new Point(x, y, z);
    }
}

class Vector {
   Point a, b;

    public Vector(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    double getLen() {
       return Math.sqrt(this.getLenX() * this.getLenX() +
               this.getLenY() * this.getLenY() +
               this.getLenZ() * this.getLenZ());
   }

   public double getLenX() {
       return this.b.x - this.a.x;
   }

    public double getLenY() {
        return this.b.y - this.a.y;
    }

    public double getLenZ() {
        return this.b.z - this.a.z;
    }
    public double getScalar(Vector other) {
        return (this.getLenX() * other.getLenX() +
                this.getLenY() * other.getLenY() +
                this.getLenZ() * other.getLenZ());
    }

    public double getSin(Vector other) {
       return this.getScalar(other) / (this.getLen() * other.getLen());
    }

    public double getVectMul(Vector other) {
       return (this.getLen() * other.getLen()) / this.getSin(other);
    }

    public Vector getVectorVector(Vector other) {
        double tmpXb = this.getLenY() * other.getLenZ();
        double tmpXa = this.getLenZ() * other.getLenY();

        double tmpYb = this.getLenZ() * other.getLenX();
        double tmpYa = this.getLenX() * other.getLenZ();

        double tmpZb = this.getLenX() * other.getLenY();
        double tmpZa = this.getLenY() * other.getLenX();

        Point tmpB = new Point(tmpXb, tmpYb, tmpZb);
        Point tmpA = new Point(tmpXa, tmpYa, tmpZa);

        return new Vector(tmpA, tmpB);
    }

    public double getMixMul(Vector other1, Vector other2) {
        Vector tmpBC = other1.getVectorVector(other2);
        return this.getScalar(tmpBC);
    }

    public boolean isComplanar(Vector other1, Vector other2) {
        return (this.getMixMul(other1, other2) == 0);
    }

    public boolean isCross(Vector other) {
       double v1 = other.getVectMul(new Vector(other.a, this.a));
       double v2 = other.getVectMul(new Vector(other.a, this.b));

       double v3 = this.getVectMul(new Vector(this.a, other.a));
       double v4 = this.getVectMul(new Vector(this.a, other.b));

       return (v1 * v2 < 0 & v3 * v4 < 0);
    }

    public boolean isOrt(Vector other) {
        return (this.getScalar(other) == 0);
    }

    public void printVector() {
        this.a.printPoint();
        this.b.printPoint();
        System.out.println();
    }
}


public class Third_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите n: ");
        int n = scanner.nextInt();

        scanner.nextLine();
        Vector[] array = new Vector[n];
        PointReader reader = new PointReader();
        for (int i = 0; i < n; i++){
            System.out.println(i + 1 + ")");

            System.out.println( "Точка A:");
            Point tmpA = reader.readPoint(scanner);
            System.out.println( "Точка B:");
            Point tmpB = reader.readPoint(scanner);
            array[i] = new Vector(tmpA, tmpB);
        }
//        System.out.print("Введите n: ");
        for (int i = 0; i < n - 2; i++){
            for (int j = i + 1; j < n - 1; j++){
                for (int k = j + 1; k < n; k++) {
                    if (array[i].isComplanar(array[j], array[k])) {
                        System.out.println("Комлпанарные:");
                        array[i].printVector();
                        array[j].printVector();
                        array[k].printVector();
                    }
                }
            }
        }
    }
}

