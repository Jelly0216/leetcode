package gs;

public class FriendCircles547 {
    public int findCircleNum(int[][] M) {
        if (M.length == 0 || M[0].length == 0) {
            return 0;
        }
        int n = M.length;
        boolean[] visited = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                helper(M, i, visited);
                res++;
            }
        }
        return res;
    }

    private void helper(int[][] M, int curr, boolean[] visited) {

        visited[curr] = true;
        for (int next = 0; next < M.length; next++) {
            if (M[curr][next] == 1 && !visited[next]) {
                helper(M, next, visited);
            }
        }
    }
}
