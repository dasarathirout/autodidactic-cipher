package org.concept.collections.compare;

import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class SortStudents {

    public static void main(String[] array) {
        sortInternal();
    }

    public static final void displayList(List<Student> list){
        System.out.println("\n================ UN-SORTED ================\n");
        for (Student student : list) {
            System.out.println(student);
        }

        System.out.println("\n================= ID-SORTED =================\n");
        Collections.sort(list);
        for (Student student : list) {
            System.out.println(student);
        }

        System.out.println("\n================= AGE-SORTED =================\n");
        Collections.sort(list, new StudentAge());
        for (Student student : list) {
            System.out.println(student);
        }

        System.out.println("\n================= SCORE-SORTED =================\n");
        Collections.sort(list, new StudentScore());
        for (Student student : list) {
            System.out.println(student);
        }
    }

    public static final void sortInternal() {
        Vector<Student> vectorList = new Vector();
        vectorList.add(new Student(14, 15, "U1", 98.75));
        vectorList.add(new Student(13, 16, "U2", 78.75));
        vectorList.add(new Student(12, 17, "U3", 78.75));
        vectorList.add(new Student(11, 18, "U4", 88.75));

        displayList(vectorList);

    }
}
