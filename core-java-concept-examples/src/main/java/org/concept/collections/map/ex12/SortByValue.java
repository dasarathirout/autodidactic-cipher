package org.concept.collections.map.ex12;

import java.util.*;

public class SortByValue {
    public static void main(String[] arrays) {
        executeE121();
    }

    public static final void executeE121() {
        Map<String, Integer> map = new HashMap<>();
        map.put("D", 4);
        map.put("B", 2);
        map.put("C", 3);
        map.put("A", 1);

        List<Map.Entry<String, Integer>> entries = new ArrayList(map.entrySet());
        Collections.sort(entries,
                new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> entryE1,
                                       Map.Entry<String, Integer> entryE2) {
                        return entryE2.getValue()-entryE1.getValue();
                    }
                });
        System.out.println(entries);
        Collections.sort(entries, Comparator.comparingInt(Map.Entry::getValue));

        System.out.println(entries);
    }
}
