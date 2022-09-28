package org.concept.reactive.ex11mono;

import org.concept.reactive.common.Utilities;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class EX15 {
    public static void main(String[] args) {
        executeFunctionM11();
        executeFunctionM12();
        Utilities.doSleepSeconds(1);
    }

    private static CompletableFuture<String> executeGetName() {
        return CompletableFuture.supplyAsync(Utilities::getFullName);
    }

    private static void executeFunctionM11() {
        Mono.fromFuture(executeGetName()).subscribe(Utilities.onNext());
    }

    private static void executeFunctionM12() {
        Runnable runnable = () -> {
            System.out.println("Execute Mono Runnable ...");
            Utilities.doSleepSeconds(2);
            System.out.println("Process Completed.");
        };
        Mono.fromRunnable(runnable).
                subscribe(
                        Utilities.onNext(),
                        Utilities.onError(),
                        ()->{
                            System.out.println("Process Done. Sending Email");
                        }
                );
    }

}