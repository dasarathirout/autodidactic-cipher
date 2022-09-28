package interview.questions.string.ex11;

public class RedGreen {

    public static void main(String[] args) {
        countMinimumNumberCharactersUpdateTestScenarios();
    }

    public static int countMinimumNumberCharactersUpdateSolutionS1(String inData) {
        int minCount = 0;
        if (inData == null || inData.length() <= 1) {
            return minCount;
        }

        char[] inCharAry = inData.toCharArray();
        int countG = 0;
        int countR = 0;

        for (int i = 0; i < inData.length(); i++) {
            switch (inCharAry[i]) {
                case 'G':
                    countG++;
                    break;
                case 'R':
                    countR++;
                    break;
            }
        }
        if (countG == 0) {
            return countG;
        }
        if (countR == 0) {
            return countR;
        }
        minCount = Math.min(countG,countR);
        return minCount;
    }

    public static void countMinimumNumberCharactersUpdateTestScenarios() {
        System.out.println("" + countMinimumNumberCharactersUpdateSolutionS1(null));
        System.out.println("" + countMinimumNumberCharactersUpdateSolutionS1(""));
        System.out.println("" + countMinimumNumberCharactersUpdateSolutionS1("R"));
        System.out.println("" + countMinimumNumberCharactersUpdateSolutionS1("G"));

        System.out.println("" + countMinimumNumberCharactersUpdateSolutionS1("RR"));
        System.out.println("" + countMinimumNumberCharactersUpdateSolutionS1("GG"));

        System.out.println("" + countMinimumNumberCharactersUpdateSolutionS1("RGR"));
        System.out.println("" + countMinimumNumberCharactersUpdateSolutionS1("GRG"));
    }
}
