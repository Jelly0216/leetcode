public class BulbSwitcherIII1375 {
    public int numTimesAllBlue(int[] light) {
        int right = 0;
        int res = 0;
        for (int i = 0; i < light.length; i++) {
            right = Math.max(right, light[i]);
            if (right == i + 1) {
                res++;
            }
        }
        return res;
    }
}
