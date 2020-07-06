public class BestMeetingPoint296 {
    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int minTotalDistance(int[][] grid) {
        int res = Integer.MAX_VALUE;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int curr = helper(grid, i, j);
                res = Math.min(res, curr);
            }
        }
        return res;
    }

    private int helper(int[][] grid, int i, int j) {
        Queue<Point> q = new ArrayDeque<>();
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        q.offer(new Point(i, j, 0));
        visited[i][j] = true;
        int total = 0;
        while (!q.isEmpty()) {
            Point curr = q.poll();
            int r = curr.row;
            int c = curr.col;
            int d = curr.distance;
            if (grid[r][c] == 1) {
                total += d;
            }
            for (int[] dir : dirs) {
                int nextR = r + dir[0];
                int nextC = c + dir[1];
                if (isValid(nextR, nextC, m, n) && !visited[nextR][nextC]) {
                    visited[nextR][nextC] = true;
                    q.offer(new Point(nextR, nextC, d + 1));
                }
            }
        }
        return total;
    }

    private boolean isValid(int i, int j, int r, int c) {
        return i >= 0 && i < r && j >= 0 && j < c;
    }

    private static class Point {
        int row;
        int col;
        int distance;
        Point(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }
}
