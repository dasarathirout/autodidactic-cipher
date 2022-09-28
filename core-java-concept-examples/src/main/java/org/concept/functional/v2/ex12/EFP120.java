package org.concept.functional.v2.ex12;

import static org.concept.functional.v2.utils.DATA.NUMBERS;
import static org.concept.functional.v2.utils.DATA.TECHNOLOGIES;
import java.util.Comparator;
import java.util.stream.Collectors;

public class EFP120 {

    private static int sum(int n1, int n2) {
        int n = n1 + n2;
        System.out.println("sum(" + n1 + "+" + n2 + ")=" + n);
        return n;
    }

    public static void executeM112() {
        int sum = 0;
        for (int n : NUMBERS) {
            sum += n;
        }
        System.out.println("FOR LOOP GROUP FUNCTION ADDED SUM :: " + sum);
    }

    public static void executeM113() {
        System.out.println("STREAM REDUCE SUM :: "
                + NUMBERS.stream()
                .reduce(Integer::sum)
        );
    }

    public static void executeM114() {
        System.out.println("STREAM REDUCE LAMBDA :: "
                + NUMBERS.stream().reduce(0, (n1, n2) -> n1 + n2));
    }

    public static void executeM115() {
        System.out.println("STREAM LAMBDA N1 :: "
                + NUMBERS.stream().reduce(0, (n1, n2) -> n1));

        System.out.println("STREAM LAMBDA N2 :: "
                + NUMBERS.stream().reduce(0, (n1, n2) -> n2));

        System.out.println("STREAM LAMBDA N2 :: "
                + NUMBERS.stream().reduce(0, (n1, n2) -> n2));

        System.out.println("STREAM LAMBDA N1 >  N2 ? :: "
                + NUMBERS.stream().reduce(0, (n1, n2) -> n1 > n2 ? n1 : n2));
        System.out.println("STREAM LAMBDA N1 <  N2 ? :: "
                + NUMBERS.stream().reduce(0, (n1, n2) -> n1 < n2 ? n1 : n2));
    }

    public static void executeM116() {
        System.out.println("STREAM SQUARE & SUM  :: "
                + NUMBERS.stream()
                .filter(n -> n < 10)
                .map(n -> n * n)
                .reduce(0, EFP120::sum)
        );
    }

    public static void executeM117() {
        System.out.println("STREAM DISTINCT SORTED STRING :: ");
        TECHNOLOGIES.stream().distinct().sorted().forEach(System.out::println);

        System.out.println("STREAM DISTINCT SORTED :: "
                + NUMBERS.stream()
                .distinct()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList())
        );

        System.out.println("STREAM DISTINCT REVERSE SORTED :: "
                + NUMBERS.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList())
        );

        System.out.println("STREAM DISTINCT SORTED DATA LENGTH :: ");
        TECHNOLOGIES.stream()
                .distinct()
                .sorted(Comparator.comparing(data-> data.length()))
                .forEach(System.out::println);
    }

}
