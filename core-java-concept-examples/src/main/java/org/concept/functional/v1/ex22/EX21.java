package org.concept.functional.v1.ex22;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EX21 {
    private static List<Course> courses = List.of(
            new Course("Java", "CPL", 95, 2000),
            new Course("JavaScript", "CPL", 90, 500),
            new Course("Python", "CPL", 90, 800),
            new Course("Go", "CPL", 90, 200),
            new Course("React.js", "UI-FRAMEWORK", 90, 700),
            new Course("Angular", "UI-FRAMEWORK", 90, 700),
            new Course("SpringBoot", "FRAMEWORK", 95, 1000),
            new Course("Docker", "IMAGE", 70, 400),
            new Course("PodMan", "IMAGE", 70, 400),
            new Course("Kubernetes", "DEPLOYMENT", 95, 500),
            new Course("Helm", "DEPLOYMENT", 80, 400),
            new Course("Terraform", "FRAMEWORK", 60, 100),
            new Course("Jenkins", "DEPLOYMENT", 80, 300),
            new Course("Gradle", "BUILD", 80, 400),
            new Course("Maven", "BUILD", 60, 400),
            new Course("Shell", "SCRIPT", 75, 300),
            new Course("Groovy", "SCRIPT", 70, 600)
    );

    public static void main(String[] args) {
        accomplishM11();
        accomplishM12();
        accomplishM13();
        accomplishM14();
        accomplishM15();
        accomplishM16();
        accomplishM17();
    }

    private static void accomplishM11() {
        System.out.println("All Review > 85% : " + courses.stream().allMatch(course -> course.getReview() > 85));
        System.out.println("Any Review > 90% : " + courses.stream().anyMatch(course -> course.getReview() > 90));
        System.out.println("All Not Match > 75% :" + courses.stream().noneMatch(course -> course.getReview() > 75));
    }

    private static void accomplishM12() {
        Comparator<Course> courseComparatorReview = Comparator.comparing(Course::getReview);
        List<Course> reviews = courses.stream()
                .sorted(courseComparatorReview)
                .collect(Collectors.toList());
        System.out.println(reviews);


        Comparator<Course> courseComparatorUserCount = Comparator.comparing(Course::getUserCount);
        List<Course> counts = courses.stream()
                .sorted(courseComparatorUserCount)
                .collect(Collectors.toList());
        System.out.println(counts);

        Comparator<Course> courseComparatorUserCountAndReview = Comparator.comparing(Course::getUserCount)
                .thenComparing(Course::getReview).reversed();
        List<Course> countsReview = courses.stream()
                .sorted(courseComparatorUserCountAndReview)
                .collect(Collectors.toList());
        System.out.println(countsReview);

    }

    private static void accomplishM13() {
        Comparator<Course> courseComparatorName = Comparator.comparing(Course::getName);
        System.out.println(courses.stream()
                .sorted(courseComparatorName)
                .limit(3)
                .collect(Collectors.toList()));

        System.out.println(courses.stream()
                .sorted(courseComparatorName)
                .limit(5)
                .skip(3)
                .collect(Collectors.toList()));

    }

    private static void accomplishM14() {
        System.out.println(courses.stream()
                .takeWhile(course -> course.getReview() > 80)
                .collect(Collectors.toList()));

        System.out.println(courses.stream()
                .dropWhile(course -> course.getReview() > 80)
                .collect(Collectors.toList()));

    }

    private static void accomplishM15() {
        System.out.println(courses.stream().findFirst());
        System.out.println(courses.stream().findAny());
        System.out.println(courses.stream().max(Comparator.comparing(Course::getUserCount)));
        System.out.println(courses.stream().min(Comparator.comparing(Course::getReview)));

        System.out.println(courses.stream()
                .filter(course -> course.getReview() > 100) // NO DATA
                .min(Comparator.comparing(Course::getReview))
                .orElse(new Course("D1", "C2", 3, 4)));
    }

    private static void accomplishM16() {
        System.out.println(courses.stream().count());
        System.out.println(courses.stream().mapToInt(course -> course.getUserCount()).sum());
        System.out.println(courses.stream().mapToInt(course -> course.getUserCount()).average());
    }

    private static void accomplishM17() {
        System.out.println(courses.stream().collect(Collectors.groupingBy(course -> course.getCategory())));

        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(
                        course -> course.getCategory(),
                        Collectors.counting())));

        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(
                        Course::getCategory,
                        Collectors.maxBy(Comparator.comparing(Course::getReview))
                )));

        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(
                        Course::getCategory,
                        Collectors.mapping(Course::getName, Collectors.toList())
                )));
    }
}
