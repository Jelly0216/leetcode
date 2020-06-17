public class SquaresofaSortedArray977 {
    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        int left = 0;
        int right = A.length - 1;
        int index = A.length - 1;
        while (left <= right) {
            int lSquare = A[left] * A[left];
            int rSquare = A[right] * A[right];
            if (lSquare > rSquare) {
                res[index--] = lSquare;
                left++;
            }
            else {
                res[index--] = rSquare;
                right--;
            }
        }
        return res;
    }
}
