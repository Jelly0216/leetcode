/*
*
* used dir to track direction
* each time to go to new matrix
* case1: if row >= matrix.length: row = m - 1, col += 2, change dir
* case2: if col >= matrix[0].length: col = n - 1, row += 2, change dir
* case3: if row == 0: change dir
* case4: if col < 0, change dir
* case5: just go with current direction
* */


public class DiagonalTraverse498 {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m * n];
        int row = 0;
        int col = 0;
        int dir = 0;
        int[][] dirs = new int[][]{{-1, 1}, {1, -1}};
        for (int i = 0; i < m * n; i++) {
            res[i] = matrix[row][col];
            row += dirs[dir][0];
            col += dirs[dir][1];
            if (row >= m) {
                row = m - 1;
                col += 2;
                dir = 1 - dir;
            }
            else if (col >= n) {
                col = n - 1;
                row += 2;
                dir = 1 - dir;
            }
            else if (row < 0) {
                row = 0;
                dir = 1 - dir;
            }
            else if (col < 0) {
                col = 0;
                dir = 1 - dir;
            }

        }
        return res;
    }
}
