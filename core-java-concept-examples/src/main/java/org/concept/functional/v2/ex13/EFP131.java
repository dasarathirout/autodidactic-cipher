package org.concept.functional.v2.ex13;

import static org.concept.functional.v2.utils.DATA.NUMBERS;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class EFP131 {

    private static void formatDataDelimiter(int data, String delimiter) {
        String blankSpace = " ";
        System.out.print(data + delimiter + blankSpace);
    }

    private static void printBlank(int data) {
        formatDataDelimiter(data, "  ");
    }

    private static void printComma(int data) {
        formatDataDelimiter(data, " , ");
    }

    private static void printArrow(int data) {
        formatDataDelimiter(data, " > ");
    }

    private static void distinctFilterPrint(
            List<Integer> numbers,
            Predicate<? super Integer> predicate,
            Consumer<Integer> printType) {
        numbers.stream()
                .distinct()
                .filter(predicate)
                .forEach(printType);
    }

    public static void executeM124() {
        System.out.println();
        Predicate<Integer> evenNumber = n -> n % 2 == 0;
        Consumer<Integer> showArrow = EFP131::printArrow;
        distinctFilterPrint(NUMBERS, evenNumber, showArrow);
    }

    public static void executeM125() {
        System.out.println();
        Predicate<Integer> oddNumber = n -> n % 2 != 0;
        Consumer<Integer> showComma = EFP131::printComma;
        distinctFilterPrint(NUMBERS, oddNumber, showComma);
    }

    public static void executeM126() {
        System.out.println();
        Predicate<Integer> multiplesThree = n -> n % 3 == 0;
        Consumer<Integer> showBlank = EFP131::printBlank;
        distinctFilterPrint(NUMBERS, multiplesThree, showBlank);
    }
}
