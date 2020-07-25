import java.util.HashMap;
import java.util.Map;

public class DegreeofanArray697 {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> first = new HashMap<>();
        int res = 0;
        int degree = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!first.containsKey(nums[i])) {
                first.put(nums[i], i);
            }
            Integer count = map.get(nums[i]);
            if (count == null) {
                map.put(nums[i], 1);
            }
            else {
                map.put(nums[i], count + 1);
            }

            if (map.get(nums[i]) > degree) {
                degree = map.get(nums[i]);
                res = i - first.get(nums[i]) + 1;
            }
            else if (map.get(nums[i]) == degree) {
                res = Math.min(res, i - first.get(nums[i]) + 1);
            }
        }
        return res;
    }
}
