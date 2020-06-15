public class MaxConsecutiveOnes485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int globalMax = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                max++;
                globalMax = Math.max(max, globalMax);
            }
            else {
                max = 0;
            }
        }
        return globalMax;
    }
}
