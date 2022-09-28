package org.concept.oops.encapsulation.ex10;

public class Child extends Parent{
    static{
        System.out.println("Child Static Block");
    }
    {
        System.out.println("Child Init Block");
    }
    Child(String content){
        System.out.println("Child-"+content);
    }
}
