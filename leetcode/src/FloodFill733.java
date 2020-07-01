public class FloodFill733 {
    private final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) {
            helper(image, sr, sc, color, newColor);
        }
        return image;
    }

    private void helper(int[][] image, int r, int c, int color, int newColor) {
        if (!isVaild(r, c, image.length, image[0].length) || image[r][c] != color) {
            return;
        }

        image[r][c] = newColor;
        for (int[] dir : dirs) {
            int i = dir[0] + r;
            int j = dir[1] + c;
            helper(image, i, j, color, newColor);
        }
    }

    private boolean isVaild(int i, int j, int r, int c) {
        return i >= 0 && i < r && j >= 0 && j < c;
    }
}
