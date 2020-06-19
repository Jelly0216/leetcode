public class LongestContinuousIncreasingSubsequence674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] M = new int[n];
        int res = 1;
        int currMax = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                currMax++;
                res = Math.max(res, currMax);
            }
            else {
                currMax = 1;
            }
        }
        return res;
    }
}
