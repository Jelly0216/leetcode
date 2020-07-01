import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianfromDataStream295 {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    /** initialize your data structure here. */
    public FindMedianfromDataStream295() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() > num) {
            maxHeap.offer(num);
        }
        else {
            minHeap.offer(num);
        }

        if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.offer(maxHeap.poll());
        }
        else if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.isEmpty() && minHeap.isEmpty()) {
            return 0;
        }
        int size = maxHeap.size() + minHeap.size();
        if (size % 2 == 0) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        else {
            return (double) maxHeap.peek();
        }
    }
}
