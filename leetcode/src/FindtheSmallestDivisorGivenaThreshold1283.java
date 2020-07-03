public class FindtheSmallestDivisorGivenaThreshold1283 {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = (int)1e6;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int sum = 0;
            for (int num : nums) {
                sum += (num + mid - 1) / mid;
            }
            if (sum > threshold) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return left;
    }
}
