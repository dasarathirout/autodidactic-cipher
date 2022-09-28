package interview.questions.arrays.ex12;

public class ShowBucketCollections {
    /*
     **==========================================================
     * * Trapping Rain Water
     **==========================================================
     **                                 ___
     **             ___                |   |        ___
     **            |   |        ___    |   |___    |   |
     **         ___|   |    ___|   |   |   |   |   |   |
     **     ___|___|___|___|___|___|___|___|___|___|___|___
     **     {0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0}
     **                                 ___
     **             ___                |   |        ___
     **            |   | *   *  _*_  * |   |_*_  * |   |
     **         ___|   | *  _*_|   | * |   |   | * |   |
     **     ___|___|___|_*_|___|___|_*_|___|___|_*_|___|___
     **     {0,  1,  3,  0,  1,  2,  0,  4,  2,  0,  3,  0}
     **
     **     Solution: 13 Units(*)
     **==========================================================
     **==========================================================
     */


    public static void main(String[] arrays) {
        collectShowBucketsScenarioTest();
    }

    public static Integer computeSnowPackages(Integer[] arrayHeights) {
        int collectedBlockCounts = 0;
        for (int index = 1; index < arrayHeights.length - 1; index++) {

            int leftMaximum = 0;
            int rightMaximum = 0;
            for (int i = 0; i < index; i++) {
                leftMaximum = Math.max(leftMaximum, arrayHeights[i]);
            }

            for (int i = index; i < arrayHeights.length; i++) {
                rightMaximum = Math.max(rightMaximum, arrayHeights[i]);
            }
            collectedBlockCounts += Math.min(leftMaximum, rightMaximum) - arrayHeights[index];

        }
        System.out.println("Collected Units: " + collectedBlockCounts);
        return collectedBlockCounts;
    }

    public static int volumeOfTrappedRainWater(int[] heights) {
        int n = heights.length;
        int totalRainWater = 0;
        for (int i = 0; i < n; i++){
            int maxLeft = 0, maxRight = 0;
            for (int j = 0; j <= i; j++){
                maxLeft = Math.max (maxLeft, heights[j]);
            }
            for (int j = i; j < n; j++) {
                maxRight = Math.max (maxRight, heights[j]);
            }
            totalRainWater += Math.min (maxRight, maxLeft) - heights[i];
        }
        return totalRainWater;
    }

    public static boolean collectShowBucketsScenarioTest() {
        int blockCounts = computeSnowPackages(new Integer[]{0, 1, 3, 0, 1, 2, 0, 4, 2, 0, 3, 0});
        int [] ary = {0, 1, 3, 0, 1, 2, 0, 4, 2, 0, 3, 0};
        //blockCounts = volumeOfTrappedRainWater(ary);
        boolean result = blockCounts==13;
        System.out.println("Counts:"+blockCounts+" Result:"+result);
        return result;
    }

}
