package org.concept.multithreading.executor.ex16;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CallableTask implements Callable {

    private String message;

    public CallableTask(String message) {
        this.message = message;
    }

    @Override
    public String call() throws Exception {
        System.out.println("TIME CALL : "+TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));
        Thread.sleep(new Random().nextInt(2, 10) * 1000);
        return new String(message.toUpperCase() + ":" + message.length());
    }
}
