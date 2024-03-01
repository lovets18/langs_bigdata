import java.math.BigInteger;
import java.util.*;

class Polynomial {
    HashMap<Integer, Integer> coefficients;

    public Polynomial(HashMap<Integer, Integer> coefficients) {
        this.coefficients = coefficients;
    }

    public Polynomial add(Polynomial other) {
        int maxDegree = Math.max(getMaxDegree(this), getMaxDegree(other));
        HashMap<Integer, Integer> result = new HashMap<>();
//        Polynomial result = new Polynomial();
        for (int degree = 0; degree <= maxDegree; ++degree) {
            Integer sum = coefficients.get(degree) + other.coefficients.get(degree);
            result.put(degree, sum);
        }
        return new Polynomial(result);
    }

    private static int getMaxDegree(Polynomial polynomial) {
        int maxDegree = 0;
        for (HashMap.Entry<Integer, Integer> entry : polynomial.coefficients.entrySet()) {
            maxDegree = Math.max(maxDegree, entry.getKey());
        }
        return maxDegree;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        boolean firstTermAdded = false;

        for (HashMap.Entry<Integer, Integer> term : coefficients.entrySet()) {
            if (term.getValue() != 0 || firstTermAdded) {
                if (firstTermAdded) {
                    sb.append("+ (");
                }
                firstTermAdded = true;

                if (term.getValue() != 0) {
                    sb.append(term.getValue()).append("x^").append(term.getKey()).append(") ");
                } else {
                    sb.append((Object) 0).append("x) ");
                }
            }
        }

        return sb.toString();
    }

}

public class Fourth_1 {
    public static void main(String[] args) {
        HashMap<Integer, Integer> a = new HashMap<>();
        a.put(0, 0);
        a.put(1, -10);
        a.put(2, 10);
        a.put(3, 15);
        Polynomial first = new Polynomial(a);

        HashMap<Integer, Integer> b = new HashMap<>();
        b.put(0, 1);
        b.put(1, 2);
        b.put(2, -3);
        b.put(3, 4);
        Polynomial second = new Polynomial(b);

        Polynomial sum = first.add(second);

        System.out.println(first);
        System.out.println(second);
        System.out.println(sum);
    }
}
