import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {


        String string1 = "a\\b\\c\\file.txt";
        String string2 = "a\\b\\..\\file.txt";
        String string3 = "a\\..\\b\\c\\file.txt";
        String string4 = ".\\a\\b\\..\\b\\c\\.\\file.txt";
        String string5 = "a\\.\\b\\..\\c\\.\\file.txt";

        File[] fileArr = new File[] {
                new File(string1),
                new File(string2),
                new File(string3),
                new File(string4),
                new File(string5),
        };

        for (File f : fileArr) {
            System.out.println(f.getCanonicalPath());
        }
    }
}
