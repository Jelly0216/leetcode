import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class MaximumFrequencyStack895 {
    private Map<Integer, Integer> freq;
    private Map<Integer, Deque<Integer>> stack;
    private int maxFreq;
    public MaximumFrequencyStack895() {
        this.freq = new HashMap<>();
        this.stack = new HashMap<>();
        this.maxFreq = 0;
    }

    public void push(int x) {
        Integer count = freq.get(x);
        int currFreq = 0;
        if (count == null) {
            currFreq = 1;
        }
        else {
            currFreq = count + 1;
        }
        freq.put(x, currFreq);
        maxFreq = Math.max(maxFreq, currFreq);
        if (!stack.containsKey(currFreq)) {
            stack.put(currFreq, new ArrayDeque<>());
        }
        stack.get(currFreq).offerFirst(x);
    }

    public int pop() {
        int res = stack.get(maxFreq).pollFirst();
        freq.put(res, freq.get(res) - 1);
        if (stack.get(maxFreq).size() == 0) {
            maxFreq--;
        }
        return res;
    }
}
