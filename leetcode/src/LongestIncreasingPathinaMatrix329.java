// M[i][j] represents the longest increasing path from i,j
public class LongestIncreasingPathinaMatrix329 {
    private final int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] M = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, helper(matrix, i, j, M));
            }
        }
        return res;
    }

    private int helper(int[][] matrix, int i, int j, int[][] M) {
        if (M[i][j] != 0) {
            return M[i][j];
        }
        for (int[] dir : dirs) {
            int r = dir[0] + i;
            int c = dir[1] + j;
            if (isVaild(r, c, matrix.length, matrix[0].length) && matrix[r][c] > matrix[i][j]) {
                M[i][j] = Math.max(M[i][j], helper(matrix, r, c, M));
            }
        }
        return ++M[i][j];
    }

    private boolean isVaild(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
