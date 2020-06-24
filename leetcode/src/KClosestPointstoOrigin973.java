import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointstoOrigin973 {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(K, new Comparator<>(){
            @Override
            public int compare(int[] a1, int[] a2) {
                int distance1 = getDistance(a1);
                int distance2 = getDistance(a2);
                if (distance1 == distance2) {
                    return 0;
                }
                return distance1 > distance2 ? -1 : 1;
            }
        });

        for (int[] point : points) {
            if (maxHeap.size() < K) {
                maxHeap.offer(point);
            }
            else if (getDistance(point) < getDistance(maxHeap.peek())) {
                maxHeap.poll();
                maxHeap.offer(point);
            }
        }
        int[][] res = new int[maxHeap.size()][];
        int index = 0;
        while (!maxHeap.isEmpty()) {
            res[index++] = maxHeap.poll();
        }
        return res;
    }


    private int getDistance(int[] array) {
        int res = 0;
        res += array[0] * array[0];
        res += array[1] * array[1];
        return res;
    }
}
