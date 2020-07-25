public class MaximalSquare221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] M = new int[m + 1][n + 1];
        int res = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    M[i][j] = Math.min(M[i - 1][j] + 1, M[i][j - 1] + 1);
                    M[i][j] = Math.min(M[i - 1][j - 1] + 1, M[i][j]);
                    res = Math.max(res, M[i][j]);
                }
            }
        }
        return res * res;
    }
}
