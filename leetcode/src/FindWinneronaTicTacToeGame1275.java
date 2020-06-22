public class FindWinneronaTicTacToeGame1275 {
    public String tictactoe(int[][] moves) {
        int[] rows = new int[3];
        int[] cols = new int[3];
        int diag = 0;
        int revDiag = 0;
        for (int i = 0; i < moves.length; i++) {
            int player = i % 2 == 0 ? 1 : -1;
            int r = moves[i][0];
            int c = moves[i][1];
            rows[r] += player;
            cols[c] += player;
            if (r == c) {
                diag += player;
            }
            if (r + c == 2) {
                revDiag += player;
            }
            if (Math.abs(rows[r]) == 3 || Math.abs(cols[c]) == 3 || Math.abs(diag) == 3 || Math.abs(revDiag) == 3) {
                return player == 1 ? "A" : "B";
            }
        }
        if (moves.length == 9) {
            return "Draw";
        }
        return "Pending";
    }
}
