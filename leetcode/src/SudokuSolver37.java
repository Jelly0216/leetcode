public class SudokuSolver37 {
    private char[][] board;
    private final int n = 3;
    private final int N = n * n;
    private int[][] rows = new int[N][N + 1];
    private int[][] cols = new int[N][N + 1];
    private int[][] boxes = new int[N][N + 1];
    private boolean solved;
    public void solveSudoku(char[][] board) {
        this.board = board;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int d = (int)(num - '0');
                    placeNumber(d, i, j);
                }
            }
        }
        helper(0, 0);
    }

    private void helper(int row, int col) {
        if (board[row][col] == '.') {
            for (int d = 1; d < 10; d++) {
                if (couldPlace(d, row, col)) {
                    placeNumber(d, row, col);
                    placeNextNumber(row, col);
                    if (!solved) {
                        removeNumber(d, row, col);
                    }
                }

            }
        }
        else {
            placeNextNumber(row, col);
        }
    }

    private void placeNextNumber(int row, int col) {
        if (row == N - 1 && col == N - 1) {
            solved = true;
        }
        else {
            if (col == N - 1) {
                helper(row + 1, 0);
            }
            else {
                helper(row, col + 1);
            }
        }
    }

    private boolean couldPlace(int d, int row, int col) {
        int index = (row / n) * n + col / n;
        return rows[row][d] + cols[col][d] + boxes[index][d] == 0;
    }

    private void placeNumber(int d, int row, int col) {
        int index = (row / n) * n + col / n;
        rows[row][d]++;
        cols[col][d]++;
        boxes[index][d]++;
        board[row][col] = (char)(d + '0');
    }

    private void removeNumber(int d, int row, int col) {
        int index = (row / n) * n + col / n;
        rows[row][d]--;
        cols[col][d]--;
        boxes[index][d]--;
        board[row][col] = '.';
    }
}
