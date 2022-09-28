package interview.questions.arrays.ex10;

import java.util.Arrays;
import java.util.logging.Logger;

public class SortedRotatedArray {

    private static final Logger LOG = Logger.getLogger(SortedRotatedArray.class.getName());
    private static int[] inArray;

    private SortedRotatedArray() {
    }

    static {
        RotationOfArray.doRotateBy(5, true);
        inArray = RotationOfArray.getRotatedArray();
        showArrayContents();
    }

    private static void showArrayContents() {
        LOG.info(Arrays.toString(inArray));
    }

    private static int getPivotIndex(boolean isAscendingOrder) {
        int currentPivotElement = 0;
        if (isAscendingOrder) {
            currentPivotElement = pivotForAscendingOrder();
        } else {
            currentPivotElement = pivotForDescendingOrder();
        }
        return currentPivotElement;
    }

    private static int pivotForAscendingOrder() {
        int ascendingPivotIndex = 0;
        for (int i = 1; i < inArray.length - 1; i++) {
            if (inArray[i] < inArray[ascendingPivotIndex]) {
                ascendingPivotIndex = i;
            } else {
                continue;
            }
        }
        return ascendingPivotIndex;
    }

    private static int pivotForDescendingOrder() {
        int descendingPivotIndex = 0;
        return descendingPivotIndex;
    }

    public static int binarySearchByPivot() {
        int iPivot = getPivotIndex(true);
        LOG.info("PIVOT INDEX : " + iPivot);
        binarySearch(0, iPivot);
        binarySearch(iPivot + 1, inArray.length - 1);
        return 0;
    }

    public static boolean binarySearch(int indexStart, int indexEnd) {
        return true;
    }
}
