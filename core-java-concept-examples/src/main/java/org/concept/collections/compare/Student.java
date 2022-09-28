package org.concept.collections.compare;

import java.util.Comparator;

public class Student implements Comparable<Student> {
    public int id;
    public int age;
    public String name;
    public double score;

    public Student(int id, int age, String name, double score) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student that) {
        if (this.id == that.id)
            return 0;
        else if (this.id > that.id)
            return 1;
        else
            return -1;
    }

    @Override
    public String toString() {
        return "[ ID=" + id + ", " +
                "AGE=" + age + ", " +
                "NAME=" + name + ", " +
                "SCORE=" + score + " ]";
    }
}

class StudentAge implements Comparator<Student>
{
    @Override
    public int compare(Student S1, Student S2) {
        return S1.age- S2.age;
    }
}

class StudentScore implements Comparator<Student>
{
    @Override
    public int compare(Student S1, Student S2) {
        return (int)(S1.score- S2.score);
    }
}