package org.concept.functional.v2.ex14;

import static org.concept.functional.v2.utils.DATA.NUMBERS;
import static org.concept.functional.v2.utils.DATA.TECHNOLOGIES;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EFP140 {

    @SuppressWarnings({"UNUSED"})
    public static void executeM127() {
        Predicate<Integer> isEvenPredicate = n->n%2==0;
        System.out.println(isEvenPredicate.test(0));

        Function<Integer,Integer> squareFunction = n-> n*n;
        System.out.println(squareFunction.apply(10));

        Consumer<Integer> printConsumer = n-> System.out.println(n);
        printConsumer.accept(123);

        BinaryOperator<Integer> binaryOperator = (n1,n2)-> 2*(n1+n2);
        System.out.println(binaryOperator.apply(10,20));

        Supplier<Integer> supplier = ()-> new Random().nextInt(1,9);
        System.out.println(supplier.get());

        UnaryOperator<Integer> unaryOperator = (n)-> n+ 2*n;
        System.out.println(unaryOperator.apply(25));

        BiPredicate<Integer, Integer> biPredicate = (n1,n2)-> n1>n2;
        System.out.println(biPredicate.test(10,11));

        BiFunction<Integer,Integer, Integer> biFunction = (n1,n2)-> 2*(n1+n2);
        System.out.println(biFunction.apply(10,20));

        BiConsumer<Integer,Integer> biConsumer = (n1, n2)-> System.out.printf("N1= {%d} & N2= {%d}",n1,n2);
        biConsumer.accept(11,22);
    }

    private static void display(String data) {
        System.out.println(data + " ");
    }
    private static void display(Integer data) {
        System.out.print(data + " | ");
    }

    public static void executeM128() {
        TECHNOLOGIES.stream()
                .sorted()
                .map(str-> str.toUpperCase())
                .forEach(System.out::println);

        TECHNOLOGIES.stream()
                .sorted()
                .map(str-> str.toLowerCase()) // NON STATIC METHOD ON OBJECT
                .forEach(EFP140::display); // STATIC METHOD ON CLASS

        Supplier<String> supplier = String::new; // Constructor Reference

    }

    public static void executeM129() {
        System.out.println("MATCH TECH NAME ALL SIZE > 9 ? "+
                TECHNOLOGIES.stream().distinct().allMatch(x-> x.length() >=10)
        );

        System.out.println("MATCH TECH NAME ALL SIZE > 3 ? "+
                TECHNOLOGIES.stream().distinct().allMatch(x-> x.length() >=3)
        );

        System.out.println("NONE MATCH TECH NAME ALL SIZE < 2 ? "+
                TECHNOLOGIES.stream().distinct().noneMatch(x-> x.length() < 2)
        );

        System.out.println("ANY MATCH TECH NAME ALL SIZE > 20 ? "+
                TECHNOLOGIES.stream().distinct().anyMatch(x-> x.length() > 20)
        );

    }

    public static void executeM130() {
        System.out.println("\nLIMIT TO 5 : ");
        NUMBERS.stream()
                .distinct()
                .sorted()
                .limit(5)
                .toList()
                .forEach(EFP140::display);

        System.out.println("\nDROP TOP 5 : ");
        NUMBERS.stream()
                .distinct()
                .sorted()
                .dropWhile(x-> x < 25)
                .skip(5)
                .limit(9)
                .toList()
                .forEach(EFP140::display);

        System.out.println("\nTAKE TOP 5 : ");
        NUMBERS.stream()
                .distinct()
                .sorted()
                .takeWhile(x-> x < 25)
                .dropWhile(x-> x > 25)
                .skip(5)
                .limit(5)
                .toList()
                .forEach(EFP140::display);
    }
    public static void executeM131() {
        System.out.println("\nFIND FIRST: "+
        NUMBERS.stream()
                .distinct()
                .sorted()
                .takeWhile(x-> x < 25)
                .dropWhile(x-> x > 25)
                .skip(5)
                .limit(5)
                .findFirst().get()
        );
        System.out.println(NUMBERS.stream().count());
        System.out.println(NUMBERS.stream().max(Comparator.naturalOrder()).get());
        System.out.println(NUMBERS.stream().min(Comparator.reverseOrder()).get());
    }

    public static void executeM132() {
        TECHNOLOGIES.stream()
                .collect(Collectors.groupingBy(
                        x->x.startsWith("Spring")
                )).entrySet().stream().forEach(System.out::println);

        int [] arrays = {0,1,2,3,4,5,6,7,8,9,0};
        System.out.println(Arrays.stream(arrays).count());
        System.out.println(Arrays.stream(arrays).count());
        System.out.println(Arrays.stream(arrays).average().getAsDouble());

        System.out.println(IntStream.range(1,10).max().getAsInt());
        System.out.println(IntStream.range(1,10).min().getAsInt());

        System.out.println(IntStream.iterate(1, e->e+10).limit(10).peek(System.out::println).sum());

    }
}
