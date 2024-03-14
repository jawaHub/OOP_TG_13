package lambda;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Mai {
    public static void main(String[] args) {
        Function<Integer, Integer> addTwo = number -> number + 2;
        Function<Integer, Integer> multThree = number -> number * 3;

        //erst addTwo dannach multThree
        int result = addTwo.andThen(multThree).apply(4);
        System.out.println(result);

        //erst multThree dannach addTwo
        int result2 = addTwo.compose(multThree).apply(4);
        System.out.println(result2);

        
        List<String> students = List.of("Peter", "Paul", "Peterpaul");
        Consumer<String> ausgabe = input -> System.out.println(input);
        
        students.forEach(ausgabe);
        
        Supplier<Double> ran1000 = () -> Math.random() * 1000;
        System.out.println(ran1000.get());
    }
}