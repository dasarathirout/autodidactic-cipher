package org.concept.oops.inheritance.ex12;

public class MethodReturn {
    public static void main(String[] args) {
        System.out.println(execute(1));
        System.out.println(execute(0));
    }

    public static String execute(int N) {
        try {
            int X = 1 / N;
            System.out.println("TRY");
            return "TRY";
        } catch (Exception e) {
            System.out.println("EXC");
            return "EXCEPTION";
        } finally {
            System.out.println("FIN");
            return "FINALLY";
        }
    }
}
