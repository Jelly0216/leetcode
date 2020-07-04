public class PathWithMaximumMinimumValue1102 {
    public int maximumMinimumPath(int[][] A) {
        if (A.length == 0 || A[0].length == 0) {
            return -1;
        }
        final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int m = A.length;
        int n = A[0].length;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a1, int[] a2) {
                int score1 = getScore(A, a1[0], a1[1]);
                int score2 = getScore(A, a2[0], a2[1]);
                if (score1 == score2) {
                    return 0;
                }
                return score1 > score2 ? -1 : 1;
            }
        });
        maxHeap.offer(new int[]{0, 0});
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        int res = A[0][0];
        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            res = Math.min(res, getScore(A, curr[0], curr[1]));
            if (curr[0] == m - 1 && curr[1] == n - 1) {
                return res;
            }
            for (int[] dir : dirs) {
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                if (isValid(r, c, m, n) && !visited[r][c]) {
                    maxHeap.offer(new int[]{r, c});
                    visited[r][c] = true;
                }
            }
        }
        return res;
    }

    private int getScore(int[][] A, int i, int j) {
        return A[i][j];
    }

    private boolean isValid(int i, int j, int r, int c) {
        return i >= 0 && i < r && j >= 0 && j < c;
    }
}
