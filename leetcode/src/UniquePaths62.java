import java.util.Arrays;

public class UniquePaths62 {
    public int uniquePaths(int m, int n) {
        int[][] M = new int[m][n];
        for (int[] array : M) {
            Arrays.fill(array , 1);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                M[i][j] = M[i - 1][j] + M[i][j - 1];
            }
        }
        return M[m - 1][n - 1];
    }
}
