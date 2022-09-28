package org.concept.multithreading.executor.ex17;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinAction {

    public static void main(String[] elements) {
        executeData();
        // executeE171();
        executeE172();
    }

    private static int LENGTH = 999;
    private static int MIN = 11;
    private static int MAX = 99;
    private static int[] arrays = new int[LENGTH];

    public static final void executeData() {
        for (int i = 0; i < LENGTH; i++) {
            arrays[i] = new Random().nextInt(MIN, MAX);
        }
        //System.out.println(Arrays.toString(arrays));
    }

    public static final void executeE171() {
        ForkJoinPool worker = ForkJoinPool.commonPool();
        int indexStart = 0;
        int indexEnd = arrays.length - 1;
        int searchElement = new Random().nextInt(MIN, MAX);
        ;
        SearchNumberTask searchNumber = new SearchNumberTask(arrays, indexStart, indexEnd, searchElement);
        int frequency = worker.invoke(searchNumber);
        System.out.println("SearchElement : " + searchElement + " Has Frequency @ " + frequency);
    }

    public static void executeE172() {
        System.out.println("Total Cores : " + Runtime.getRuntime().availableProcessors());
        ForkJoinPool workers = ForkJoinPool.commonPool();
        System.out.println("Active Threads: " + workers.getActiveThreadCount());

        SearchNumberAction numberAction = new SearchNumberAction(1000);
        workers.invoke(numberAction);

        System.out.println("Active Threads: " + workers.getActiveThreadCount());
        System.out.println("Pool Size: " + workers.getPoolSize());
    }
}
