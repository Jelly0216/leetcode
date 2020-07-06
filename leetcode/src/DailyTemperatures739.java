public class DailyTemperatures739 {
    public int[] dailyTemperatures(int[] T) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[T.length];
        for (int i = 0; i < res.length; i++) {
            while (!stack.isEmpty() && T[stack.peekFirst()] < T[i]) {
                res[stack.peekFirst()] = i - stack.peekFirst();
                stack.pollFirst();
            }
            stack.offerFirst(i);
        }
        return res;
    }
}
