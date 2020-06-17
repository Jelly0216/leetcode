public class DecodeWaysII639 {
    public int numDecodings(String s) {
        final int mod = 1000000007;
        long[] M = new long[s.length() + 1];
        M[0] = 1;
        M[1] = s.charAt(0) == '*' ? 9 : s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                M[i + 1] = 9 * M[i];
                if (s.charAt(i - 1) == '1') {
                    M[i + 1] = (M[i + 1] + 9 * M[i - 1]) % mod;
                }
                else if (s.charAt(i - 1) == '2') {
                    M[i + 1] = (M[i + 1] + 6 * M[i - 1]) % mod;
                }
                else if (s.charAt(i - 1) == '*') {
                    M[i + 1] = (M[i + 1] + 15 * M[i - 1]) % mod;
                }
            }
            else {
                M[i + 1] = s.charAt(i) != '0' ? M[i] : 0;
                if (s.charAt(i - 1) == '1') {
                    M[i + 1] = (M[i + 1] + M[i - 1]) % mod;
                }
                else if (s.charAt(i - 1) == '2' && s.charAt(i) <= '6') {
                    M[i + 1] = (M[i + 1] + M[i - 1]) % mod;
                }
                else if (s.charAt(i - 1) == '*') {
                    M[i + 1] = (M[i + 1] + (s.charAt(i) <= '6' ? 2 : 1) * M[i - 1]) % mod;
                }
            }
        }
        return (int) M[s.length()];
    }
}
