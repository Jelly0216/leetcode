import java.util.Arrays;

public class CoinChange332 {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] M = new int[amount + 1];
        Arrays.fill(M, max);
        M[0] = 0;
        for (int i = 1; i <= amount; i++){
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    M[i] = Math.min(M[i], M[i - coins[j]] + 1);
                }
            }
        }
        return M[amount]  > amount ? - 1: M[amount];
    }
}
