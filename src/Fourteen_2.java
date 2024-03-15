import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Fourteen_2 {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("String1", "String2", "String3");

        List<String> modifiedStrings = strings.stream()
                .map(s -> "_task14" + s)
                .collect(Collectors.toList());

        System.out.println(modifiedStrings);
    }
}
