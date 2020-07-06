public class OnlineStockSpan901 {
    private Deque<int[]> stack;
    public OnlineStockSpan901() {
        this.stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int res = 1;
        while (!stack.isEmpty() && stack.peekFirst()[0] <= price) {
            res += stack.pollFirst()[1];
        }
        stack.offerFirst(new int[]{price, res});
        return res;
    }
}
