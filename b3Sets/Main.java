package b3Sets;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        set1.add(1);
        set1.add(5);
        set1.add(4);
        set1.add(3);

        set2.addAll(Arrays.asList(new Integer[] {3,5,1,6,7,8}));
        System.out.println("Set 1: " + set1.toString());
        System.out.println("Set 2: " + set2.toString());

        Iterator a = set1.iterator();
        System.out.println("Set 1 iteriert: ");
        while (a.hasNext()) {
            System.out.println(a.next());
        }
    }
}