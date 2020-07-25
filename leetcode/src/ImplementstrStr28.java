public class ImplementstrStr28 {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();
        if (n > m) {
            return -1;
        }
        int a = 26;
        long modulus = (long)Math.pow(2, 31);
        long hLong = 0;
        long hShort = 0;
        for (int i = 0; i < n; i++) {
            hLong = (hLong * a + charToInt(haystack, i)) % modulus;
            hShort = (hShort * a + charToInt(needle, i)) % modulus;
        }
        if (hLong == hShort) {
            return 0;
        }
        long aL = 1;
        for (int i = 1; i <= n; i++) {
            aL = (aL * a) % modulus;
        }
        for (int start = 1; start < m - n + 1; start++) {
            hLong = (hLong * a - charToInt(haystack, start - 1) * aL + charToInt(haystack, start + n - 1)) % modulus;
            if (hLong == hShort) {
                return start;
            }
        }
        return -1;
    }

    private int charToInt(String str, int idx) {
        return (int)(str.charAt(idx) - 'a');
    }
}
