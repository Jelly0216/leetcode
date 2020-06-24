public class TrappingRainWater42 {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        int i = 0;
        int j = height.length - 1;
        int res = 0;
        while (i <= j) {
            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax, height[j]);
            if (leftMax < rightMax) {
                res += leftMax - height[i];
                i++;
            }
            else {
                res += rightMax - height[j];
                j--;
            }
        }
        return res;
    }
}
