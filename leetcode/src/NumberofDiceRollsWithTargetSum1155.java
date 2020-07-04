public class NumberofDiceRollsWithTargetSum1155 {
    public int numRollsToTarget(int d, int f, int target) {
        int MOD = (int)1e9 + 7;
        int[][] M = new int[d + 1][target + 1];
        M[0][0] = 1;
        for (int i = 1; i <= d; i++) {
            for (int j = 1; j <= target; j++) {
                if (j > i * f) {
                    continue;
                }
                else {
                    for (int k = 1; k <= f && k <= j; k++) {
                        M[i][j] = (M[i][j] + M[i - 1][j - k]) % MOD;
                    }
                }
            }
        }
        return M[d][target];
    }
}
