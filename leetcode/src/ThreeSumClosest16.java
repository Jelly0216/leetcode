import java.util.Arrays;

public class ThreeSumClosest16 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i <= nums.length - 3; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int temp = nums[i] + nums[left] + nums[right];
                if (temp == target) {
                    return temp;
                }
                if (Math.abs(target - temp) < diff) {
                    diff = Math.abs(target - temp);
                    res = temp;
                }
                if (temp < target) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return res;
    }
}
