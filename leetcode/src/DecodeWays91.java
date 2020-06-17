/*
    base case: M[0] = 0, M[1] = s.charAt(0) == '0' ? 0 : 1;
    induction rule: M[i] represents how many ways for number character until i;
    case 1: if s.substring(i - 1, i) can be digit, M[i] += M[i - 1];
    case 2: if s.substriing(i - 2, i) can be digit, M[i] += M[i - 2];
 */
public class DecodeWays91 {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] M = new int[n + 1];
        M[0] = 1;
        M[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first > 0 && first <= 9) {
                M[i] += M[i - 1];
            }
            if (second >= 10 && second <= 26) {
                M[i] += M[i - 2];
            }
        }
        return M[n];
    }
}
