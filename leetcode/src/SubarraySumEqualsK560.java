public class SubarraySumEqualsK560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int res = 0;
        map.put(sum, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            Integer count = map.get(sum);
            if (count == null) {
                map.put(sum, 1);
            }
            else {
                map.put(sum, count + 1);
            }
        }
        return res;
    }
}
