package org.concept.reactive.ex22flux;

import org.concept.reactive.common.Utilities;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class EX23 {
    public static void main(String[] args) {
        executeFunctionM11();
        executeFunctionM12();
        executeFunctionM13();
        executeFunctionM14();
    }

    private static String createName() {
        Utilities.doSleepSeconds(1);
        return Utilities.getFullName();
    }

    public static List<String> generateNameList(int counts) {
        List<String> names = new ArrayList<String>();
        for (int i = 0; i < counts; i++) {
            names.add(createName());
        }
        return names;
    }

    public static Flux<String> generateNameFlux(int counts) {
        return Flux
                .range(1, counts)
                .map((i) -> i + "." + createName());
    }

    public static void executeFunctionM11() {
        System.out.println(generateNameList(5));// Wait Till All Data Generated & Returned
        generateNameFlux(5).log().subscribe();//
    }

    public static void executeFunctionM12() {
        Flux.interval(Duration.ofSeconds(2)).subscribe(Utilities.onNext());
        Utilities.doSleepSeconds(10);
    }

    public static void executeFunctionM13() {
        Mono<String> mono = Mono.just("DATA");
        Flux<String> flux = Flux.from(mono);
        flux.subscribe(Utilities.onNext());
    }

    public static void executeFunctionM14() {
        Flux<Integer> integerFlux = Flux.range(5, 20);
        Mono<Integer> integerMono = integerFlux.filter(i -> i % 5 == 0 && i > 10).log().next();
        integerMono.log().subscribe(Utilities.onNext());
    }
}
