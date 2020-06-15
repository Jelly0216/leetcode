import java.util.ArrayDeque;
import java.util.Queue;
/*
    1. use dfs to find the first island
    2. use bfs to find shortest path to another island
 */
public class ShortestBridge934 {
    private final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int shortestBridge(int[][] A) {
        if (A.length == 0 || A[0].length == 0) {
            return 0;
        }
        int m = A.length;
        int n = A[0].length;
        boolean found = false;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            if (found) {
                break;
            }
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    helper(A, i, j, visited, q);
                    found = true;
                    break;
                }
            }
        }
        int res = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] dir : dirs) {
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    if (isVaild(r, c, m, n) && !visited[r][c]) {
                        if (A[r][c] == 1) {
                            return  res;
                        }
                        q.offer(new int[]{r, c});
                        visited[r][c] = true;
                    }
                }
            }
            res++;
        }
        return res;
    }


    private void helper(int[][] A, int i, int j, boolean[][] visited, Queue<int[]> q) {
        if (!isVaild(i, j, A.length, A[0].length) || visited[i][j] || A[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
        q.offer(new int[]{i, j});
        for (int[] dir : dirs) {
            helper(A, i + dir[0], j + dir[1], visited, q);
        }
    }

    private boolean isVaild(int i, int j, int r, int c) {
        return i >= 0 && i < r && j >= 0 && j < c;
    }
}
