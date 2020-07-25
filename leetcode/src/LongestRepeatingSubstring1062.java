public class LongestRepeatingSubstring1062 {
    public int longestRepeatingSubstring(String S) {
        int n = S.length();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = S.charAt(i) - 'a';
        }
        int a = 26;
        long modules = (long)Math.pow(2, 24);
        int left = 1;
        int right = n;
        int L;
        while (left <= right) {
            L = left + (right - left) / 2;
            if (search(L, a, modules, n, nums) != -1) {
                left = L + 1;
            }
            else {
                right = L - 1;
            }
        }
        return left - 1;
    }

    private int search(int L, int a, long modulus, int n, int[] nums) {
        long h = 0;
        for (int i = 0; i < L; i++) {
            h = (h * a + nums[i]) % modulus;
        }
        Set<Long> visited = new HashSet<>();
        visited.add(h);
        long aL = 1;
        for (int i = 1; i <= L; i++) {
            aL = (aL * a) % modulus;
        }
        for (int start = 1; start < n - L + 1; start++) {
            h = (h * a - nums[start - 1] * aL % modulus + modulus) % modulus;
            h = (h + nums[start + L - 1]) % modulus;
            if (visited.contains(h)) {
                return start;
            }
            visited.add(h);
        }
        return -1;
    }
}
