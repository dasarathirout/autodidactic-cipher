package org.concept.multithreading.executor.ex16;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.*;

public class ExecutorServicePool {

    public static void main(String[] args) {
        //executeRunE161();
        //executeRunE162();
        executeRunE163();
    }

    public static final void executeRunE161() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Executor Service FixedThreadPool");
            }
        });
        System.out.println("isShutdown : " + executorService.isShutdown());
        System.out.println("isTerminated : " + executorService.isTerminated());
        executorService.shutdown();
        System.out.println("isShutdown : " + executorService.isShutdown());
        System.out.println("isTerminated : " + executorService.isTerminated());
    }

    public static void executeRunE162() {
        ExecutorService executorService = Executors.newScheduledThreadPool(5);
        Set<Callable<String>> callableTasks = new HashSet<Callable<String>>();
        for (int i = 0; i < 5; i++) {
            callableTasks.add(new CallableTask(i+"{"+UUID.randomUUID().toString()+"}"));
        }
        try {
            String resultAny = executorService.invokeAny(callableTasks);
            System.out.println("AnyResult = " + resultAny);
            executorService.shutdown();
        } catch (Exception e) {
        }
    }

    public static void executeRunE163() {
        ExecutorService executorService = Executors.newScheduledThreadPool(5);
        Set<Callable<String>> callableTasks = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            callableTasks.add(new CallableTask(i+"["+UUID.randomUUID().toString()+"]"));
        }
        try {
            List<Future<String>> futureResults = executorService.invokeAll(callableTasks);
            for(Future<String> currentResult : futureResults) {
                currentResult.isCancelled();
                currentResult.isDone();
                System.out.println("TIME GET : "+TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));
                System.out.println("<" + currentResult.get()+">");

            }
            //executorService.shutdownNow();
            //executorService.awaitTermination(10, TimeUnit.SECONDS);
            executorService.shutdown();
        } catch (Exception ex) {
            System.out.println(""+ex.getMessage());
        }
    }
}
