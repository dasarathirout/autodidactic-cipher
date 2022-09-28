package org.concept.reactive.ex22flux;

import org.concept.reactive.common.Utilities;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EX21 {
    public static void main(String[] args) {
        executeMethodM11();
        executeMethodM12();
        executeMethodM13();
        executeMethodM14();
        executeMethodM15();
        executeMethodM16();
    }

    private static void executeMethodM11() {
        Flux<Integer> integerFlux = Flux.just(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        integerFlux.subscribe(Utilities.onNext(), Utilities.onError(), Utilities.onComplete());

        Flux<Integer> evenFlux = integerFlux.filter(n -> n % 2 == 0);
        evenFlux.subscribe(Utilities.onNext(), Utilities.onError(), Utilities.onComplete());
    }

    private static void executeMethodM12() {
        Flux<Integer> integerEmptyFlux = Flux.empty();
        integerEmptyFlux.subscribe(Utilities.onNext(), Utilities.onError(), Utilities.onComplete());
    }

    private static void executeMethodM13() {
        Integer[] arrays = {11, 12, 13, 14, 15};
        Flux.fromArray(arrays).subscribe(Utilities.onNext());

        List<String> lists = Arrays.asList("A1", "B2", "C3", "D4", "E5");
        Flux.fromIterable(lists).subscribe(Utilities.onNext());
    }

    private static void executeMethodM14() {
        Stream<Integer> numbersStream = List.of(11, 22, 33, 44, 55).stream();
        numbersStream.forEach(System.out::println);
        System.out.println("Cant use stream after terminal operator closed. ");
        // stream.forEach(System.out::println);
    }

    private static void executeMethodM15() {
        List<Integer> integers = List.of(11, 22, 33, 44, 55);
        Stream<Integer> integerStream = integers.stream();
        Flux<Integer> integerFlux = Flux.fromStream(integerStream);
        // Works
        integerFlux.subscribe(
                Utilities.onNext(),
                Utilities.onError(),
                Utilities.onComplete()
        );

        // Error
        integerFlux.subscribe(
                Utilities.onNext(),
                Utilities.onError(),
                Utilities.onComplete()
        );

        // Error
        Flux.fromStream(() -> integerStream).subscribe(
                Utilities.onNext(),
                Utilities.onError(),
                Utilities.onComplete()
        );


        // Works With New Stream Pipeline
        Flux.fromStream(() -> integers.stream()).subscribe(
                Utilities.onNext(),
                Utilities.onError(),
                Utilities.onComplete()
        );
    }

    private static void executeMethodM16() {
        Flux.range(1, 10).subscribe(
                Utilities.onNext(),
                Utilities.onError(),
                Utilities.onComplete()
        );

        Flux.range(5, 10)
                .log() // Debug logging
                .map((i) ->"("+ i + ") " + Utilities.getFullName())
                .subscribe(
                        Utilities.onNext(),
                        Utilities.onError(),
                        Utilities.onComplete()
                );
    }
}
