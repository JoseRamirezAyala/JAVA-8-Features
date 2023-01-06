package streamandcollections;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class IntermediaryAndFinal {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("one", "two", "three", "four", "five");

        Predicate<String> p1 = Predicate.isEqual("two");
        Predicate<String> p2 = Predicate.isEqual("three");

        List<String> list = new ArrayList<>();

        /*
         * If this code is executed nothing should happen as peek and filter return
         * stream, no data is processed
         * stream
         * .peek(System.out::println)
         * .filter(p1.or(p2))
         * .peek(list::add);
         */

        System.out.println("size= " + list.size());

        // forEach is not intermediary it's a final operation and does not return a stream
        // only a final operation will trigger the intermediary operations that are connected 
        stream
                .peek(System.out::println)
                .filter(p1.or(p2))
                .forEach(list::add);

        System.out.println("size= " + list.size());

    }
}
