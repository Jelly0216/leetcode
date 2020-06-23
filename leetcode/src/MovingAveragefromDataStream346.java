public class MovingAveragefromDataStream346 {
    private Queue<Integer> q;
    private int size;
    private double value;
    /** Initialize your data structure here. */
    public MovingAveragefromDataStream346(int size) {
        this.q = new ArrayDeque<>();
        this.size = size;
        this.value = 0;
    }

    public double next(int val) {
        if (q.size() < size) {
            q.offer(val);
            value += val;
        }
        else {
            value -= q.poll();
            q.offer(val);
            value += val;
        }
        return (double) (value / q.size());
    }
}
