import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {

        int currentByte;
        if ((currentByte = System.in.read()) != -1) {
            int nextByte;
            while ((nextByte = System.in.read()) != -1) {
                if (!(currentByte == 13 & nextByte == 10)) {
                    System.out.write(currentByte);
                }
                currentByte = nextByte;
            }
        }
    }
}
