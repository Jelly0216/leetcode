public class SpiralMatrix54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (left < right && up < down) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }

            for (int i = up + 1; i <= down - 1; i++) {
                res.add(matrix[i][right]);
            }

            for (int i = right; i >= left; i--) {
                res.add(matrix[down][i]);
            }

            for (int i = down - 1; i >= up + 1; i--) {
                res.add(matrix[i][left]);
            }
            up++;
            down--;
            left++;
            right--;
        }
        if (left == right) {
            for (int i = up; i <= down; i++) {
                res.add(matrix[i][left]);
            }
        }
        else if (up == down) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }
        }
        return res;
    }
}
