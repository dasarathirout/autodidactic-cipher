package interview.questions.arrays.ex13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LeadersInArray {
    /*
     *  INPUT  : [8, 9, 6, 7, 4, 3, 5, 1, 2, 0]
     *  OUTPUT : [9, 7, 5, 2]
     *
     * */

    public static void main(String[] arrays) {
        int[] inPutAry = {8, 9, 6, 7, 4, 3, 5, 1, 2, 0};
        getFirstRightMaximumOfArray(inPutAry);
    }

    public static List<Integer> getFirstRightMaximumOfArray(int[] inAry) {
        System.out.println(Arrays.toString(inAry));
        ArrayList<Integer> leaders = new ArrayList<>();
        Stack<Integer> iStack = new Stack<>();
        iStack.push(inAry[0]);// leftMinimumVal : inAry[0]
        for (int i = 1; i < inAry.length; i++) {
            int currentIndexValue = inAry[i];
            if (currentIndexValue > iStack.peek()) {
                leaders.add(currentIndexValue);
            } else {
                iStack.push(currentIndexValue);
            }
        }
        System.out.println("STACK " + iStack);
        System.out.println("LIST " + leaders);
        return leaders;
    }
}
