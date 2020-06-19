import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElementI496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peekFirst()) {
                map.put(stack.pollFirst(), nums2[i]);
            }
            stack.offerFirst(nums2[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (!map.containsKey(nums2[i])) {
                map.put(nums2[i], -1);
            }
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
