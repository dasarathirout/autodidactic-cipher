package interview.questions.string.ex11;

public class ConvertLowerCase {
    public static void main(String[] args) {
        checkConvertLowerCaseSolutionTestScenarios();
    }

    public static String doConvertLowerCaseSolutionS1(String inData) {
        String lowerCase = "";
        char[] inCharAry = inData.toCharArray();
        char lowerCaseA = 97;
        char upperCaseA = 65;
        char valueDiff = (char) (lowerCaseA - upperCaseA);
        for (int i = 0; i < inCharAry.length; i++) {
            if (inCharAry[i] < upperCaseA) {
                continue;
            }
            if (inCharAry[i] < lowerCaseA) {
                inCharAry[i] = (char) (inCharAry[i] + valueDiff);
            }
        }
        lowerCase = new String(inCharAry);
        return lowerCase;
    }

    public static void checkConvertLowerCaseSolutionTestScenarios() {
        System.out.println(doConvertLowerCaseSolutionS1("AaBb"));
        System.out.println(doConvertLowerCaseSolutionS1("AB CD EF"));
        System.out.println(doConvertLowerCaseSolutionS1("CC-DD-EE"));
        System.out.println(doConvertLowerCaseSolutionS1("A1aB2b"));
    }
}
