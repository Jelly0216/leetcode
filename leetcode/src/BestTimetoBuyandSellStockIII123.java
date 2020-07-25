public class BestTimetoBuyandSellStockIII123 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        int[][] M = new int[3][n];
        for (int i = 1; i <= 2; i++) {
            int tempMax = -prices[0];
            for (int j = 1; j < n; j++) {
                M[i][j] = Math.max(M[i][j - 1], prices[j] + tempMax);
                tempMax =  Math.max(tempMax, M[i - 1][j - 1] - prices[j]);
            }
        }
        return M[2][n - 1];
    }
}
