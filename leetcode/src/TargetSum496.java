import java.util.Arrays;

public class TargetSum496 {
    //dfs
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] res = new int[1];
        helper(nums, S, 0, res);
        return res[0];
    }

    private void helper(int[] nums, int S, int index, int[] res) {
        if (index == nums.length) {
            if (S == 0) {
                res[0]++;
            }
            return;
        }

        helper(nums, S - nums[index], index + 1, res);
        helper(nums, S + nums[index], index + 1, res);
    }

    //dfs with memo
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        int[][] memo = new int[nums.length][2001];
        for (int[] row: memo)
            Arrays.fill(row, Integer.MIN_VALUE);
        return calculate(nums, 0, 0, S, memo);
    }
    public int calculate(int[] nums, int i, int sum, int S, int[][] memo) {
        if (i == nums.length) {
            if (sum == S)
                return 1;
            else
                return 0;
        } else {
            if (memo[i][sum + 1000] != Integer.MIN_VALUE) {
                return memo[i][sum + 1000];
            }
            int add = calculate(nums, i + 1, sum + nums[i], S, memo);
            int subtract = calculate(nums, i + 1, sum - nums[i], S, memo);
            memo[i][sum + 1000] = add + subtract;
            return memo[i][sum + 1000];
        }
    }
}
