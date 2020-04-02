import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String str = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.";

        PrintWriter printStream = new PrintWriter("текст.txt");
        printStream.write(str);
        printStream.close();
        InputStream inputStream = new FileInputStream("текст.txt");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

        bufferedReader.lines()
                .map(s -> s.replaceAll("[^a-zA-Zа-яА-Я0-9\\s]", " "))
                .map(l -> l.split(" "))
                .flatMap(Arrays::stream)
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(11)
                .forEach(e -> System.out.println(e.getKey()));
    }
}