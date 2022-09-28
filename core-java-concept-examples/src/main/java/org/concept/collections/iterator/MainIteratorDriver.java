package org.concept.collections.iterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class MainIteratorDriver {
    public static void main(String[] arrays) {
        //iteratorRunR1();
        //iteratorRunR2();
        iteratorRunR3();
    }

    public static final void iteratorRunR1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new String("S1"));
        arrayList.add(2);
        arrayList.add('C');
        arrayList.add(new Object());
        System.out.println(arrayList);
        //Collections.sort(arrayList);//ClassCastException @Integer.compareTo(...)
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static final void iteratorRunR2() {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(10);
        numbers.add(90);
        numbers.add(20);
        numbers.add(80);
        System.out.println(numbers);
        Iterator<Integer> its = numbers.iterator();
        while (its.hasNext()) {
            Integer me = its.next();
            if (me < 50) {
                its.remove();
            }
        }
        System.out.println(numbers);
    }

    public static final void iteratorRunR3() {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee(11, "E11"));
        employees.add(new Employee(12, "E12"));
        employees.add(new Employee(13, "E13"));
        employees.add(new Employee(14, "E14"));
        System.out.println(employees);
        Iterator<Employee> it = employees.iterator();
        while (it.hasNext()){
            Employee employee = it.next();
            employee.id+=10;
            employee.name+="@";
        }
        System.out.println(employees);
    }
}

class Employee {
    int id;
    String name;

    public Employee() {
    }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "{"+id+" , "+name+"}";
    }
}