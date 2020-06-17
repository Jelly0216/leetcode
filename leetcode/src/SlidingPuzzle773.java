public class SlidingPuzzle773 {
    public int slidingPuzzle(int[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return 0;
        }
        final int R = board.length;
        final int C = board[0].length;
        final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Board target = new Board(new int[][]{{1, 2, 3}, {4, 5, 0}});
        Queue<Board> q = new ArrayDeque<>();
        Set<Board> visited = new HashSet<>();
        Board start = null;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == 0) {
                    start = new Board(board, i, j);
                }
            }
        }
        q.offer(start);
        visited.add(start);
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Board curr = q.poll();
                if (curr.equals(target)) {
                    return res;
                }
                for (int[] dir : dirs) {
                    int nextR = curr.zeroR + dir[0];
                    int nextC = curr.zeroC + dir[1];
                    if (isVaild(nextR, nextC, R, C)) {
                        int[][] newBoard = new int[R][C];
                        int col = 0;
                        for (int[] row : curr.board) {
                            newBoard[col++] = row.clone();
                        }
                        newBoard[curr.zeroR][curr.zeroC] = newBoard[nextR][nextC];
                        newBoard[nextR][nextC] = 0;
                        Board nextBoard = new Board(newBoard, nextR, nextC);
                        if (visited.add(nextBoard)) {
                            q.offer(nextBoard);
                        }
                    }
                }
            }
            res++;
        }
        return -1;
    }

    private boolean isVaild(int i, int j, int r, int c) {
        return i >= 0 && i < r && j >= 0 && j < c;
    }



    private static class Board {
        private final static int R = 2;
        private final static int C = 3;

        int zeroR;
        int zeroC;
        int[][] board;

        Board() {
            this.board = new int[R][C];
        }

        Board(int[][] board) {
            this.board = board;
        }

        Board(int[][] board, int i, int j) {
            this.board = board;
            this.zeroR = i;
            this.zeroC = j;
        }
        @Override
        public int hashCode() {
            int code = 0;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    code = 10 * code + board[i][j];
                }
            }
            return code;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Board)) {
                return false;
            }
            Board another = (Board) o;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (this.board[i][j] != another.board[i][j]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
