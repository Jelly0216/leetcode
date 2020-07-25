public class MinimumSizeSubarraySum209 {
    public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        int sum = 0;
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            sum += nums[fast];
            while (sum >= s) {
                res = Math.min(res, fast - slow + 1);
                sum -= nums[slow++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
