package interview.questions.arrays.ex10;

import java.util.Arrays;
import java.util.logging.Logger;

public class RotationOfArray {

    private static final Logger LOG = Logger.getLogger(RotationOfArray.class.getName());

    private RotationOfArray() {
    }

    private static final int SIZE = 16;
    private static final int[] inArray = new int[SIZE];

    static {
        for (int i = 0; i < SIZE; i++) {
            inArray[i] = 10 + i;
        }
        showArrayContents();
    }

    private static void showArrayContents() {
        // Arrays.stream(inArray).forEach(element -> System.out.print(element + " "));
        LOG.info(Arrays.toString(inArray));
    }

    public static void doRotateBy(int rotateSize, boolean clockWise) {
        int iAryLen = inArray.length;
        if (clockWise) {
            rotateClockWise(rotateSize, iAryLen);
        } else {
            rotateAntiClockWise();
        }
        showArrayContents();
    }

    public static void rotateClockWise(int rotateSize, int iAryLen) {
        for (int i = 0; i < rotateSize; i++) {
            swap(i, iAryLen - rotateSize + i);
        }
    }

    public static void rotateAntiClockWise() {

    }

    public static void swap(int iStart, int iEnd) {
        int iSwap = inArray[iStart];
        inArray[iStart] = inArray[iEnd];
        inArray[iEnd] = iSwap;
    }

    public static int[] getRotatedArray() {
        return inArray;
    }

}
