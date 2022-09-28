package org.concept.reactive.ex11mono;

import org.concept.reactive.common.Utilities;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EX12 {
    public static void main(String[] args) {
        //executeMethodM13();
        //executeMethodM14();
        executeMethodM15();
    }

    private static void executeMethodM13() {
        Stream<String> dataStream = Stream.of("A11", "B12");
        Stream<String> distinctSortedFlat = dataStream.map(e -> {
                    try {
                        System.out.println(Thread.currentThread().getName() + ":" + Thread.currentThread().getId());
                        Thread.sleep(1000);
                    } catch (Exception ex) {
                        System.err.println(ex.fillInStackTrace());
                    }
                    return e.split("");
                })
                .flatMap(e -> Stream.of(e))
                .distinct()
                .sorted();
        System.out.println("Lazy Operators Don't Process Streams");
        System.out.println(distinctSortedFlat.getClass());

        System.out.println("Terminal Operators Processing Actual Streams Operations");
        System.out.println(distinctSortedFlat.collect(Collectors.toList()));
    }

    private static void executeMethodM14() {
        Mono<Integer> justMono = Mono.just(1);
        System.out.println(justMono);
        justMono.subscribe(
                data -> System.out.println("M14 Mono Subscriber : " + data.toString()),
                error -> System.err.println("Error On Subscribe"),
                () -> System.out.println("Processing Completed")
        );

        justMono.subscribe(
                Utilities.onNext(),
                Utilities.onError(),
                Utilities.onComplete()
        );
    }

    private static void executeMethodM15() {
        Mono<String> monoData = Mono.just("Dasarathi")
                .map(e -> {
                    //System.err.println(e.length() / 0);
                    System.err.println(e.length());
                    return e.toUpperCase() + ":" + e.length();
                });

        // monoData.subscribe(data -> System.out.println(" M15Mono Subscriber : " + data.toString()));
        monoData.subscribe(
                data -> System.out.println("Executing Mono Subscriber : " + data.toString()),
                error -> System.err.println("Error On Failed"),
                () -> System.out.println("Processing Completed")
        );

        monoData.subscribe(
                Utilities.onNext(),
                Utilities.onError(),
                Utilities.onComplete()
        );
    }
}
