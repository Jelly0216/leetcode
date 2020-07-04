public class PathwithMaximumGold1219 {
    private static final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int getMaximumGold(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[] max = new int[]{Integer.MIN_VALUE};
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    helper(grid, i, j, visited, max, 0);
                }
            }
        }
        return max[0];
    }

    private void helper(int[][] grid, int i, int j, boolean[][] visited, int[] max, int sum) {
        if (!isVaild(i, j, grid.length, grid[0].length) || visited[i][j] || grid[i][j] == 0) {
            return;
        }

        visited[i][j] = true;
        sum += grid[i][j];
        max[0] = Math.max(max[0], sum);
        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            helper(grid, r, c, visited, max, sum);
        }
        visited[i][j] = false;
        sum -= grid[i][j];
    }

    private boolean isVaild(int i, int j, int r, int c) {
        return i >= 0 && i < r && j >= 0 && j < c;
    }
}
