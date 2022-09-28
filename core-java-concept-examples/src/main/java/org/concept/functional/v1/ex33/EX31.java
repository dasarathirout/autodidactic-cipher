package org.concept.functional.v1.ex33;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EX31 {

    private static final int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public static void main(String[] args) {
        executeMethodM11();
        executeMethodM12();
        executeMethodM13();
        executeMethodM14();
        executeMethodM15();
        executeMethodM16();
        executeMethodM17();
    }

    private static void executeMethodM11() {
        System.out.println(Stream.of(numbers).count());
        System.out.println(Stream.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10).reduce(0, Integer::sum));
    }

    private static void executeMethodM12() {
        System.out.println(Stream.of(numbers).getClass());// ReferencePipeline (Object Reference Stream Pipeline)
        System.out.println(Arrays.stream(numbers).getClass());// IntPipeline (Primitive Stream Pipeline)
    }

    private static void executeMethodM13() {
        IntStream intStreamI1 = IntStream.range(0, 10);
        intStreamI1.forEach(n -> System.out.println(" " + n));
        IntStream intStreamI2 = IntStream.rangeClosed(0, 10);
        intStreamI2.forEach(n -> System.out.println(" " + n));
        IntStream.iterate(1, n -> n + 2).limit(10).peek(System.out::println).count();

        IntStream.range(1, 5).reduce(1, (n1, n2) -> n1 * n2);
    }

    private static void executeMethodM14() {
        List<String> keysList = List.of("A11", "B22", "C33", "D44", "E55");
        System.out.println(keysList.stream().collect(Collectors.joining("=>")));
        System.out.println(keysList.stream().map(e -> e.split("")));
        System.out.println(keysList.stream().map(e -> e.split("")).collect(Collectors.toList()));
        System.out.println(keysList.stream()
                .map(e -> e.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList()));
    }

    private static void executeMethodM15() {
        System.out.println("Executing Higher Order Functions");
        Predicate<String> predicateContains11 = createPredicateContains("11");
        Predicate<String> predicateContains22 = createPredicateContains("22");
    }

    private static Predicate<String> createPredicateContains(String inData) {
        List<String> values = List.of("A11", "B22", "C33", "D44", "E55", "F66", "G77");
        return element -> element.contains(inData);
    }

    private static void executeMethodM16() {
        String fileName = "core-java-concept-examples"+File.separator+"RAW-FILE.TXT";
        try {
            Files.lines(Paths.get(fileName))
                    //.map(e->e.split(""))
                    .map(e->e.split(" "))
                    .flatMap(Arrays::stream)
                    .distinct()
                    .sorted()
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void executeMethodM17(){
        try {
            Files.list(Paths.get("."))
                    .filter(Files::isDirectory)
                    .forEach(n -> System.out.println(" " + n));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
