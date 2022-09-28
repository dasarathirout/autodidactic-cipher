package org.concept.functional.v1.ex11;

import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

public class EX16 {

    private static List<String> courses = List.of("Java", "Spring", "Gradle",
            "Groovy", "React.js", "Docker",
            "Kubernetes", "AWS", "Helm",
            "Terraform", "API", "Microservices");

    public static void main(String[] args) {
        executeM11();
    }

    private static void executeM11() {
        courses.stream()
                .map(String::toUpperCase)
                .sorted(Comparator.comparing(String::length))
                .forEach(System.out::println);

        Supplier<String> supplier = String::new;

    }
}
