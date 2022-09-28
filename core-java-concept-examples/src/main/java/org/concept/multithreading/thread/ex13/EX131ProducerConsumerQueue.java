package org.concept.multithreading.thread.ex13;

public class EX131ProducerConsumerQueue {

    public static void main(String[] args) {
        ex131();
    }
    public static final void ex131(){
        NumberQueue numberQueue = new NumberQueue();
        NumberProducer producer = new NumberProducer(numberQueue);
        NumberConsumer consumer = new NumberConsumer(numberQueue);
        producer.producerThread.start();
        consumer.consumeThread.start();
    }
}

class NumberQueue {
    private int counter = 0;
    private boolean valueSet = false;

    synchronized int getCounter() {
        while (valueSet!= false){

        }
        System.out.println("GET <= "+ this.counter);
        return this.counter;
    }

    synchronized void setCounter(int counter) {
        System.out.println("SET => "+ counter);
        this.counter = counter;
    }
}

class NumberProducer implements Runnable {
    int counter = 0;
    NumberQueue numberQueue;
    Thread producerThread;

    public NumberProducer(NumberQueue numberQueue) {
        this.numberQueue = numberQueue;
        producerThread = new Thread(this, "Number-Producer");
    }

    @Override
    public void run() {
        while (true) {
            try {
                numberQueue.setCounter(this.counter++);
                Thread.sleep(500);
            }catch (Exception ex){
                System.out.println("Producer Catch "+ex.getMessage());
            }
        }
    }
}

class NumberConsumer implements Runnable {
    NumberQueue numberQueue;
    Thread consumeThread;

    public NumberConsumer(NumberQueue numberQueue) {
        this.numberQueue = numberQueue;
        consumeThread = new Thread(this, "Number-Consumer");
    }

    @Override
    public void run() {
        while (true) {
            try {
                numberQueue.getCounter();
                Thread.sleep(500);
            }catch (Exception ex){
                System.out.println("Consumer Catch "+ex.getMessage());
            }
        }
    }
}