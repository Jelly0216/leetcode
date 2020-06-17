public class IncreasingTripletSubsequence334 {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        boolean[] M = new boolean[n];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] > min) {
                M[i] = true;
            }
            else {
                min = nums[i];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (max > nums[i]) {
                if (M[i]) {
                    return true;
                }
            }
            else {
                max = nums[i];
            }
        }
        return false;
    }
}
