package org.concept.reactive.ex22flux;

import net.datafaker.Faker;
import org.concept.reactive.common.Utilities;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class EX24 {
    public static void main(String[] args) throws Exception {
        executeStockProcessing();
    }

    public static Flux<Integer> getStockPrice() {
        AtomicInteger atomicInteger = new AtomicInteger(111);
        return Flux.interval(Duration.ofSeconds(1))
                .map(i -> atomicInteger.getAndAccumulate(
                        new Faker().random().nextInt(-9, 9),
                        Integer::sum));
    }

    public static void executeStockProcessing() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        getStockPrice().subscribeWith(new Subscriber<Integer>() {

            private Subscription subscription;

            @Override
            public void onSubscribe(Subscription subscription) {
                this.subscription= subscription;
                subscription.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer price) {
                System.out.println(LocalDateTime.now()+" -> Price : "+price);
                if(price>125 || price < 90 ){
                    this.subscription.cancel();
                }
            }

            @Override
            public void onError(Throwable throwable) {
                latch.countDown();
            }

            @Override
            public void onComplete() {
                latch.countDown();
            }
        });
        latch.await();
    }
}
