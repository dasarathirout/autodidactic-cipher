package org.concept.functional.v1.ex11;

import java.util.List;
import java.util.stream.Collectors;

public class EX11 {
    public static void main(String[] arrays) {
        //sumNumbersList();
        collectSquareNumber();
    }

    private static int sum(int aggregateNumber, int nextNumber) {
        int result = aggregateNumber + nextNumber;
        System.out.println(aggregateNumber + " + " + nextNumber + " = " + result);
        return result;
    }

    private static void sumNumbersList() {
        List<Integer> numbers = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        int totalSum = numbers.stream().reduce(0, EX11::sum);
        int totalSumLambda = numbers.stream().reduce(0, (n1, n2) -> (n1 + n2));
        System.out.println("SUM : " + totalSumLambda);

        int searchMax = numbers.stream().reduce(Integer.MIN_VALUE, (n1, n2) -> (n1 > n2 ? n1 : n2));
        System.out.println("MAX " + searchMax);

        int eachSquareSum = numbers.stream().map(n -> n * n).reduce(0, EX11::sum);
        System.out.println("SQUARE SUM " + eachSquareSum);
    }

    private static void collectSquareNumber() {
        List<Integer> numbers = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5);
        List<Integer> numberDouble;
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .distinct()
                .sorted()
                .map(x -> x * x).collect(Collectors.toList())
                .stream()
                .toList()
                .forEach(System.out::println);

        // Intermediate Operation
        // Terminal Operation

    }
}