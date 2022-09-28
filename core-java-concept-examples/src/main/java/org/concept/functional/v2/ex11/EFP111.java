package org.concept.functional.v2.ex11;

import static org.concept.functional.v2.utils.DATA.NUMBERS;
import static org.concept.functional.v2.utils.DATA.TECHNOLOGIES;

public class EFP111 {

    private static void show(String data){
        System.out.print(data+", ");
    }
    public static void executeM106(){
        System.out.print("STREAMS TECHNOLOGIES :: ");
        TECHNOLOGIES.stream()
                .forEach(EFP111::show);
        System.out.println();
    }

    private static boolean containsData(String data, String search){
        return data.toLowerCase().contains(search.toLowerCase());
    }
    public static void executeM107(){
        System.out.print("STREAMS TECHNOLOGIES CONTAINS :: ");
        TECHNOLOGIES.stream()
                .filter(tech -> containsData(tech,"Spring"))
                .forEach(EFP111::show);
        System.out.println();
    }

    public static void executeM108(){
        System.out.print("STREAMS TECHNOLOGIES SIZE > 20 :: ");
        TECHNOLOGIES.stream()
                .filter(tech -> tech.length() > 20)
                .forEach(EFP111::show);
        System.out.println();
    }

    private static void show(int n){
        System.out.print(n+", ");
    }
    public static void executeM109(){
        System.out.print("STREAMS MAP SQUARE'S OF NUMBERS N*N 2 ... 10 :: ");
        NUMBERS.stream()
                .filter(n -> n>2 && n< 10)
                .map(n-> n*n)
                .forEach(EFP111::show);
        System.out.println();
    }

    public static void executeM110(){
        System.out.print("STREAMS MAP CUBE'S OF ODD NUMBER  < 20 :: ");
        NUMBERS.stream()
                .filter(n -> n < 20)
                .map(n-> n*n*n)
                .forEach(EFP111::show);
        System.out.println();
    }

    public static void executeM111(){
        System.out.print("STREAMS TECHS NAME LENGTH() :: ");
        TECHNOLOGIES.stream()
                .map(tech -> "["+tech+" => "+tech.length()+"]")
                .forEach(EFP111::show);
        System.out.println();
    }
}
