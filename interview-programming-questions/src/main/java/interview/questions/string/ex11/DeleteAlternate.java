package interview.questions.string.ex11;

public class DeleteAlternate {
    public static void main(String[] args) {
        deleteTestScenarios();
    }

    public static String alternateCharactersDelete(String inData) {
        String resultData = "";
        char[] inCharAry = inData.toCharArray();
        for (int i = 0; i < inData.length(); i += 2) {
            resultData += inCharAry[i];
        }
        return resultData;
    }

    public static void deleteTestScenarios() {
        System.out.println(alternateCharactersDelete("0"));
        System.out.println(alternateCharactersDelete("01"));
        System.out.println(alternateCharactersDelete("012"));
        System.out.println(alternateCharactersDelete("0124"));
        System.out.println(alternateCharactersDelete("01245"));
    }
}
