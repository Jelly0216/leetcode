import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMedian480 {
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length - k + 1;
        double[] res = new double[n];
        for (int i = 0; i <= nums.length; i++) {
            if (i >= k) {
                res[i - k] = getMedian();
                remove(nums[i - k]);
            }
            if (i < nums.length) {
                add(nums[i]);
            }
        }
        return res;
    }

    private void add(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
        }
        else {
            minHeap.offer(num);
        }

        if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.offer(maxHeap.poll());
        }
        else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    private void remove(int num) {
        if (num <= maxHeap.peek()) {
            maxHeap.remove(num);
        }
        else {
            minHeap.remove(num);
        }

        if (maxHeap.size() - minHeap.size() > 1) {
            minHeap.offer(maxHeap.poll());
        }
        else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    private double getMedian() {
        int size = minHeap.size() + maxHeap.size();
        if (size == 0) {
            return 0;
        }
        if (size % 2 == 0) {
            return ((double)maxHeap.peek() + (double)minHeap.peek()) / 2.0;
        }
        else {
            return (double)(maxHeap.peek());
        }
    }

}
