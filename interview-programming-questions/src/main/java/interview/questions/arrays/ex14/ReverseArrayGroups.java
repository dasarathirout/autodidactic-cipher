package interview.questions.arrays.ex14;

import java.util.Arrays;

public class ReverseArrayGroups {
    /*
    * Unit=5
    * [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    * ***************|==============
    * [4, 3, 2, 1, 0, 5, 6, 7, 8, 9]
    * ---------------|==============
    * */
    public static void main(String[] arrays) {

        int[] inPutAry = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int groupUnit = 5;
        doReverseArrayContentsByUnit(inPutAry, groupUnit);

    }

    public static void doReverseArrayContentsByUnit(int[] inPutAry, int groupUnit) {
        System.out.println(Arrays.toString(inPutAry));
        int indexLow = 0;
        int indexHigh = groupUnit-1;
        for (int i = 0; i < groupUnit / 2; i++) {
            int currentValue = inPutAry[i];
            inPutAry[i] = inPutAry[indexHigh];
            inPutAry[indexHigh]= currentValue;
            indexLow++;
            indexHigh--;
        }
        System.out.println(Arrays.toString(inPutAry));
    }
}
