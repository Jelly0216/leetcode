package gs;

public class HeightChecker1051 {
    public int heightChecker(int[] heights) {
        int[] count = new int[101];
        for (int height : heights) {
            count[height]++;
        }
        int res = 0;
        int currHeight = 0;
        for (int i = 0; i < heights.length; i++) {
            while (currHeight < count.length && count[currHeight] == 0) {
                currHeight++;
            }
            if (currHeight != heights[i]) {
                res++;
            }
            count[currHeight]--;
        }
        return res;
    }
}
