public class PartitiontoKEqualSumSubsets698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        boolean[] visited = new boolean[nums.length];
        return helper(nums, k, 0, 0,  sum / k, visited);
    }

    private boolean helper(int[] nums, int k, int startIndex, int currSum, int subSum, boolean[] visited) {
        if (k == 1) {
            return true;
        }
        if (currSum == subSum) {
            return helper(nums, k - 1, 0, 0, subSum, visited);
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if(helper(nums, k, i + 1, currSum + nums[i], subSum, visited)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}
