package interview.questions.string.ex12;

import java.util.HashSet;
import java.util.Set;

public class GroupSubString {
    public static void main(String[] arrays) {
        String inPutValue = "1010000111";
        equalGroupedSubString(
                        getEvenLengthSubStringSet(
                                getSubStringSet(inPutValue)
                        ));
    }

    public static Set<String> getSubStringSet(String inStr) {
        Set<String> subSets = new HashSet<>();
        for (int i = 0; i < inStr.length(); i++) {
            for (int x = i + 1; x < inStr.length(); x++) {
                subSets.add(inStr.substring(i, x));
            }
        }
        System.out.println(subSets);
        return subSets;
    }

    public static Set<String> getEvenLengthSubStringSet(Set<String> inSet) {
        Set<String> evenSubSets = new HashSet<>();
        for (String element : inSet) {
            if (element.length() % 2 == 0) {
                evenSubSets.add(element);
            }
        }
        System.out.println(evenSubSets);
        return evenSubSets;
    }

    public static Set<String> equalGroupedSubString(Set<String> inSet) {
        Set<String> groupSubSets = new HashSet<>();
        for (String element : inSet) {
            boolean isGroupedLeft = false;
            for (int i = 0; i < element.length() / 2; i++) {
                if (element.charAt(i) == element.charAt(i + 1)) {
                    isGroupedLeft = true;
                }
            }
            boolean isGroupedRight = false;
            for (int i = element.length() / 2; i < element.length() - 1; i++) {
                if (element.charAt(i) == element.charAt(i + 1)) {
                    isGroupedRight = true;
                }
            }
            if (isGroupedLeft && isGroupedRight) {
                groupSubSets.add(element);
            }
        }
        System.out.println(groupSubSets);
        return groupSubSets;
    }
}
