public class KokoEatingBananas875 {
    public int minEatingSpeed(int[] piles, int H) {
        int left = 1;
        int right = (int)1e9;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int sum = 0;
            for (int p : piles) {
                sum += (p + mid - 1) / mid;
            }
            if (sum > H) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return left;
    }
}
