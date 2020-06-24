import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOranges994 {
    class Solution {
        public int orangesRotting(int[][] grid) {
            final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            if (grid.length == 0 || grid[0].length == 0) {
                return 0;
            }
            int m = grid.length;
            int n = grid[0].length;
            Queue<int[]> q = new ArrayDeque<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2) {
                        q.offer(new int[]{i, j});
                    }
                }
            }
            int res = -1;
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    int[] curr = q.poll();
                    for (int[] dir : dirs) {
                        int r = curr[0] + dir[0];
                        int c = curr[1] + dir[1];
                        if (isValid(r, c, m, n) && grid[r][c] == 1) {
                            q.offer(new int[]{r, c});
                            grid[r][c] = 2;
                        }
                    }
                }
                res++;
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        return -1;
                    }
                }
            }
            return res == -1 ? 0 : res;
        }

        private boolean isValid(int i, int j, int r, int c) {
            return i >= 0 && i < r && j >= 0 && j < c;
        }
}
