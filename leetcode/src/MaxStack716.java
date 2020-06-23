class MaxStack716 {
    Deque<Integer> stack;
    Deque<Integer> maxStack;
    /** initialize your data structure here. */
    public MaxStack716() {
        this.stack = new ArrayDeque<>();
        this.maxStack = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.offerFirst(x);
        if (maxStack.isEmpty() || x >= maxStack.peekFirst()) {
            maxStack.offerFirst(x);
        }
    }

    public int pop() {
        int res = stack.pollFirst();
        if (!maxStack.isEmpty() && maxStack.peekFirst() == res) {
            maxStack.pollFirst();
        }
        return res;
    }

    public int top() {
        return stack.peekFirst();
    }

    public int peekMax() {
        return maxStack.peekFirst();
    }

    public int popMax() {
        int max = maxStack.peekFirst();
        Deque<Integer> buffer = new ArrayDeque<>();
        while (top() != max) {
            buffer.push(pop());
        }
        pop();
        while (!buffer.isEmpty()) {
            push(buffer.pollFirst());
        }
        return max;
    }
}