package org.concept.functional.v2.ex14;

import static org.concept.functional.v2.utils.DATA.TECHNOLOGIES;
import java.util.Arrays;
import java.util.stream.Collectors;

public class EFP141 {
    public static void executeM133() {
        System.out.println(TECHNOLOGIES.stream().collect(Collectors.joining(" | ")));

        System.out.println(TECHNOLOGIES.stream()
                .map(e-> e.split(""))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList())
                .stream()
                .sorted()
                .collect(Collectors.toList()));

    }
}
