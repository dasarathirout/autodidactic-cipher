package org.concept.functional.v1.ex11;

import java.util.List;
import java.util.function.BinaryOperator;

public class EX13 {

    public static void main(String[] arrays) {
        executeM11();
    }

    private static void executeM11() {
        List<Integer> numbers = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        BinaryOperator<Integer> sumBinaryOperator = (n1, n2) -> n1 + n2;
        BinaryOperator<Integer> sumBinaryOperatorI2 = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer n1, Integer n2) {
                // return n1 * n2;
                return n1 + n2;
            }
        };
        int sum = numbers.stream().reduce(0, sumBinaryOperatorI2);
        System.out.println(sum);
    }
}
