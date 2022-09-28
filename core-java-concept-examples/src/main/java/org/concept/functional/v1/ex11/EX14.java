package org.concept.functional.v1.ex11;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EX14 {
    public static void main(String[] arrays) {
        executeM11();
        executeM12();
    }

    private static void displayCheck(List<Integer> integers, Predicate<Integer> predicate) {
        integers.stream().filter(predicate).forEach(System.out::println);
    }

    private static void executeM11() {
        System.out.println("Behavioral Parameterization Predicate");
        List<Integer> numbers = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("EVEN-X");
        Predicate<Integer> evenCheck = n -> n % 2 == 0;
        displayCheck(numbers, evenCheck);

        System.out.println("ODD-X");
        Predicate<Integer> oddCheck = n -> n % 2 == 1;
        displayCheck(numbers, oddCheck);

        System.out.println("MOD-3");
        displayCheck(numbers, n -> n % 3 == 0);

        System.out.println("MOD-4");
        displayCheck(numbers, n -> n % 4 == 0);
    }

    private static void displayNumbersMapping(List<Integer> numbers, Function<Integer, Integer> squareMap) {
        numbers.stream()
                .map(squareMap)
                .collect(Collectors.toList())
                .stream().
                forEach(System.out::println);
    }

    private static void executeM12() {
        System.out.println("Behavioral Parameterization Function");
        List<Integer> numbers = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Function<Integer, Integer> doubleNumber = n -> 2 * n;
        System.out.println("2X");
        displayNumbersMapping(numbers, doubleNumber);
        System.out.println("X^2");
        displayNumbersMapping(numbers, n -> n * n);
        System.out.println("X^3");
        displayNumbersMapping(numbers, n -> n * n * n);
    }
}
