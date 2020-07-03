public class CapacityToShipPackagesWithinDDays1011 {
    public int shipWithinDays(int[] weights, int D) {
        int left = 0;
        int right = 0;
        for (int num : weights) {
            left = Math.max(left, num);
            right += num;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int need = 1;
            int curr = 0;
            for (int w : weights) {
                if (curr + w > mid) {
                    need += 1;
                    curr = 0;
                }
                curr += w;
            }
            if (need > D) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return left;
    }
}
