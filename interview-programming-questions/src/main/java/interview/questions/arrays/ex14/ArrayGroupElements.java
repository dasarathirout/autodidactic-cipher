package interview.questions.arrays.ex14;

import java.util.Arrays;
import java.util.HashMap;

public class ArrayGroupElements {
    /*
     * Segregate 0s 1s 2s Array
     **/
    public static void main(String[] arrays) {
        int[] inPutAry = {0, 1, 2, 0, 1, 2, 0, 1, 2, 0, 0, 1, 1, 2, 2};
        sortArrayGroupOf012(inPutAry);
        orderSortRedWhiteBlue(inPutAry);
    }

    public static int[] sortArrayGroupOf012(int[] inPutAry) {
        System.out.println(Arrays.toString(inPutAry));
        int[] sortedAry = new int[inPutAry.length];
        final int valueZero = 0;
        final int valueOne = 1;
        final int valueTwo = 2;

        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;
        for (int i = 0; i < inPutAry.length; i++) {
            switch (inPutAry[i]) {
                case valueZero:
                    zeroCount++;
                    break;
                case valueOne:
                    oneCount++;
                    break;
                case valueTwo:
                    twoCount++;
                    break;
                default:
                    break;
            }
        }
        HashMap<String, Integer> countsMap = new HashMap<>(3);
        countsMap.put("0s", zeroCount);
        countsMap.put("1s", oneCount);
        countsMap.put("2s", twoCount);
        System.out.println(countsMap);
        int index = 0;
        for (int i = index; i < zeroCount; i++) {
            sortedAry[i] = valueZero;
            index++;
        }
        for (int i = index; i < oneCount; i++) {
            sortedAry[i] = valueOne;
            index++;
        }
        for (int i = index; i < twoCount; i++) {
            sortedAry[i] = valueTwo;
            index++;
        }
        System.out.println(Arrays.toString(sortedAry));
        return sortedAry;
    }

    public static void orderSortRedWhiteBlue(int[] inPutAry) {
        //Dijkstra Dutch National Flag Problem
        int indexLow = 0;
        int indexHigh = inPutAry.length - 1;
        int indexMiddle = 0;
        int currentValue = 0;
        while (indexMiddle <= indexHigh) {
            switch (inPutAry[indexMiddle]) {
                case 0: {
                    //SWAP indexLow With indexMiddle
                    currentValue = inPutAry[indexLow];
                    inPutAry[indexLow] = inPutAry[indexMiddle];
                    inPutAry[indexMiddle] = currentValue;
                    indexLow++;
                    indexMiddle++;
                    break;
                }
                case 1:
                    indexMiddle++;
                    break;
                case 2: {
                    // SWAP indexMiddle With indexHigh
                    currentValue = inPutAry[indexMiddle];
                    inPutAry[indexMiddle] = inPutAry[indexHigh];
                    inPutAry[indexHigh] = currentValue;
                    indexHigh--;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(inPutAry));
    }
}
