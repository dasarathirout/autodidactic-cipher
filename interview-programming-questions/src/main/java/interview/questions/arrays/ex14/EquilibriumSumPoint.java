package interview.questions.arrays.ex14;

import java.util.Arrays;

public class EquilibriumSumPoint {

    /*
    *===========================
    *   [5, 7, 3, 2, 1, 5, 9]
    * [5, 7, 3]  [2]  [1, 5, 9]
    * [   15    <=|=>   15   ]
    *       array[3] = 2
    *===========================
    * */

    public static void main(String[] arrays) {
        int[] inPutAry = {5, 7, 3, 2, 1, 5, 9};
        getArrayEquilibriumIndex(inPutAry);
    }

    public static int getArrayEquilibriumIndex(int[] inPutAry) {
        int equilibrium = 0;
        int totalSum = Arrays.stream(inPutAry).sum();
        System.out.println(Arrays.toString(inPutAry) + " = " + totalSum);
        int currentSum = 0;
        for (int i = 0; i < inPutAry.length; i++) {
            totalSum -= inPutAry[i];
            if (currentSum == totalSum) {
                equilibrium = i;
                System.out.println("[ " + currentSum + " <=|=> " + totalSum + " ]");
                System.out.println("array[" + equilibrium + "] = " + inPutAry[equilibrium]);
                break;
            }
            currentSum += inPutAry[i];
        }
        return equilibrium;
    }
}
