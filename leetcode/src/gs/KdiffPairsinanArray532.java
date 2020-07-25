package gs;

import java.util.HashMap;
import java.util.Map;

public class KdiffPairsinanArray532 {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.get(num);
            if (count == null) {
                map.put(num, 1);
            }
            else {
                map.put(num, count + 1);
            }
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (k > 0 && map.containsKey(key + k)) {
                res++;
            }
            else if (k == 0 && value > 1) {
                res++;
            }
        }
        return res;
    }
}
