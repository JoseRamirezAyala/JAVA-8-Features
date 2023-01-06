package streamandcollections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import streamandcollections.model.Person;

public class ReductionExample {
    public static void main(String[] args) {

        List<Person> persons = new ArrayList<>();

        try (
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                CollectorsExample.class.getResourceAsStream("people.txt")));

                Stream<String> stream = reader.lines();

        ) {
            stream.map(line -> {
                String[] s = line.split(" ");
                Person p = new Person(s[0].trim(), Integer.parseInt(s[1]));
                persons.add(p);
                return p;
            })
                    .forEach(System.out::println);
        } catch (IOException ex) {
            System.out.println(ex);
        }

        Optional<Person> opt = persons.stream().filter(p -> p.getAge() >= 20)
                .min(Comparator.comparing(Person::getAge));

        System.out.println(opt);

        Optional<Person> opt2 = persons.stream().max(Comparator.comparing(Person::getAge));

        System.out.println(opt2);

        Map<Integer, Long> map = persons.stream()
                .collect(Collectors.groupingBy(
                        Person::getAge,
                        Collectors.counting()));

        System.out.println(map);

        Map<Integer, List<String>> map2 = persons.stream()
                .collect(Collectors.groupingBy(
                        Person::getAge,
                        Collectors.mapping(
                                Person::getName,
                                Collectors.toList())));

        System.out.println(map2);

        Map<Integer, Set<String>> map3 = persons.stream()
                .collect(Collectors.groupingBy(
                        Person::getAge,
                        Collectors.mapping(
                                Person::getName,
                                Collectors.toCollection(TreeSet::new))));

        System.out.println(map3);

        Map<Integer, String> map4 = persons.stream()
                .collect(Collectors.groupingBy(
                        Person::getAge,
                        Collectors.mapping(
                                Person::getName,
                                Collectors.joining(", "))));

        System.out.println(map4);

        List<Integer> list = Arrays.asList(10, 10, 10);

        // reduce needs to receive the identity and returns the value
        Integer red = list.stream()
                .reduce(0, Integer::sum);

        // If no identity it returns and Optional with the value
        Optional<Integer> blue = list.stream()
                .reduce(Integer::sum);

        System.out.println("red= " + red);
        System.out.println("blue= " + blue);
    }
}
