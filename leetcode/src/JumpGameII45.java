public class JumpGameII45 {
    public int jump(int[] nums) {
        int[] M = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            M[i] = -1;
            for (int j = 0; j < i; j++) {
                if (M[j] != -1 && nums[j] + j >= i) {
                    if (M[i] == -1 || M[j] + 1 < M[i]) {
                        M[i] = M[j] + 1;
                    }
                }
            }
        }
        return M[nums.length - 1];
    }
}
