package org.concept.design.pattern.creational;

public final class Singleton implements Cloneable{
    private static volatile Singleton singleton = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public Object clone() {
        return getInstance();
    }
}