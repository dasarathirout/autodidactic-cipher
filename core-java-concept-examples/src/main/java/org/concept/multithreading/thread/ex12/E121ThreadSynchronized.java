package org.concept.multithreading.thread.ex12;

import java.io.*;
import java.util.Random;

public class E121ThreadSynchronized {
    public static void main(String[] args) throws Exception {
        ex121();
    }

    public static void ex121() throws Exception {
        WriterWorker workerT1 = new WriterWorker("WT-1", "1");
        WriterWorker workerT2 = new WriterWorker("WT-2", "2");
        WriterWorker workerT3 = new WriterWorker("WT-3", "3");

        workerT1.currentThread.start();
        workerT1.currentThread.join();

        workerT2.currentThread.start();
        workerT2.currentThread.join();

        workerT3.currentThread.start();
        workerT3.currentThread.join();

        System.out.println("Done... " + Thread.currentThread().getName());
    }
}

class WriterWorker implements Runnable {
    Thread currentThread;
    String threadName;
    String content = "";
    private static Random random = new Random();

    public WriterWorker(String threadName, String content) {
        System.out.println("Init... WriterWorker(" + threadName + ")");
        this.threadName = threadName;
        this.content = content;
        currentThread = new Thread(this, this.threadName);
    }

    public static synchronized String line(String data) throws Exception {
        String resultData = "";
        for (int n = 1; n < 10; n++) {
            resultData += data;
        }
        return resultData;
    }

    @Override
    public void run() {
        try {
            TextWriter.write(line(content));
            synchronized (this) {
                Thread.sleep(random.nextInt(5) * 100);
                TextWriter.write("\n");
                System.out.println("Done... " + Thread.currentThread().getName());
            }
        } catch (Exception e) {
            System.err.println("WriterWorker Interrupted :" + e.getLocalizedMessage());
        }
    }
}

class TextWriter {

    private static String fileName = "E121ThreadSynchronized.log";

    public static void write(String inData) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName, true);
            fileWriter.write(inData);
        } catch (Exception ex) {
            System.err.println("TextWriter Catch :" + ex);
        } finally {
            try {
                fileWriter.close();
            } catch (Exception ex) {
                System.err.println("TextWriter Finally:" + ex);
            }
        }
    }
}