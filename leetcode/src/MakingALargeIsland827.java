import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/*
    1. Explore every island using DFS, count its area, give it an island index and save the result to a {index: area} map.
    2. Loop every cell == 0, check its connected islands and calculate total islands area.
 */
public class MakingALargeIsland827 {
    private int N = 0;
    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int largestIsland(int[][] grid) {
        N = grid.length;
        //DFS every island and give it an index of island
        int index = 3;
        int res = 0;
        Map<Integer, Integer> area = new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    area.put(index, helper(grid, i, j, index));
                    res = Math.max(res, area.get(index++));
                }
            }
        }

        //traverse every 0 cell and count biggest island it can conntect
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> visited = new HashSet<>();
                    int curr = 1;
                    for (int[] dir : dirs) {
                        int r = i + dir[0];
                        int c = j + dir[1];
                        if (!isValid(r, c)) {
                            continue;
                        }
                        index = grid[r][c];
                        if (index > 1 && !visited.contains(index)) {
                            curr += area.get(index);
                            visited.add(index);
                        }
                    }
                    res = Math.max(res, curr);
                }
            }
        }
        return res;
    }

    private boolean isValid(int i, int j) {
        return i >= 0 && i < N && j >= 0 && j < N;
    }

    private int helper(int[][] grid, int i, int j, int index) {
        int area = 0;
        grid[i][j] = index;
        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            if (isValid(r, c) && grid[r][c] == 1) {
                area += helper(grid, r, c, index);
            }
        }
        return area + 1;
    }
}
