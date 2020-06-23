public class LongestPalindromicSubstring5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int n = s.length();
        boolean[][] M = new boolean[n][n];
        int max = 0;
        int start = 0;
        int end = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j + 1 <= 3 || M[j + 1][i - 1])) {
                    M[j][i] = true;
                    if (i - j + 1 > max) {
                        max = i - j + 1;
                        start = j;
                        end = i;
                    }
                }

            }
        }
        return s.substring(start, end + 1);
    }
}
