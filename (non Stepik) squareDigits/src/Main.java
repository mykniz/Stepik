public class Main {
    public static void main(String[] args) {

        System.out.println(digitSquare(89));

    }

    public static int digitSquare(int n) {
        String inputNumber = String.valueOf(n);
        int[] outputDigits = new int[inputNumber.length()];

        for (int i = 0; i < outputDigits.length; i++) {
            outputDigits[i] = (inputNumber.charAt(i)-'0') * (inputNumber.charAt(i)-'0');
        }

        StringBuilder s = new StringBuilder();
        for (int x : outputDigits) {
            s.append(x);
        }

        return Integer.parseInt(s.toString());

    }
}