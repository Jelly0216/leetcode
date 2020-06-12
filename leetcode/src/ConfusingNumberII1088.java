import java.util.Map;

public class ConfusingNumberII1088 {
    public int confusingNumberII(int N) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        map.put(1, 1);
        map.put(6, 9);
        map.put(9, 6);
        map.put(8, 8);
        int[] res = new int[1];
        for (int n : map.keySet()) {
            if (n == 0) {
                continue;
            }
            helper(N, n, map, res);
        }
        return res[0];
    }

    private void helper(int N, int curr, Map<Integer, Integer> map, int[] res) {
        if (curr > N) {
            return;
        }
        if (isConfusing(curr, map)) {
            res[0]++;
        }
        for (int next : map.keySet()) {
            helper(N, 10 * curr + next, map, res);
        }
    }

    private boolean isConfusing(int n, Map<Integer, Integer> map) {
        int curr = n;
        int rev = 0;
        while (curr > 0) {
            int mod = curr % 10;
            if (!map.containsKey(mod)) {
                return false;
            }
            rev = rev * 10 + map.get(mod);
            curr /= 10;
        }
        return rev != n;
    }
}
