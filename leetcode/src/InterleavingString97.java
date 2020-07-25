public class InterleavingString97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int[][] M = new int[s1.length()][s2.length()];
        return helper(s1, 0, s2, 0, s3, 0, M);
    }

    private boolean helper(String s1, int i, String s2, int j, String s3, int k, int[][] M) {
        if (i == s1.length()) {
            return s2.substring(j).equals(s3.substring(k));
        }

        if (j == s2.length()) {
            return s1.substring(i).equals(s3.substring(k));
        }

        if (M[i][j] != 0)   {
            return M[i][j] == 1 ? true : false;
        }

        boolean res = false;
        if (s3.charAt(k) == s1.charAt(i) && helper(s1, i + 1, s2, j, s3, k + 1, M) ||
                s3.charAt(k) == s2.charAt(j) && helper(s1, i, s2, j + 1, s3, k + 1, M)) {
            res = true;
        }
        M[i][j] = res ? 1: -1;
        return res;
    }
}
