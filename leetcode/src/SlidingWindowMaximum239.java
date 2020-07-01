public class SlidingWindowMaximum239 {
    //O(n)
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            deque.offerLast(i);
            if (i >= k - 1) {
                list.add(nums[deque.peekFirst()]);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    //O(nlongn)
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2) {
                if (p1.value == p2.value) {
                    return 0;
                }
                return p1.value < p2.value ? 1 : -1;
            }
        });

        for (int i = 0; i < k; i++) {
            maxHeap.offer(new Pair(nums[i], i));
        }
        List<Integer> res = new ArrayList<>();
        res.add(maxHeap.peek().value);
        int slow = 1;
        for (int fast = k; fast < nums.length; fast++) {
            maxHeap.offer(new Pair(nums[fast], fast));
            while(maxHeap.peek().index < slow) {
                maxHeap.poll();
            }
            res.add(maxHeap.peek().value);
            slow++;
        }
        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ret[i] = res.get(i);
        }
        return ret;
    }

    private static class Pair{
        int value;
        int index;
        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
