public class MeetingScheduler1229 {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a1, int[] a2) {
                if (a1[0] == a2[0]) {
                    return 0;
                }
                return a1[0] < a2[0] ? -1 : 1;
            }
        });
        for (int[] slot : slots1) {
            if (slot[1] - slot[0] >= duration) {
                minHeap.offer(slot);
            }
        }
        for (int[] slot : slots2) {
            if (slot[1] - slot[0] >= duration) {
                minHeap.offer(slot);
            }
        }
        while (minHeap.size() > 1) {
            if (minHeap.poll()[1] >= minHeap.peek()[0] + duration)
                return Arrays.asList(minHeap.peek()[0], minHeap.peek()[0] + duration);
        }
        return new ArrayList<>();
    }
}
