public class SnakesandLadders909 {
    public int snakesAndLadders(int[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return 0;
        }
        int n = board.length;
        boolean[] visited = new boolean[n * n];
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        visited[0] = true;
        int res = 0;
        while (!q.isEmpty()) {
            res++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                for (int j = 1; j <= 6; j++) {
                    int next = curr + j;
                    if (next == n * n) {
                        return res;
                    }
                    int nextRow = getRow(next, n);
                    int nextCol = getCol(next, n);
                    if (board[nextRow][nextCol] != -1) {
                        next = board[nextRow][nextCol];
                        if (next == n * n) {
                            return res;
                        }
                        nextRow = getRow(next, n);
                        nextCol = getCol(next, n);
                    }
                    if (!visited[next - 1]) {
                        q.offer(next);
                        visited[next - 1] = true;
                    }
                }
            }
        }
        return -1;
    }


    private int getRow(int next, int n) {
        return n - 1 - (next - 1) / n;
    }

    private int getCol(int next, int n) {
        return ((next - 1) / n) % 2 == 0 ? (next - 1) % n : n - 1 - (next - 1) % n;
    }

}
