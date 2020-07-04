public class ShortestPathinBinaryMatrix1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int m = grid.length;
        if (grid[0][0] == 1 || grid[m - 1][m - 1] == 1) {
            return -1;
        }
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][m];
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        int res = 0;
        while (!q.isEmpty()) {
            res++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                if (curr[0] == m - 1 && curr[1] == m - 1) {
                    return res;
                }
                for (int[] dir : dirs) {
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    if (isValid(r, c, m, m) && grid[r][c] == 0 && !visited[r][c]) {
                        q.offer(new int[]{r, c});
                        visited[r][c] = true;
                    }
                }
            }
        }
        return -1;
    }

    private boolean isValid(int i, int j, int r, int c) {
        return i >= 0 && i < r && j >= 0 && j < c;
    }
}
