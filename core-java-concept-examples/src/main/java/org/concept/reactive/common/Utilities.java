package org.concept.reactive.common;


import net.datafaker.Faker;

import java.util.function.Consumer;

public class Utilities {
    public static final Consumer<Object> onNext() {
        return e -> System.out.println("Received OnNext : " + e);
    }

    public static final Consumer<Throwable> onError() {
        return e -> System.err.println("On Error " + e.getMessage());
    }

    public static final Runnable onComplete() {
        return () -> System.out.println("On Completed.");
    }

    public static final String getFullName() {
        return Faker.instance().name().fullName();
    }

    public static final void doSleepSeconds(int seconds) {
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            System.err.println(" Do Sleep " + seconds + " seconds Failed");
        }
    }
}
