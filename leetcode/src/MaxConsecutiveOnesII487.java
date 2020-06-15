public class MaxConsecutiveOnesII487 {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        boolean zero = false;
        int slow = 0;
        int fast = 0;
        int globalMax = 0;
        while (fast < nums.length) {
            if (nums[fast] == 1) {
                globalMax = Math.max(globalMax, fast - slow + 1);
                fast++;
            }
            else if (!zero) {
                globalMax = Math.max(globalMax, fast - slow + 1);
                fast++;
                zero = true;
            }
            else if (nums[slow++] == 0){
                zero = false;
            }
        }
        return globalMax;
    }
}
