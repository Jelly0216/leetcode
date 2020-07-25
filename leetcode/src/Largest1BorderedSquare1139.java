public class Largest1BorderedSquare1139 {
    public int largest1BorderedSquare(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int n = grid.length;
        int[][] left = new int[n + 1][n + 1];
        int[][] up = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (grid[i - 1][j - 1] == 1) {
                    left[i][j] = left[i][j - 1] + 1;
                    up[i][j] = up[i - 1][j] + 1;
                }
            }
        }
        int res = 0;
        int maxLength = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                maxLength = Math.min(left[i][j], up[i][j]);
                while (maxLength >= 1 && (left[i - maxLength + 1][j] < maxLength || up[i][j - maxLength + 1] < maxLength)) {
                    maxLength--;
                }
                res = Math.max(res, maxLength);
            }
        }
        return res == 1 ? 0 : res * res;
    }
}
