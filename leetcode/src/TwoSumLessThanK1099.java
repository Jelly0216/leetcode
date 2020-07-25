public class TwoSumLessThanK1099 {
    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
        int left = 0;
        int right = A.length - 1;
        int res = -1;
        while (left < right) {
            int temp = A[left] + A[right];
            if (temp < K) {
                res = Math.max(res, temp);
                left++;
            }
            else {
                right--;
            }
        }
        return res;
    }
}
