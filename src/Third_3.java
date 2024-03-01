import java.util.Objects;
import java.util.Scanner;

class Number{
    int num;

    public Number(int num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return num == number.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }

    public Number add(Number other) {
        return new Number(this.num + other.num);
    }

    public Number sub(Number other) {
        return new Number(this.num - other.num);
    }

    public Number mul(Number other) {
        return new Number(this.num * other.num);
    }

    public Number div(Number other) {
        return new Number(this.num / other.num);
    }
}

class Fraction{
    Number nominator;
    Number denominator;

    public Fraction(Number nominator, Number denominator) {
        this.nominator = nominator;
        this.denominator = denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Fraction frac = (Fraction) obj;
        return (this.nominator.equals(frac.nominator) & this.denominator.equals(((Fraction) obj).denominator) );
    }

    @Override
    public String toString() {
        return "Fraction{ " + nominator + " / " + denominator + " }";
    }

    @Override
    public int hashCode() {
        return Objects.hash(nominator, denominator);
    }

    public void print(){
        System.out.println(this.toString());
    }

    public void makeSimple() {
        int count = Math.min(Math.abs(nominator.num), Math.abs(denominator.num));

        for (int i = count; i >= 1; i--){
            if (nominator.num % i == 0 && denominator.num % i == 0){
                count = i;
                break;
            }
        }
        Number nod = new Number(count);
        this.nominator = this.nominator.div(nod);
        this.denominator = this.denominator.div(nod);
    }

    public Fraction add(Fraction other) {
        Number nom_res_1 = this.nominator.mul(other.denominator);
        Number nom_res_2 = other.nominator.mul(this.denominator);
        Number nom_res = nom_res_1.add(nom_res_2);
        Number denom_res = this.denominator.mul(other.denominator);
        Fraction result = new Fraction(nom_res, denom_res);
        result.makeSimple();
        return result;
    }

    public Fraction sub(Fraction other) {
        Number nom_res_1 = this.nominator.mul(other.denominator);
        Number nom_res_2 = other.nominator.mul(this.denominator);
        Number nom_res = nom_res_1.sub(nom_res_2);
        Number denom_res = this.denominator.mul(other.denominator);
        Fraction result = new Fraction(nom_res, denom_res);
        result.makeSimple();
        return result;
    }

    public Fraction mul(Fraction other) {
        Number nom_res = this.nominator.mul(other.nominator);
        Number denom_res = this.denominator.mul(other.denominator);
        Fraction result = new Fraction(nom_res, denom_res);
        result.makeSimple();
        return result;
    }

    public Fraction div(Fraction other) {
        Number nom_res = this.nominator.mul(other.denominator);
        Number denom_res = this.denominator.mul(other.nominator);
        Fraction result = new Fraction(nom_res, denom_res);
        result.makeSimple();
        return result;
    }
}



public class Third_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Первая дробь: ");
        System.out.print("\tЧислитель: ");
        Number nominator1 = new Number(scanner.nextInt());
        System.out.print("\tЗнаменатель: ");
        Number denominator1 = new Number(scanner.nextInt());
        Fraction fraction1 = new Fraction(nominator1, denominator1);

        System.out.println("Вторая дробь: ");
        System.out.print("\tЧислитель: ");
        Number nominator2 = new Number(scanner.nextInt());
        System.out.print("\tЗнаменатель: ");
        Number denominator2 = new Number(scanner.nextInt());
        Fraction fraction2 = new Fraction(nominator2, denominator2);

        System.out.println("Результат опреации +:");
        fraction1.add(fraction2).print();

        System.out.println("Результат опреации -:");
        fraction1.sub(fraction2).print();

        System.out.println("Результат опреации *:");
        fraction1.mul(fraction2).print();

        System.out.println("Результат опреации /:");
        fraction1.div(fraction2).print();


//            result.print();
//        System.out.println("Введите операцию (+, -, *, /): ");
//        char op = scanner.next(".").charAt(0);

//        Fraction result = null;
//        boolean correct = true;
//        switch (op){
//            case '+':
//                result = fraction1.add(fraction2);
//                break;
//            case '-':
//                result = fraction1.sub(fraction2);
//                break;
//            case '*':
//                result = fraction1.mul(fraction2);
//                break;
//            case '/':
//                result = fraction1.div(fraction2);
//                break;
//            default:
//                correct = false;
//        }
//        if (result != null) {
//            System.out.println("Результат опреации " + op + ":");
//            result.print();
//        }
//        else
//            System.out.println("Некорректная операция");




    }
}
