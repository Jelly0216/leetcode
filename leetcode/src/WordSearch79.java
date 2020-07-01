public class WordSearch79 {
    private final int[][] options = new int[][]{{1,0}, {-1, 0}, {0,1}, {0,-1}};
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (helper(board, word, i, j, visited, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, int i, int j, boolean[][] visited, int index) {
        if (index == word.length()) {
            return true;
        }
        if (!isVaild(i, j, board.length, board[0].length) || board[i][j] != word.charAt(index) || visited[i][j]) {
            return false;
        }

        visited[i][j] = true;
        for (int[] option : options) {
            int r = i + option[0];
            int c = j + option[1];
            if (helper(board, word, r, c, visited, index + 1)) {
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }

    private boolean isVaild(int i, int j, int row, int col) {
        return i >= 0 && i < row && j >= 0 && j < col;
    }
}
