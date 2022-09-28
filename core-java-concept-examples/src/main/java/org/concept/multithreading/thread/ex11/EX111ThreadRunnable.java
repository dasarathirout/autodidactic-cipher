package org.concept.multithreading.thread.ex11;

public class EX111ThreadRunnable {
    public static void main(String[] arrays) {
        ex111();
        ex112();
    }

    public static void ex111() {
        NewThreadOne one = new NewThreadOne();
        one.threadOne.start();
    }

    public static void ex112() {
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println("Sleeping Main Thread : " + i);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.err.println("Main Thread Interrupted :" + e.getLocalizedMessage());
        }
        finally {
            System.out.println("Existing Main Thread.");
        }
    }
}

class NewThreadOne implements Runnable {

    Thread threadOne;

    public NewThreadOne() {
        threadOne = new Thread(this, "Thread-One");
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
        }
        finally {
            System.out.println("Existing Child Thread.");
        }
    }
}