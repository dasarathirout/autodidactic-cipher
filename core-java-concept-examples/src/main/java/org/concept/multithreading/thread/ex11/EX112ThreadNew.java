package org.concept.multithreading.thread.ex11;

public class EX112ThreadNew {

    public static void main(String[] args) {
        ex111();
        ex112();
    }

    public static void ex111() {
        NewThreadTwo threadTwo = new NewThreadTwo();
        threadTwo.start();
    }

    public static void ex112() {
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println("Sleeping Main Thread : " + i);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.err.println("Main Thread Interrupted :" + e.getLocalizedMessage());
        } finally {
            System.out.println("Existing Main Thread.");
        }
    }
}

class NewThreadTwo extends Thread {

    public NewThreadTwo() {
        super("Thread-Two");
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println("Sleeping Child Thread : " + i);
                Thread.sleep(500);
            }
        } catch (Exception e) {
            System.err.println("Child Thread Interrupted :" + e.getLocalizedMessage());
        } finally {
            System.out.println("Existing Child Thread.");
        }
    }
}