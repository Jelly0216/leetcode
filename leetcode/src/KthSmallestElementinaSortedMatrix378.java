import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementinaSortedMatrix378 {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Ele> minHeap = new PriorityQueue<>(new Comparator<Ele>(){
            @Override
            public int compare(Ele e1, Ele e2) {
                if (e1.value == e2.value) {
                    return 0;
                }
                return e1.value < e2.value ? -1 : 1;
            }
        });

        boolean[][] visited = new boolean[matrix.length][matrix.length];
        minHeap.offer(new Ele(0, 0, matrix[0][0]));
        visited[0][0] = true;
        for (int i = 0; i < k - 1; i++) {
            Ele curr = minHeap.poll();
            if (curr.x + 1 < matrix.length && !visited[curr.x + 1][curr.y]) {
                minHeap.offer(new Ele(curr.x + 1, curr.y, matrix[curr.x + 1][curr.y]));
                visited[curr.x + 1][curr.y] = true;
            }
            if (curr.y + 1 < matrix.length && !visited[curr.x][curr.y + 1]) {
                minHeap.offer(new Ele(curr.x, curr.y + 1, matrix[curr.x][curr.y + 1]));
                visited[curr.x][curr.y + 1] = true; ;
            }
        }
        return minHeap.peek().value;
    }

    static class Ele {
        int x;
        int y;
        int value;
        Ele(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}
