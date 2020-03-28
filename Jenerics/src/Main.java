
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"
        System.out.println(i + " " + s);

        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2);
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode();

        System.out.println(mustBeTrue);
        System.out.println(mustAlsoBeTrue);
    }
}

class Pair<X, Y> {
    private X valueX;
    private Y valueY;

    private Pair(X valueX, Y valueY) {
        this.valueX = valueX;
        this.valueY = valueY;
    }

    public X getFirst() {
        return this.valueX;
    }

    public Y getSecond() {
        return this.valueY;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        } else if (!(obj instanceof Pair)) {
            return false;
        } else {
            Pair<?, ?> other = (Pair<?, ?>) obj;
            return Objects.equals(this.valueX, other.valueX) && Objects.equals(this.valueY, other.valueY);
        }
    }

    public int hashCode() {
        return Objects.hashCode(this.valueX) - Objects.hashCode(this.valueY);
    }

    public static <X, Y> Pair<X, Y> of(X valueX, Y valueY) {
        return new Pair<>(valueX, valueY);
    }
}


