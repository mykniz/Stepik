import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Deque<Integer> deque = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);
        boolean positionIsOdd = false;
        while (scanner.hasNext()) {
            if(positionIsOdd) {
                 deque.addFirst(scanner.nextInt());
            } else {
                scanner.nextInt();
            }
            positionIsOdd = !positionIsOdd;
        }

        while (!deque.isEmpty()) {
            System.out.print(deque.pollFirst() + " ");
        }
    }
}
