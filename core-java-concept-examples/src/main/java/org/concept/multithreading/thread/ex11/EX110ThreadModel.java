package org.concept.multithreading.thread.ex11;

public class EX110ThreadModel {
    public static void main(String[] arrays) {
        ex110();

    }

    public static void ex110() {
        Thread currentThread = Thread.currentThread();
        System.out.println(currentThread.getName());
        System.out.println(currentThread.getId());
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println("Sleeping : "+i);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
    }
}
