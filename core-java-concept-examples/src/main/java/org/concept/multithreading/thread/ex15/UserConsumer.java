package org.concept.multithreading.thread.ex15;

import java.util.Random;

public class UserConsumer implements Runnable {
    private Notification message;

    public UserConsumer(Notification newMessage) {
        this.message = newMessage;
    }

    public void run() {
        Random random = new Random();
        for (String content = message.get(); !content.equals("DONE"); content = message.get()) {
            System.out.println("MESSAGE RECEIVED : "+content);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException ex) {
                System.out.println("Consumer => "+ex.getMessage());
            }
        }
    }
}