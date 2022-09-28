package org.concept.functional.v1.ex11;

import java.util.Random;
import java.util.function.*;

public class EX15 {
    public static void main(String[] arrays) {
        executeM11();
        executeM12();
        executeM13();
        executeM14();
    }

    private static void executeM11() {
        Supplier<Integer> randomI1 = () -> 99;
        System.out.println(randomI1.get());

        Supplier<Integer> randomI2 = () -> {
            Random random = new Random();
            return random.nextInt(11, 99);
        };
        System.out.println(randomI2.get());

        UnaryOperator<Integer> unaryOperator = x -> 10 * x;
        System.out.println(unaryOperator.apply(5));
    }

    private static void executeM12() {
        BiPredicate<Integer, String> predicate = (n, s) -> {
            return n > 5 || s.length() > 5;
        };

        System.out.println(predicate.test(1, "ABC"));
        System.out.println(predicate.test(9, "Hello World !"));
    }

    private static void executeM13() {
        BiFunction<Integer, Integer, String> biFunction = (n1, n2) -> {
            return "2("+n1 + "+" + n2 + ") => " + 2 * (n1 + n2);
        };
        System.out.println(biFunction.apply(10, 20));
    }

    private static void executeM14() {
        BiConsumer<String, String> biConsumer = (s1,s2)-> {
            System.out.println(s1 +" , "+s2);
        };
        biConsumer.accept("ABC", "123");
    }
}
