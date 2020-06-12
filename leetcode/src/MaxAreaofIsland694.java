public class MaxAreaofIsland694 {
    private static final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int[] currSum = new int[1];
                    helper(grid, i, j, visited, currSum);
                    res = Math.max(res, currSum[0]);
                }
            }
        }
        return res;
    }

    private void helper(int[][] grid, int i, int j, boolean[][] visited, int[] currSum) {
        if (!isVaild(i, j, grid.length, grid[0].length) || visited[i][j] || grid[i][j] != 1)  {
            return;
        }

        visited[i][j] = true;
        currSum[0]++;
        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            helper(grid, r, c, visited, currSum);
        }
    }

    private boolean isVaild(int i, int j, int r, int c) {
        return i >= 0 && i < r && j >= 0 && j < c;
    }
}
