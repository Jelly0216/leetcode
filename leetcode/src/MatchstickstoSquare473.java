public class MatchstickstoSquare473 {
    // 4 level, each level n branchs
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 4 != 0) {
            return false;
        }
        boolean[] visited = new boolean[nums.length];
        return helper(nums, 4, 0, 0, sum / 4, visited);
    }

    private boolean helper(int[] nums, int k, int startIndex, int currSum, int target, boolean[] visited) {
        if (k == 0) {
            return true;
        }
        if (currSum == target) {
            return helper(nums, k - 1, 0, 0, target, visited);
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (!visited[i] && currSum + nums[i] <= target) {
                visited[i] = true;
                if (helper(nums, k, i + 1, currSum + nums[i], target, visited)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }

    // n levels, each level 4 branches
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 4 != 0) {
            return false;
        }
        int[] sums = new int[4];
        return helper(nums, sums, 0, sum / 4);
    }

    private boolean helper(int[] nums, int[] sums, int index, int target) {
        if (index == nums.length) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            if (sums[i] + nums[index] <= target) {
                sums[i] += nums[index];
                if (helper(nums, sums, index + 1, target)) {
                    return true;
                }
                sums[i] -= nums[index];
            }
        }
        return false;
    }
}
