public class IslandPerimeter463 {
    private final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private final int[] peri = new int[]{4, 3, 2, 1, 0};
    public int islandPerimeter(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int count = helper(grid, i, j);
                    res += peri[count];
                }
            }
        }
        return res;
    }

    private int helper(int[][] grid, int i, int j) {
        int res = 0;
        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            if (isVaild(r, c, grid.length, grid[0].length) && grid[r][c] == 1) {
                res++;
            }
        }
        return res;
    }

    private boolean isVaild(int i, int j, int r, int c) {
        return i >= 0 && i < r && j >= 0 && j < c;
    }
}
