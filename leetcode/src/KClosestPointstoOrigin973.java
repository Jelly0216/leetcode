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


    public int[][] kClosest(int[][] points, int K) {
        helper(points, K, 0, points.length - 1);
        return Arrays.copyOfRange(points, 0, K);
    }

    private void helper(int[][] points, int K, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = left + (int)(Math.random() * (right - left + 1));
        int pivot = getDistance(points[pivotIndex]);
        swap(points, pivotIndex, right);
        int leftIndex = left;
        int rightIndex = right - 1;
        while (leftIndex <= rightIndex) {
            if (getDistance(points[leftIndex]) < pivot) {
                leftIndex++;
            }
            else if (getDistance(points[rightIndex]) >= pivot) {
                rightIndex--;
            }
            else {
                swap(points, leftIndex++, rightIndex--);
            }
        }
        swap(points, leftIndex, right);
        if (K == leftIndex) {
            return;
        }
        else if (K > leftIndex) {
            helper(points, K, leftIndex + 1, right);
        }
        helper(points, K, left, leftIndex - 1);
    }

    private void swap(int[][] points, int left, int right) {
        int temp1 = points[left][0];
        int temp2 = points[left][1];
        points[left][0] = points[right][0];
        points[left][1] = points[right][1];
        points[right][0] = temp1;
        points[right][1] = temp2;
    }

    private int getDistance(int[] array) {
        return array[0] * array[0] + array[1] * array[1];
    }
}
