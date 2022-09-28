package interview.questions.string.ex11;

public class ConcatenateReverse {
    public static void main(String[] args) {
        System.out.println(doConcatenateReverseSolutionS1("-01234-56789", "-ABC-DEF-"));
        reverseStringContentTestScenarios();
    }

    public static String doConcatenateReverseSolutionS1(String wordOne, String wordTwo) {
        String resultData = "";
        resultData = reverseStringContent(wordOne + wordTwo);
        return resultData;
    }

    public static String reverseStringContent(String inData) {
        String reversedData = "";
        // NULL & BLANK CHECK
        if (inData == null || inData.length() == 0) {
            return reversedData;
        }
        char[] inCharAry = inData.toCharArray();
        int size = inCharAry.length - 1;
        int halfWay = inCharAry.length / 2;
        for (int i = 0; i < halfWay; i++) {
            // SWAP
            char localValue = inCharAry[i];
            inCharAry[i] = inCharAry[size - i];
            inCharAry[size - i] = localValue;
        }
        reversedData = new String(inCharAry);
        return reversedData;
    }

    public static void reverseStringContentTestScenarios() {
        System.out.println("NULL " + reverseStringContent(null));//NULL
        System.out.println("EMPTY : " + reverseStringContent(""));//EMPTY
        System.out.println("1 : " + reverseStringContent("1"));//SIZE 1
        System.out.println("12 : " + reverseStringContent("12"));// SIZE 2
        System.out.println("123 : " + reverseStringContent("123"));// SIZE 3
        System.out.println("0123456789 : " + reverseStringContent("0123456789"));
    }
}
