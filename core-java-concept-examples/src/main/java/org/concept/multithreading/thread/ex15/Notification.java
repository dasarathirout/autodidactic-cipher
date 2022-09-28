package org.concept.multithreading.thread.ex15;

public class Notification {
    private String message;
    private boolean empty = true;

    public synchronized String get() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("Notification Set() : "+ex.getMessage());
            }
        }
        empty = true;
        notifyAll();
        return message;
    }

    public synchronized void set(String message) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("Notification Get() : "+ex.getMessage());
            }
        }
        empty = false;
        this.message = message;
        notifyAll();
    }
}