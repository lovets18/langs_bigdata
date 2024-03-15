import java.util.Arrays;
import java.util.List;

public class Thirteen_1 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("One", "Two", "Three", "Four", "Five");

        List<String> result = strings.stream()
                .skip(1)
                .limit(2)
                .toList();

        System.out.println(result);
    }
}