public class ShuffleanArray384 {
    private int[] nums;
    private Random rand;
    private int[] original;
    public Solution(int[] nums) {
        this.nums = nums;
        this.original = nums.clone();
        this.rand = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        nums = original;
        original = original.clone();
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < nums.length; i++) {
            int j = rand.nextInt(nums.length - i) + i;
            swap(nums, i, j);
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
