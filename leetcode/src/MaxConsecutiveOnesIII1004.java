public class MaxConsecutiveOnesIII1004 {
    public int longestOnes(int[] A, int K) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int slow = 0;
        int fast = 0;
        int count = 0;
        int globalMax = 0;
        while (fast < A.length) {
            if (A[fast] == 1) {
                globalMax = Math.max(globalMax, ++fast - slow);
            }
            else if (count < K) {
                globalMax = Math.max(globalMax, ++fast - slow);
                count++;
            }
            else if (A[slow++] == 0) {
                count--;
            }
        }
        return globalMax;
    }
}
