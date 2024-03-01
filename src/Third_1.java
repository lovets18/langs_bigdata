import java.util.HashSet;
import java.util.Set;

public class Third_1 {
    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>();
        // Добавьте произвольные числа в множество
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        while (numbers.size() > 1) {
            Set<Integer> newNumbers = new HashSet<>();
            Integer prev = null;
            for (Integer num : numbers) {
                if (prev == null) {
                    prev = num;
                } else {
                    newNumbers.add(prev + num);
                    prev = null;
                }
            }
            if (prev != null) {
                newNumbers.add(prev);
            }
            numbers = newNumbers;
        }

        System.out.println("Результат попарного суммирования: " + numbers.iterator().next());
    }
}
