public class UniquePathsIII980 {
    private final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int uniquePathsIII(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int zeros = 0;
        int[] start = new int[2];
        int[] end = new int[2];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != -1) {
                    zeros++;
                }

                if (grid[i][j] == 1) {
                    start[0] = i;
                    start[1] = j;
                }

                if (grid[i][j] == 2) {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }

        boolean[][] visited = new boolean[m][n];
        int[] res = new int[1];
        helper(grid, start, end, zeros, res, visited);
        return res[0];
    }

    private void helper(int[][] grid, int[] curr, int[] end, int zeros, int[] res, boolean[][] visited) {
        if (curr[0] == end[0] && curr[1] == end[1]) {
            if (zeros == 1) {
                res[0]++;
            }
            return;
        }
        if (!isVaild(curr[0], curr[1], grid.length, grid[0].length) || visited[curr[0]][curr[1]] || grid[curr[0]][curr[1]] == -1) {
            return;
        }
        visited[curr[0]][curr[1]] = true;
        int[] next = new int[2];
        for (int[] dir : dirs) {
            next[0] = curr[0] + dir[0];
            next[1] = curr[1] + dir[1];
            helper(grid, next, end, zeros - 1, res, visited);
        }
        visited[curr[0]][curr[1]] = false;
    }

    private boolean isVaild(int i, int j, int r, int c) {
        return i >= 0 && i < r && j >= 0 && j < c;
    }
}
