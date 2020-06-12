/*
used 2d dp array to store the area
M[i][j] means the area from lefttop coner to point(i - 1, j - 1)
 */
public class NumMatrix304 {
    class NumMatrix {
        private int[][] M;
        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                return;
            }
            int m = matrix.length;
            int n = matrix[0].length;
            this.M = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    M[i + 1][j + 1] = M[i][j + 1] + M[i + 1][j] + matrix[i][j] - M[i][j];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return M[row2 + 1][col2 + 1] - M[row1][col2 + 1] - M[row2 + 1][col1] + M[row1][col1];
        }
    }
}
