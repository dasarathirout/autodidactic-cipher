package org.concept.reactive.ex11mono;

import org.concept.reactive.common.Utilities;
import reactor.core.publisher.Mono;

public class EX13 {
    public static void main(String[] args) {
        executeMethodM14();
    }

    public static Mono<String> userRepository(int userID) {
        if (userID == 1) {
            return Mono.just(Utilities.getFullName());
        } else if (userID == 2) {
            return Mono.empty();
        } else {
            return Mono.error(new RuntimeException("Invalid User ID : " + userID));
        }
    }

    private static void executeMethodM14() {
        userRepository(1)
                .subscribe(
                        Utilities.onNext(),
                        Utilities.onError(),
                        Utilities.onComplete()
                );

        userRepository(2)
                .subscribe(
                        Utilities.onNext(),
                        Utilities.onError(),
                        Utilities.onComplete()
                );

        userRepository(3)
                .subscribe(
                        Utilities.onNext(),
                        Utilities.onError(),
                        Utilities.onComplete()
                );
    }
}
