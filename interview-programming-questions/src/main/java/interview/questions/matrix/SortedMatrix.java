package interview.questions.matrix;

public class SortedMatrix {
    public static int[][] matrix =
            {
                    {11, 12, 13, 14, 15},
                    {22, 23, 24, 24, 26},
                    {33, 34, 35, 36, 37},
                    {44, 45, 46, 47, 48},
                    {55, 56, 57, 58, 59},
                    {66, 67, 68, 69, 70}
            };

    public static void matrixContainer() {
        boolean isFound = false;
        int indexCount = 0;
        System.out.println("");
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                System.out.print("  ");
                System.out.print(matrix[row][column]);
                System.out.print("  ");
                indexCount++;
            }
            System.out.println("");
        }
        System.out.println("Index Counts : " + indexCount);
    }

    public static boolean searchInRowColumnSortedMatrix(int searchValue) {
        boolean isFound = false;
        int searchCount = 0;
        System.out.println("SEARCH " + searchValue);
        System.out.println("");
        for (int row = 0; row < matrix.length; row++) {
            int leftMinimum = matrix[row][0];
            int rightMaximum = matrix[row][matrix[row].length - 1];
            if (leftMinimum > searchValue) {
                searchCount++;
                System.out.println("SKIP ROW:" + row + " { " + leftMinimum + " , " + rightMaximum + " }");
                break;
            } else if (rightMaximum < searchValue) {
                searchCount++;
                System.out.println("IGNORE ROW:" + row + " { " + leftMinimum + " , " + rightMaximum + " }");
                continue;
            } else {
                System.out.println("SEARCH ROW:" + row + " { " + leftMinimum + " , " + rightMaximum + " }");
                for (int column = 0; column < matrix[row].length; column++) {
                    int currentValue = matrix[row][column];
                    if (currentValue == searchValue) {
                        searchCount++;
                        System.out.println("MATRIX[" + row + "," + column + "]");
                        isFound = true;
                    } else if (currentValue > searchValue) {
                        break;
                    } else {
                        continue;
                    }
                }
            }
        }
        System.out.println("Search Counts : " + searchCount);
        return isFound;
    }

    public static void main(String[] arrays) {
        matrixContainer();
        searchInRowColumnSortedMatrix(46);
    }
}
