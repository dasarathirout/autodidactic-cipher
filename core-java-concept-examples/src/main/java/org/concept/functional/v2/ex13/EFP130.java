package org.concept.functional.v2.ex13;

import static org.concept.functional.v2.utils.DATA.NUMBERS;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class EFP130 {
    private static void show(int n) {

        System.out.print(n + ", ");
    }
    public static void executeM121() {
        System.out.println("FUNCTIONAL INTERFACE, ASSIGN LAMBDA EXPRESSION TO JAVA TYPE");
        Consumer<Integer> showConsumer = EFP130::show;
        Predicate<Integer> isEvenPredicate = n -> n % 2 == 0;
        Function<Integer, Integer> squareFunction = n -> n * n;

        NUMBERS.stream()
                .distinct()
                .filter(isEvenPredicate)
                .map(squareFunction)
                .forEach(showConsumer);
    }

    public static void executeM122() {

        Consumer showConsumer = new Consumer() {
            @Override
            public void accept(Object ox) {
                System.out.println(ox.toString());
            }
        };
        Predicate<Integer> isEvenPredicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer n) {
                return n % 2 == 0;
            }
        };
        Function<Integer, Integer> squareFunction = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer n) {
                return n * n;
            }
        };

        NUMBERS.stream()
                .distinct()
                .filter(isEvenPredicate)
                .map(squareFunction)
                .forEach(showConsumer);
    }

    public static void executeM123() {
        Consumer<Integer> showConsumer = EFP130::show;
        NUMBERS.stream()
                .distinct()
                .forEach(showConsumer);
        System.out.println();
        BinaryOperator<Integer> sumBinaryOperator = (n1, n2) -> n1 + n2;

        System.out.println(NUMBERS.stream()
                .distinct()
                .reduce(0, sumBinaryOperator));

        BinaryOperator<Integer> xyBinaryOperator = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer x, Integer y) {
                return 2*(x+y);
            }
        };

        Predicate<Integer> intPredicate = n -> n > 1 && n < 10;
        System.out.println(NUMBERS.stream()
                .filter(intPredicate)
                .distinct()
                .reduce(1, xyBinaryOperator));

    }
}
