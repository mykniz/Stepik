import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws IOException {

        byte[] arr = {48, 49, 50, 51};
        Charset charset = StandardCharsets.US_ASCII;
        InputStream inputStream = new ByteArrayInputStream(arr);
        System.out.println(readAsString(inputStream,charset));
    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        Reader reader = new InputStreamReader(inputStream,charset);
        int x;
        while ((x = reader.read()) != -1) {
            stringBuilder.append((char) x);
        }
        return stringBuilder.toString();
    }
}


