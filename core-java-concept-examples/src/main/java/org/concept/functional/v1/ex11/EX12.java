package org.concept.functional.v1.ex11;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
public class EX12 {

    private static void show(int n) {
        System.out.println(" @ " + n);
    }

    private static boolean isEven(int n) {
        return n % 2 == 0;
    }

    private static int squared(int n) {
        return n * n;
    }

    public static void main(String[] arrays) {
        executeM11();
        executeM12();
        executeM13();
        executeM14();
    }

    private static void executeM11() {
        List<Integer> numbers = List.of(0, 0, 1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 12);
        numbers.stream()
                .distinct()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .toList()
                .stream()
                .forEach(System.out::println);
    }

    private static void executeM12() {
        List<Integer> numbers = List.of(0, 0, 1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 12);
        Predicate<Integer> evenPredicate = n -> n % 2 == 0;
        Function<Integer, Integer> nSquared = n -> n * n;
        Consumer<Integer> display = System.out::println;
        numbers.stream()
                .distinct()
                .filter(evenPredicate)
                .map(nSquared)
                .toList()
                .stream()
                .forEach(display);
    }

    private static void executeM13() {
        List<Integer> numbers = List.of(0, 0, 1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 12);
        Predicate<Integer> evenPredicateI2 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        };
        Function<Integer, Integer> nSquaredI2 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer * integer;
            }
        };
        Consumer<Integer> displayI2 = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(" > " + integer);
            }
        };

        numbers.stream()
                .distinct()
                .filter(evenPredicateI2)
                .map(nSquaredI2)
                .toList()
                .stream()
                .forEach(displayI2);
    }
    private static void executeM14() {
        List<Integer> numbers = List.of(0, 0, 1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 12);
        numbers.stream()
                .distinct()
                .filter(EX12::isEven)
                .map(EX12::squared)
                .toList()
                .stream()
                .forEach(EX12::show);
    }
}
