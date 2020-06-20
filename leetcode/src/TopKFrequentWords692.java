import java.util.*;

public class TopKFrequentWords692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            Integer count = map.get(word);
            if (count == null) {
                map.put(word, 1);
            }
            else {
                map.put(word, count + 1);
            }
        }

        PriorityQueue<String> minHeap = new PriorityQueue<>(new Comparator<String>(){
            @Override
            public int compare (String s1, String s2) {
                int count1 = map.get(s1);
                int count2 = map.get(s2);
                if (count1 == count2) {
                    return s2.compareTo(s1);
                }
                return count1 < count2 ? -1 : 1;
            }
        });

        for (String key : map.keySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(key);
            }
            else if (map.get(minHeap.peek()) < map.get(key)) {
                minHeap.poll();
                minHeap.offer(key);
            }
            else if (map.get(minHeap.peek()) == map.get(key)) {
                int compare =  minHeap.peek().compareTo(key);
                if (compare > 0) {
                    minHeap.poll();
                    minHeap.offer(key);
                }
            }
        }
        List<String> res =  new ArrayList<>();
        while (!minHeap.isEmpty()) {
            res.add(minHeap.poll());
        }
        Collections.reverse(res);
        return res;
    }
}
