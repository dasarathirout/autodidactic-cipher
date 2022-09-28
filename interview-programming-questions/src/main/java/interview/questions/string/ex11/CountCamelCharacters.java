package interview.questions.string.ex11;

public class CountCamelCharacters {
    public static void main(String[] args) {
        countCountCamelTestScenarios();
    }

    public static int countCountCamel(String inData) {
        int resultCount = 0;
        if (inData == null || inData.length() == 0) {
            return resultCount;
        }
        char[] inCharAry = inData.toCharArray();
        for (int i = 0; i < inCharAry.length; i++) {
            // A=65 , Z=90
            if (inCharAry[i] >= 65 && inCharAry[i] <= 90) {
                resultCount++;
            }
        }
        return resultCount;
    }

    public static void countCountCamelTestScenarios() {
        System.out.println("" + countCountCamel(null));
        System.out.println("" + countCountCamel(""));
        System.out.println("" + countCountCamel("a"));
        System.out.println("" + countCountCamel("A"));
        System.out.println("" + countCountCamel("AaBbCcDd"));
    }
}
