public class FriendCircles547 {
    public int findCircleNum(int[][] M) {
        if (M.length == 0 || M[0].length == 0) {
            return 0;
        }
        int m = M.length;
        int n = M[0].length;
        boolean[] visited = new boolean[m];
        int res = 0;
        for (int i = 0; i < m; i++) {
            if (!visited[i]) {
                helper(M, i, visited);
                res++;
            }
        }
        return res;
    }

    private void helper(int[][] M, int i, boolean[] visited) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                helper(M, j, visited);
            }
        }
    }
}
