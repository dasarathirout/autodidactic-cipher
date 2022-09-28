package org.concept.functional.v1.ex44;

public class EX44 {
    public static void main(String[] args) {
        executeMethodM11();
        executeMethodM12();
    }

    private static void executeMethodM11() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + " : " + i);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    private static void executeMethodM12() {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " : " + i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
