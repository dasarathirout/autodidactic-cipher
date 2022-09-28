package org.concept.functional.v1.ex11;

import java.util.List;

public class EX10 {

    public static void main(String[] arrays) {
        List<Integer> numbers = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        // showEvenNumbers(numbers);
        // displayEvenNumbers(numbers);
        // displayCourses();
        showsSquareOfEvenNumbersLists();
    }

    private static void printNumber(int number) {
        System.out.println(number);
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }


    private static void showEvenNumbers(List<Integer> numbers) {
        System.out.println("Enhanced For Loop");
        for (int number : numbers) {
            if (isEven(number)) {
                printNumber(number);
            }
        }
    }

    private static void displayEvenNumbers(List<Integer> numbers) {
        System.out.println("Streams, Method Reference");
        // numbers.stream().forEach(Structured::printNumber);
        numbers.stream().
                //filter(Structured::isEven).
                        filter(n -> n % 2 == 0).
                forEach(System.out::println);
    }

    private static void displayCourses() {
        List<String> courses = List.of("JavaSE8",
                "Spring",
                "SpringBoot",
                "API",
                "Microservices",
                "AWS",
                "GCP",
                "Azure",
                "Docker",
                "Kubernetes",
                "Helm");
        //courses.stream().forEach(System.out::println);
        //courses.stream().filter(course -> course.contains("Spring")).forEach(System.out::println);
        //courses.stream().filter(course -> course.length() > 4).forEach(System.out::println);
        courses.stream()
                .map(course -> course + " " + course.length())
                .forEach(System.out::println);

    }

    private static void showsSquareOfEvenNumbersLists() {
        List<Integer> numbers = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .forEach(System.out::println);
    }
}