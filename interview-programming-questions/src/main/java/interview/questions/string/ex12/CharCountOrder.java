package interview.questions.string.ex12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class CharCountOrder {

    public static void main(String[] arrays) throws Exception {
        BufferedReader inSys = new BufferedReader(new InputStreamReader(System.in));
        // String inData = inSys.readLine();
        // System.out.println(inData);
        checkTestScenarios();
    }

    public static void countCharsAndSort(String inPut) {
        char[] inChars = inPut.toCharArray();
        int[] alphabets = new int[128];
        HashMap countMap = new HashMap();
        for (int i = 0; i < inChars.length; i++) {
            int index = inChars[i];
            alphabets[index] = alphabets[index] + 1;
        }
        for (int i = 0; i < alphabets.length; i++) {
            if (alphabets[i] == 0) {
                continue;
            } else {
                countMap.put((char) i, alphabets[i]);
            }
        }
        List<Map.Entry<Character, Integer>> countList = new LinkedList<>(countMap.entrySet());
        Collections.sort(countList, Comparator.comparing(Map.Entry::getValue));
        LinkedHashMap<Character, Integer> resultCount = new LinkedHashMap();
        for (Map.Entry<Character, Integer> entry : countList) {
            resultCount.put(entry.getKey(), entry.getValue());
        }
        System.out.println("Result Map Counts : " + resultCount);
    }


    public static void checkTestScenarios() {
        countCharsAndSort("DasarathiRout");
    }
}
