package org.concept.reactive.ex11mono;

import org.concept.reactive.common.Assignments;
import org.concept.reactive.common.Utilities;

public class EX16 {
    public static void main(String[] args) {
        executeServiceAF1();
    }

    private static void executeServiceAF1() {
        Assignments.readMonoAssignments("AF1.TXT")
                .subscribe(Utilities.onNext(),
                        Utilities.onError(),
                        Utilities.onComplete());

        Assignments.writeMonoAssignments("AF1.TXT","AF1.TXT, PROGRAM DATA")
                .subscribe(Utilities.onNext(),
                        Utilities.onError(),
                        Utilities.onComplete());

        Assignments.readMonoAssignments("AF1.TXT")
                .subscribe(Utilities.onNext(),
                        Utilities.onError(),
                        Utilities.onComplete());

        Assignments.deleteMonoAssignments("AF1.TXT")
                .subscribe(Utilities.onNext(),
                        Utilities.onError(),
                        Utilities.onComplete());
    }
}
