import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        pseudoRandomStream(11)
                .limit(10)
                .forEach(System.out::println);
    }

    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, s -> (s * s) / 10 % 1000);
    }
}
