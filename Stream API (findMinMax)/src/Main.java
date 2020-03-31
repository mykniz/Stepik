import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Stream<Integer> stream = Stream.of(8, 2, 100, 3, 5, 6, 1, 7);
        Comparator<Integer> comparator = Comparator.comparing(s -> s);
        BiConsumer<Integer, Integer> minMaxConsumer = (x, y) -> System.out.println(x + ", " + y);

//        Stream<String> stream = Stream.of("bc", "a", "def", "ghij");
//        Comparator<String> comparator = Comparator.comparing(String::length);
//        BiConsumer<String, String> minMaxConsumer = (x, y) -> System.out.println(x + ", " + y);

//        Stream<String> stream = Stream.of();
//        Comparator<String> comparator = Comparator.comparing(String::length);
//        BiConsumer<String, String> minMaxConsumer = (x, y) -> System.out.println(x + ", " + y);

        findMinMax(stream, comparator, minMaxConsumer);

    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        ArrayList<T> arrayList = stream.sorted(order)
                .collect(Collectors.toCollection(ArrayList::new));

        if (arrayList.size() == 0) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(arrayList.get(0), arrayList.get(arrayList.size() - 1));
        }
    }
}
