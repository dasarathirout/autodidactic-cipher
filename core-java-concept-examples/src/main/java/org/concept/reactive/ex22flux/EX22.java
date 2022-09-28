package org.concept.reactive.ex22flux;

import org.concept.reactive.common.Utilities;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class EX22 {
    public static void main(String[] args) {
        // executeFunctionM11();
        executeFunctionM12();
    }


    public static void executeFunctionM11() {
        Flux.range(0, 5)
                .log()
                .subscribe();
    }
    public static void executeFunctionM12() {
        AtomicReference<Subscription> atomicReferenceSubscription = new AtomicReference<>();
        Flux.range(1, 20)
                .log()
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        System.out.println("Received Subscription : " + subscription);
                        atomicReferenceSubscription.set(subscription);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("On Next : " + integer);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.err.println("On Error : " + throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("On Completed !");
                    }
                });

        Utilities.doSleepSeconds(5);
        atomicReferenceSubscription.get().request(5); // 1-5 Items
        Utilities.doSleepSeconds(5);
        atomicReferenceSubscription.get().request(5); // 6-10 Items
        Utilities.doSleepSeconds(5);
        atomicReferenceSubscription.get().cancel();// Cancel Subscription
        Utilities.doSleepSeconds(5);
        atomicReferenceSubscription.get().request(5); // No Items
        Utilities.doSleepSeconds(5);
    }
}
