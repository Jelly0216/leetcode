import java.util.ArrayDeque;
import java.util.Queue;
// distance[i][j] represents sum of distance of (i, j) to buildings
//reach[i][j] represents the num of building point i,j can reach
public class ShortestDistancefromAllBuildings317 {
    private final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] distance = new int[m][n];
        int[][] reach = new int[m][n];
        int building = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    helper(grid, i, j, distance, reach);
                    building++;
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && reach[i][j] == building) {
                    res = Math.min(res, distance[i][j]);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void helper(int[][] grid, int i, int j, int[][] distance, int[][] reach) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i, j});
        boolean[][] visited = new boolean[m][n];
        int level = 1;
        visited[i][j] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] curr = q.poll();
                for (int[] dir : dirs) {
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    if (isVaild(r, c, m, n) && grid[r][c] == 0 && !visited[r][c]) {
                        q.offer(new int[]{r, c});
                        distance[r][c] += level;
                        reach[r][c]++;
                        visited[r][c] = true;
                    }
                }
            }
            level++;
        }
    }

    private boolean isVaild(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
