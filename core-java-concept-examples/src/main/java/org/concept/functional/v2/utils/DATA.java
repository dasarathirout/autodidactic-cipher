package org.concept.functional.v2.utils;

import java.util.List;
import java.util.logging.Logger;

public final class DATA {
    public static final Logger LOG = Logger.getAnonymousLogger();
    public static final List<Integer> NUMBERS = List.of(
            0, 0, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9,
            10, 11, 22, 33, 44, 55, 66, 77, 88, 99, 100, 100);
    public static final List<String> TECHNOLOGIES = List.of(
            "Amazon Web Services (AWS)", "Microsoft Azure", "Google Cloud Platform (GCP)", "Oracle Cloud", "IBM Cloud",
            "HTML", "CSS", "JavaScript", "Java JDK8/JDK11", "Python", "GoLang",
            "SpringBoot", "SpringFramework", "Spring STS4", "Spring Pivotal Cloud Foundry (PCF)",
            "POSTGRESQL", "MONGODB", "REDIS");
}

