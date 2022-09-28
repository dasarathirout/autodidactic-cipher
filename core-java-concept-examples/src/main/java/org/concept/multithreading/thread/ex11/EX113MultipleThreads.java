package org.concept.multithreading.thread.ex11;

public class EX113MultipleThreads {
    public static void main(String[] arrays) {
        ex113();
    }

    public static void ex113() {
        NewThreadThree threeT1 = new NewThreadThree("NT3-1");
        NewThreadThree threeT2 = new NewThreadThree("NT3-2");
        NewThreadThree threeT3 = new NewThreadThree("NT3-3");
        NewThreadThree threeT4 = new NewThreadThree("NT3-4");
        NewThreadThree threeT5 = new NewThreadThree("NT3-5");

        threeT1.currentThread.start();
        threeT2.currentThread.start();
        threeT3.currentThread.start();

        System.out.println("T1 Alive :" + threeT1.currentThread.isAlive());
        System.out.println("T2 Alive :" + threeT2.currentThread.isAlive());
        System.out.println("T3 Alive :" + threeT3.currentThread.isAlive());
        System.out.println("T4 Alive :" + threeT4.currentThread.isAlive());
        System.out.println("T4 Alive :" + threeT5.currentThread.isAlive());

        threeT4.currentThread.start();
        threeT5.currentThread.start();

        try {
            //threeT1.currentThread.join();
            //threeT2.currentThread.join();
            //threeT3.currentThread.join();
            //threeT4.currentThread.join();
            //threeT5.currentThread.join();

        } catch (Exception e) {
            System.err.println("Main Thread Interrupted :" + e.getLocalizedMessage());
        } finally {
            System.out.println("T1 Alive :" + threeT1.currentThread.isAlive());
            System.out.println("T2 Alive :" + threeT2.currentThread.isAlive());
            System.out.println("T3 Alive :" + threeT3.currentThread.isAlive());
            System.out.println("T4 Alive :" + threeT4.currentThread.isAlive());
            System.out.println("T4 Alive :" + threeT5.currentThread.isAlive());
            System.out.println("Existing Main Thread");
        }
    }

}

class NewThreadThree implements Runnable {

    Thread currentThread;
    String threadName;

    public NewThreadThree(String threadName) {
        System.out.println("Init... NewThreadThree(" + threadName + ")");
        this.threadName = threadName;
        currentThread = new Thread(this, this.threadName);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println("Sleeping Child : " + threadName + " Count: " + i);
                Thread.sleep(100);
            }
        } catch (Exception e) {
            System.err.println("Child ThreadThree Interrupted :" + e.getLocalizedMessage());
        } finally {
            System.out.println("Existing Child : " + threadName);
        }
    }
}
