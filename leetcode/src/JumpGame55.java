public class JumpGame55 {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int n = nums.length;
        boolean[] M = new boolean[n];
        M[0] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (M[j] && nums[j] + j >= i) {
                    M[i] = true;
                    break;
                }
            }
        }
        return M[n - 1];
    }
}
