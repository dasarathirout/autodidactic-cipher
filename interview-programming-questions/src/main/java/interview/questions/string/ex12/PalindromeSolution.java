package interview.questions.string.ex12;

public class PalindromeSolution {
    public static void main(String[] arrays) {
        String inPutPalindrome = "";
        solutionBreakPalindrome(inPutPalindrome);

    }

    public static String solutionBreakPalindrome(String inPutPalindrome) {
        if (inPutPalindrome.length() == 1) return "NA";
        for (int i = 0; i < inPutPalindrome.length() / 2; ++i) {
            if (inPutPalindrome.charAt(i) != 'a') {
                return inPutPalindrome.substring(0, i) + 'a' +
                        inPutPalindrome.substring(i + 1);
            }
        }
        return inPutPalindrome.substring(0, inPutPalindrome.length() - 1) + 'b';
    }

    public static void findNonPalindromicString(char s[]) {
        int frequency[] = new int[26];
        int uniquePresence = 0;

        for (int i = 0; i < s.length; i++) {
            if (s[i] != s[0])
                uniquePresence = 1;

            // Update frequency of
            // the current character
            frequency[s[i] - 'a']++;
        }

        // If all characters are same
        if (uniquePresence == 0)
            System.out.println("-1");
        else {

            // Print characters in sorted manner
            for (int i = 0; i < 26; i++)
                for (int j = 0; j < frequency[i]; j++)
                    System.out.print((char) ('a' + i));
        }
    }

}
