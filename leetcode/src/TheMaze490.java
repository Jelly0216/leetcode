import java.util.ArrayDeque;
import java.util.Deque;

public class TheMaze490 {
    //bfs
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze.length == 0 || maze[0].length == 0) {
            return false;
        }
        int m = maze.length;
        int n = maze[0].length;
        final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        q.offer(start);
        visited[start[0]][start[1]] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (curr[0] == destination[0] && curr[1] == destination[1]) {
                return true;
            }
            for (int[] dir : dirs) {
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                while (isValid(r, c, m, n) && maze[r][c] == 0) {
                    r += dir[0];
                    c += dir[1];
                }
                r -= dir[0];
                c -= dir[1];
                if (!visited[r][c]) {
                    q.offer(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }
        return false;
    }

    private boolean isValid(int i, int j, int r, int c) {
        return i >= 0 && i < r && j >= 0 && j < c;
    }
    //dfs
    private static final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze.length == 0 || maze[0].length == 0) {
            return false;
        }
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        if (helper(maze, start[0], start[1], destination, visited)) {
            return true;
        }
        return false;
    }

    private boolean helper(int[][] maze, int i, int j, int[] destination, boolean[][] visited) {
        if (visited[i][j]) {
            return false;
        }
        if (i == destination[0] && j == destination[1]) {
            return true;
        }
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            while (isVaild(r, c, maze.length, maze[0].length) && maze[r][c] == 0) {
                r += dir[0];
                c += dir[1];
            }
            if (helper(maze, r - dir[0], c - dir[1], destination, visited)) {
                return true;
            }
        }
        return false;
    }
}
