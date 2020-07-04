public class SplitArrayLargestSum410 {
    public int splitArray(int[] nums, int m) {
        long left = 0;
        long right = 0;
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        while (left <= right) {
            long mid = left + (right - left) / 2;
            int curr = 0;
            int needed = 1;
            for (int num : nums) {
                if (curr + num > mid) {
                    needed++;
                    curr = 0;
                }
                curr += num;
            }
            if (needed > m) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return (int)left;
    }
}
