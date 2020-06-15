/*
M[i][j] represents the minimum action to from letter is in word1 to letter j in word2
Base case: for word1, it needs j times to delete char to become word2;
induction rule:
case0: if one.charAt(i - 1) == two.charAt(j - 1) keep the same M[i][j] = M[i - 1][j - 1]
case1: The min of three action: delete, add, replace:M[i][j - 1] + 1, M[i - 1][j] + 1, M[i - 1][j - 1] + 1
 */

public class EditDistance72 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] M = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    M[i][j] = j;
                }
                else if (M[i][j] == j) {
                    M[i][j] = i;
                }
                else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    M[i][j] = M[i - 1][j - 1];
                }
                else {
                    M[i][j] = Math.min(M[i - 1][j] + 1, M[i][j - 1] + 1);
                    M[i][j] = Math.min(M[i][j], M[i - 1][j - 1] + 1);
                }
            }
        }
        return M[m][n];
    }
}
