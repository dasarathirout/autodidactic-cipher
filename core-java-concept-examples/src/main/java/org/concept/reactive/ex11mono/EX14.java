package org.concept.reactive.ex11mono;

import org.concept.reactive.common.Utilities;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.Callable;

public class EX14 {
    public static void main(String[] args) {
        //driverRunE11();
        //driverRunE12();
        driverRunE13();
        driverRunE14();
    }

    private static String getName() {
        System.out.println("Generating Name ...");
        return Utilities.getFullName();
    }

    private static Mono<String> getMonoSupplier() {
        // Only Create Stream Pipeline
        Mono<String> monoSupplier = Mono.fromSupplier(() -> {
            System.out.println("Generating FullName ...");
            Utilities.doSleepSeconds(5);
            return Utilities.getFullName();
        }).map(String::toUpperCase); // Lazy Initialization
        return monoSupplier;
    }

    private static void driverRunE11() {
        // Mono<String> mono = Mono.just(getName());// Only If Had Data.
        Mono<String> monoSupplier = Mono.fromSupplier(() -> getName()); // Lazy Initialization
        monoSupplier.subscribe(Utilities.onNext());

        // With Callable
        Callable<String> callable = () -> getName();
        Mono<String> monoCallable = Mono.fromCallable(callable);
        monoCallable.subscribe(Utilities.onNext());

    }

    private static void driverRunE12() {
        // Only Create Stream Pipeline
        Mono<String> monoSupplier = getMonoSupplier();
        // Process Stream Pipeline Will Execute Only
        monoSupplier.subscribe(Utilities.onNext());
    }

    private static void driverRunE13() {

        // Only Create Stream Pipeline
        Mono<String> monoSupplier = getMonoSupplier();

        // Process Stream Pipeline Will Execute Only
        monoSupplier.subscribeOn(Schedulers.boundedElastic())
                .subscribe(Utilities.onNext());

        // Blocking Main Thread To Print Stream Pipeline Data
        // Else Method Will Came Out Without Output
        Utilities.doSleepSeconds(10);
    }

    private static void driverRunE14() {
        Mono<String> monoSupplier = getMonoSupplier();
        String userName = monoSupplier.subscribeOn(Schedulers.boundedElastic()).block();
        // Blocking Asynchronous & Wait Till Get Data From Callable
        System.out.println(userName);
    }

}
