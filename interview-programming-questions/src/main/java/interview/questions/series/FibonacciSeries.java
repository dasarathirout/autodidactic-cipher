package interview.questions.series;


// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ...
// f(n) = f(n-1) + f(n-2)


public class FibonacciSeries {

    static int counters = 0;

    public static void main(String[] arrays) {
        System.out.println(fibonacciRecursion(10));
        System.out.println(fibonacciDynamicProgramming(100));
        System.out.println(fibonacciSpaceDP(100));
    }

    static int fibonacciRecursion(int index) {
        {
            switch (index) {
                case 0:
                    return 0;
                case 1:
                    return 1;
            }
            return fibonacciRecursion(index - 1) + fibonacciRecursion(index - 2);
        }
    }

    static int fibonacciDynamicProgramming(int index) {
        int[] fibonacciArray = new int[index + 2];
        fibonacciArray[0] = 0;
        fibonacciArray[1] = 1;
        for (int i = 2; i <= index; i++) {
            fibonacciArray[i] = fibonacciArray[i - 1] + fibonacciArray[i - 2];
        }
        return fibonacciArray[index];
    }

    static int fibonacciSpaceDP(int index) {
        int FSN0 = 0;
        int FSN1 = 1;
        int FSNN = -1;
        for (int i = 2; i <= index; i++) {
            FSNN = FSN0 + FSN1;
            FSN0 = FSN1;
            FSN1 = FSNN;
        }
        return FSNN;
    }
}
