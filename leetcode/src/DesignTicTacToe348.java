class TicTacToe {
    private int[] rows;
    private int[] cols;
    private int diag;
    private int revDiag;
    private int n;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.rows = new int[n];
        this.cols = new int[n];
        this.diag = 0;
        this.revDiag = 0;
        this.n = n;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {

        int count = player == 1 ? 1 : -1;
        rows[row] += count;
        cols[col] += count;
        if (row == col) {
            diag += count;
        }
        if (row + col == n - 1) {
            revDiag += count;
        }
        if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diag) == n || Math.abs(revDiag) == n) {
            return player;
        }
        return 0;
    }
}