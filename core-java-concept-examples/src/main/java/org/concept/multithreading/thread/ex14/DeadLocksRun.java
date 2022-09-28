package org.concept.multithreading.thread.ex14;

public class DeadLocksRun {
    public static void main(String[] arrays) {
        runE141();
    }

    public static final void runE141(){
        final Message messageWindow= new Message("CMD DIR");
        final Message messageLinux= new Message("BSH LS");

        new Thread(new Runnable() {
            @Override
            public void run() {
                messageWindow.sendMessage(messageLinux);
            }
        },"WINDOWS").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                messageLinux.sendMessage(messageWindow);
            }
        },"LINUX").start();
    }
}

class Message {
    private final String contents;

    public Message(String contents) {
        this.contents = contents;
    }

    public String getMessageContent() {
        return this.contents;
    }

    public synchronized void sendMessage(Message newMessage) {
        System.out.println("SEND... "+this.contents + " => " + newMessage.getMessageContent());
        newMessage.forwardMessage(this);
    }

    private synchronized void forwardMessage(Message newMessage) {
        System.out.println("FORWARD... "+this.contents + " => " + newMessage.getMessageContent());
    }
}