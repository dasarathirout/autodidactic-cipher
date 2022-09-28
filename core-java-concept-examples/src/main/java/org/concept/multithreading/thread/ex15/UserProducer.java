package org.concept.multithreading.thread.ex15;

import java.util.Random;

public class UserProducer implements Runnable {
    private Notification message;

    public UserProducer(Notification newMessage) {
        this.message = newMessage;
    }

    public void run() {
        String messageArray[] = {"MSG-01", "MSG-02", "MSG-03", "MSG-04", "MSG-05"};
        Random random = new Random();
        for (int i = 0;
             i < messageArray.length;
             i++) {
            message.set(messageArray[i]);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException ex) {
                System.out.println("Producer => "+ex.getMessage());
            }
        }
        message.set("DONE");
    }
}