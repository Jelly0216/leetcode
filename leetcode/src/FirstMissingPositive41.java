public class FirstMissingPositive41 {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1 && nums[i] >= 1 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
            else {
                i++;
            }
        }
        int res = nums.length + 1;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                res = j + 1;
                break;
            }
        }
        return res;
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
