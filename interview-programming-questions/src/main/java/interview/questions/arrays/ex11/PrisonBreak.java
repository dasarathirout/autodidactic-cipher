package interview.questions.arrays.ex11;

public class PrisonBreak {

    enum BAR {HORIZONTAL, VERTICAL}
    private static int[][] prisonCell;

    public static void main(String[] arrays) {

        int horizontalSize = 5;
        int verticalSize = 5;
        int[] horizontalBarRemoved = {0, 2};
        int[] verticalBarRemoved = {2, 4};
        escapeRun(horizontalSize, verticalSize, horizontalBarRemoved, verticalBarRemoved);
    }

    private static void escapeRun(int horizontalSize,
                                  int verticalSize,
                                  int[] horizontalBarRemoved,
                                  int[] verticalBarRemoved) {
        int[][] prisonCells = buildPrisonCells(5, 5);
        showPrisonCells(prisonCells);
        removeBars(BAR.HORIZONTAL, horizontalBarRemoved, prisonCells);
        removeBars(BAR.VERTICAL, verticalBarRemoved, prisonCells);

    }

    private static int[][] buildPrisonCells(int horizontalSize, int verticalSize) {
        prisonCell = new int[horizontalSize][verticalSize];
        System.out.println("BUILD : PRISON CELLS");
        for (int row = 0; row < horizontalSize; row++) {
            for (int column = 0; column < verticalSize; column++) {
                prisonCell[row][column] = 1;
            }
        }
        return prisonCell;
    }

    private static void showPrisonCells(int[][] prisonCell) {
        System.out.println();
        for (int row = 0; row < prisonCell.length; row++) {
            for (int column = 0; column < prisonCell[row].length; column++) {
                System.out.print(" " + prisonCell[row][column] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int[][] removeBars(BAR barType, int[] barPositions, int[][] prisonCells) {

        if (barType == BAR.HORIZONTAL) {
            System.out.println("REMOVED : " + BAR.HORIZONTAL);
            for (int n : barPositions) {
                for (int i = 0; i < prisonCells.length; i++) {
                    prisonCells[n][i] = 0;
                }
            }
            showPrisonCells(prisonCells);
        }
        if (barType == BAR.VERTICAL) {
            System.out.println("REMOVED : " + BAR.VERTICAL);
            for (int n : barPositions) {
                for (int i = 0; i < prisonCells.length; i++) {
                    prisonCells[i][n] = 0;
                }
            }
            showPrisonCells(prisonCells);
        }
        return prisonCells;
    }
}
