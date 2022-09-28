package org.concept.oops.encapsulation.ex10;

public class Parent implements Base {
    static {
        System.out.println("Parent Static Block");
    }

    {
        System.out.println("Parent Init Block");
    }

    Parent() {
        this("P1");
    }

    public Parent(String content) {
        System.out.println("Parent-" + content);
    }
}
