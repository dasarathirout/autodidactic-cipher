package org.concept.reactive.common;

import reactor.core.publisher.Mono;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Assignments {

    private static final Path WS_PATH = Paths.get("core-java-concept-examples"+ File.separator+"assignments");
    private static String readAssignmentsFile(String fileName) {
        try {
            return Files.readString(WS_PATH.resolve(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeAssignmentsFile(String fileName, String contents) {
        try {
            Files.writeString(WS_PATH.resolve(fileName), contents);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void deleteAssignmentsFile(String fileName) {
        try {
            Files.delete(WS_PATH.resolve(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Mono<String> readMonoAssignments(String fileName) {
        return Mono.fromSupplier(() -> readAssignmentsFile(fileName));
    }

    public static Mono<Void> writeMonoAssignments(String fileName, String contents) {
        return Mono.fromRunnable(() -> writeAssignmentsFile(fileName, contents));
    }

    public static Mono<Void> deleteMonoAssignments(String fileName) {
        return Mono.fromRunnable(() -> deleteAssignmentsFile(fileName));
    }
}

