/*
    use depth first search to traverse graph, if no more adjencent 'X', count++ for one more battleship
 */


public class BattleshipsInaBoard419 {
    private final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int countBattleships(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return 0;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X' && !visited[i][j]) {
                    helper(board, i, j, visited);
                    res++;
                }
            }
        }
        return res;
    }

    private void helper(char[][] board, int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            if (isVaild(r, c, board.length, board[0].length) && !visited[r][c] && board[r][c] == 'X') {
                helper(board, r, c, visited);
            }
        }
    }

    private boolean isVaild(int r, int c, int m, int n) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }
}
