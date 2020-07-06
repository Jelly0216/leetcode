public class ValidSudoku36 {
    public boolean isValidSudoku(char[][] board) {
        Set<Integer>[] rows = new HashSet[9];
        Set<Integer>[] cols = new HashSet[9];
        Set<Integer>[] boxes = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = num - '0';
                    int boxIndex = (i / 3) * 3 + j / 3;
                    if (!rows[i].add(n) || !cols[j].add(n) || !boxes[boxIndex].add(n)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
