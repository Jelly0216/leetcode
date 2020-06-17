import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class TheMazeII505 {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze.length == 0 || maze[0].length == 0) {
            return 0;
        }
        int m = maze.length;
        int n = maze[0].length;
        int[][] distance = new int[m][n];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        distance[start[0]][start[1]] = 0;
        final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        q.offer(start);
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            for (int[] dir : dirs) {
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                int count = 0;
                while (isValid(r, c, m, n) && maze[r][c] == 0) {
                    r += dir[0];
                    c += dir[1];
                    count++;
                }
                r -= dir[0];
                c -= dir[1];
                if (distance[curr[0]][curr[1]] + count < distance[r][c]) {
                    distance[r][c] = distance[curr[0]][curr[1]] + count;
                    q.offer(new int[]{r, c});
                }
            }
        }
        return  distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }

    private boolean isValid(int i, int j, int r, int c) {
        return i >= 0 && i < r && j >= 0 && j < c;
    }
}
