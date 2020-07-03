public class MinimumNumberofDaystoMakemBouquets1482 {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int left = 1;

        int right = (int) 1e9;
        if (m * k > n) {
            return -1;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int flower = 0;
            int bouq = 0;
            for (int i = 0; i < n; i++) {
                if (bloomDay[i] > mid) {
                    flower = 0;
                }
                else if (++flower >= k) {
                    bouq++;
                    flower = 0;
                }
            }
            if (bouq < m) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return left;
    }
}
