import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Fourteen_1 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Apple", "Banana", "Orange", "Grapes");

        List<String> sortedList = strings.stream()
                .sorted((s1, s2) -> s2.compareTo(s1))
                .collect(Collectors.toList());

        System.out.println(sortedList);
    }
}
