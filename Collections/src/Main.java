import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {


    public static void main(String[] args) {

        Set<Integer> set1 = new LinkedHashSet<>(Arrays.asList(1,2,3,4,5,6));
        Set<Integer> set2 = new LinkedHashSet<>(Arrays.asList(4,5,6,7,8));
        System.out.println(symmetricDifference(set1,set2));
    }


    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> set1Copy = new LinkedHashSet<>(set1);
        Set<T> set2Copy = new LinkedHashSet<>(set2);

        Set<T> intersection = new LinkedHashSet<>(set1);
        intersection.retainAll(set2);

        set1Copy.removeAll(intersection);
        set2Copy.removeAll(intersection);

        set1Copy.addAll(set2Copy);

        return set1Copy;    }


}



