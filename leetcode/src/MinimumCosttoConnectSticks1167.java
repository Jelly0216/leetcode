public class MinimumCosttoConnectSticks1167 {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int stick : sticks) {
            minHeap.offer(stick);
        }
        int res = 0;
        while (minHeap.size() > 1) {
            int cost = minHeap.poll() + minHeap.poll();
            res += cost;
            minHeap.offer(cost);
        }
        return res;
    }
}
