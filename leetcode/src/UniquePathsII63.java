public class UniquePathsII63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] M = new int[m][n];
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        M[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                M[i][0] = M[i - 1][0];
            }
            else {
                break;
            }
        }

        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 0) {
                M[0][j] = M[0][j - 1];
            }
            else {
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    M[i][j] = M[i - 1][j] + M[i][j - 1];
                }
            }
        }
        return M[m - 1][n - 1];
    }
}
