public class WildcardMatching {

    public static boolean isMatch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        // dp[i][j] → pattern[0..i-1] matches text[0..j-1]
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Empty pattern and empty text match
        dp[0][0] = true;

        // If pattern starts with '*', it can match empty string
        for (int i = 1; i <= m; i++) {
            if (pattern.charAt(i - 1) == '*') {
                dp[i][0] = dp[i - 1][0];
            }
        }

        // Fill the table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char p = pattern.charAt(i - 1);
                char t = text.charAt(j - 1);

                if (p == t || p == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String pattern1 = "a*e";
        System.out.println(isMatch(text1, pattern1)); // true

        String text2 = "abc";
        String pattern2 = "a?c";
        System.out.println(isMatch(text2, pattern2)); // true

        String text3 = "abcd";
        String pattern3 = "a*c?";
        System.out.println(isMatch(text3, pattern3)); // false

        String text4 = "mississippi";
        String pattern4 = "m*iss*ppi";
        System.out.println(isMatch(text4, pattern4)); // true
    }
}
