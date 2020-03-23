import java.io.*;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws IOException {

        double sum = 0;
        String inputString;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while ((inputString = bufferedReader.readLine()) != null) {
            String[] arr = inputString.split(" ");
            for (String s : arr) {
                try {
                    sum += Double.parseDouble(s);
                } catch (NumberFormatException e) {
                    // nothing to do here
                }
            }
        }
        System.out.printf(Locale.US, "%.6f", sum);
    }
}
