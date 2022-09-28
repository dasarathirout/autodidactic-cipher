package org.concept.multithreading.thread.ex15;

public class GuardedBlocks {

    public static void main(String[] args) {
        notificationProducerConsumer();
    }

    public static void notificationProducerConsumer() {
        Notification message = new Notification();
        (new Thread(new UserProducer(message), "Producer Notification")).start();
        (new Thread(new UserConsumer(message), "Consumer Notification")).start();
    }

}
