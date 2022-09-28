package org.concept.functional.v2.ex11;

import static org.concept.functional.v2.utils.DATA.NUMBERS;

public class EFP110 {

    public static void executeM101(){
        System.out.print("FOR LOOPS ");
        for ( Integer i :NUMBERS){
            System.out.print(i+ ", ");
        }
        System.out.println();
    }

    private static void show(int i){
        System.out.print(i+", ");
    }
    public static void executeM102(){
        System.out.print("STREAMS :: MethodReference SHOW ");
        NUMBERS.stream().forEach(EFP110::show);
        System.out.println();
    }
    public static void executeM103(){
        System.out.print("STREAMS :: MethodReference PRINT ");
        NUMBERS.stream().forEach(System.out::print);
        System.out.println();
    }

    private static boolean isEven(int n){
        return n%2 == 0;
    }
    public static void executeM104(){
        System.out.print("STREAMS :: MethodReference FILTER isEven() ");
        NUMBERS.stream()
                .filter(EFP110::isEven)
                .forEach(System.out::print);
        System.out.println();
    }

    public static void executeM105(){
        System.out.print("STREAMS :: MethodReference FILTER Lambda Expression ");
        NUMBERS.stream()
                .filter(i-> i%2==0 ) // Lambda Expression
                .forEach(System.out::print);
        System.out.println();
    }

}
