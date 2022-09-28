package org.concept.functional.v2.ex12;

import static org.concept.functional.v2.utils.DATA.NUMBERS;
import static org.concept.functional.v2.utils.DATA.TECHNOLOGIES;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class EFP121 {
    private static void show(int n) {

        System.out.print(n + ", ");
    }
    private static void showEntry(Map.Entry entry) {

        System.out.println(entry.getKey()+" => "+entry.getValue());
    }

    public static void executeM118() {
        System.out.println("STREAM TO NEW RESULTS LIST :: ");
        NUMBERS.stream().filter(n -> n > 2)
                .filter(n -> n < 20)
                .filter(n -> n % 2 == 0)
                .map(n -> n * n).toList()
                .forEach(EFP121::show);
        System.out.println();
    }

    public static void executeM119() {
        System.out.println("STREAM TO NEW RESULTS MAP & E SET :: ");
        Map<Integer, Integer> collectMap = NUMBERS.stream()
                .distinct()
                .collect(Collectors.toMap(
                        N -> N,
                        N -> N * N));

        collectMap.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(EFP121::showEntry);
    }

    public static void executeM120() {
        System.out.println("STREAM TO NEW MAPS :: ");
        Map<String,Integer> collectMap = TECHNOLOGIES.stream()
                .distinct()
                .collect(Collectors.toMap(
                        S -> S, // KEY AS NAME
                        S -> S.length()) // VALUE AS LENGTH
                );

        collectMap.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getValue)) //SORT BY VALUE SIZE
                .forEach(EFP121::showEntry);
    }

    // Intermediate Operator Process STREAM & Return STREAM Type.
    // Void & Collect & Reduce Terminal Operator Return Types Other than Stream.
}
