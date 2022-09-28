package org.concept.multithreading.thread.ex12;

public class E122ThreadSynchronizedMessage {

    public static void main(String[] args) throws Exception {
        ex122();
    }

    public static final void ex122() throws Exception {
        CallMe callMeTarget = new CallMe();
        Caller callerC1 = new Caller("TC-1", callMeTarget, "M1-Hello");
        Caller callerC2 = new Caller("TC-2", callMeTarget, "M2-Java");
        Caller callerC3 = new Caller("TC-3", callMeTarget, "M3-Synchronized");
        Caller callerC4 = new Caller("TC-4", callMeTarget, "M4-World!");

        callerC1.currentThread.start();
        callerC1.currentThread.join();

        callerC2.currentThread.start();
        callerC2.currentThread.join();

        callerC3.currentThread.start();
        callerC3.currentThread.join();

        callerC4.currentThread.start();
        callerC4.currentThread.join();

    }
}

class CallMe {
    public synchronized String doMessage(String message) throws Exception {
        String result = " [ ";
        Thread.sleep(100);
        result += message.toUpperCase() + " ] ";
        return result;
    }
}

class Caller implements Runnable {
    Thread currentThread;
    CallMe callMeTarget;
    String message;

    public Caller(String threadName, CallMe callMeTarget, String message) {
        this.callMeTarget = callMeTarget;
        this.message = message;
        currentThread = new Thread(this, threadName);
    }

    @Override
    public void run() {
        try {
            synchronized (callMeTarget) {
                String message = callMeTarget.doMessage(this.message);
                System.out.println(message);
            }
        } catch (Exception ex) {
            System.err.println("Error... " + Thread.currentThread().getName() + ex.getMessage());
        } finally {
        }
    }
}