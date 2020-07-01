import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberofDistinctIslands694 {
    private final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numDistinctIslands(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        Set<List<Integer>> set = new HashSet<>();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    List<Integer> path = new ArrayList<>();
                    helper(grid, i, j, -1, path, visited);
                    if (!path.isEmpty()) {
                        set.add(path);
                    }
                }
            }
        }
        return set.size();
    }

    private void helper(int[][] grid, int i, int j, int dir, List<Integer> path, boolean[][] visited) {
        if (!isValid(i, j, grid.length, grid[0].length) || visited[i][j] || grid[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
        path.add(dir);
        for (int k = 0; k < dirs.length; k++) {
            int r = i + dirs[k][0];
            int c = j + dirs[k][1];
            helper(grid, r, c, k, path, visited);
        }
        path.add(-1);
    }

    private boolean isValid(int i, int j, int r, int c) {
        return i >= 0 && i < r && j >= 0 && j < c;
    }
}
