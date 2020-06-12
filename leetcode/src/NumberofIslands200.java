public class NumberofIslands200 {
    private final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    helper(grid, i, j, visited);
                    res++;
                }
            }
        }
        return res;
    }

    private void helper(char[][] grid, int i, int j, boolean[][] visited) {
        if (!isVaild(i, j, grid.length, grid[0].length) || visited[i][j] || grid[i][j] != '1') {
            return;
        }

        visited[i][j] = true;
        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            helper(grid, r, c, visited);
        }
    }

    private boolean isVaild(int i, int j, int r, int c) {
        return i >= 0 && i < r && j >= 0 && j < c;
    }
}
