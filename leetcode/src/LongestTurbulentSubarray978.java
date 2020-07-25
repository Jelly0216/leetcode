public class LongestTurbulentSubarray978 {
    public int maxTurbulenceSize(int[] A) {
        int globalMax = 1;
        int left = 0;
        for (int i = 1; i < A.length; i++) {
            int currSign = Integer.compare(A[i - 1], A[i]);
            if (currSign == 0) {
                left = i;
            }
            else if (i == A.length - 1 || currSign * Integer.compare(A[i], A[i + 1]) != -1) {
                globalMax = Math.max(globalMax, i - left + 1);
                left = i;
            }
        }
        return globalMax;

    }
}
