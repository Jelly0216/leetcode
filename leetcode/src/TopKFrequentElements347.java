/*
傻逼leetcode还能改signature意思是？？
 */
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements347 {
    public int[] topKFrequent(int[] nums, int k) {
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
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>(){
            @Override
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                if (e1.getValue() == e2.getValue()) {
                    return 0;
                }
                return e1.getValue() < e2.getValue() ? -1 : 1;
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            }
            else if (minHeap.peek().getValue() < entry.getValue()) {
                minHeap.poll();
                minHeap.offer(entry);
            }
        }
        int size = minHeap.size();
        int[] res = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            res[i] = minHeap.poll().getKey();
        }
        return res;

    }
}
