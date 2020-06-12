import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII253 {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a1, int[] a2) {
                if (a1[0] == a2[0]) {
                    return 0;
                }
                return a1[0] < a2[0] ? -1 : 1;
            }
        });

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a1, int[] a2) {
                if (a1[1] == a2[1]) {
                    return 0;
                }
                return a1[1] < a2[1] ? -1 : 1;
            }
        });

        for (int[] interval : intervals) {
            if (minHeap.isEmpty() || minHeap.peek()[1]  > interval[0]) {
                minHeap.offer(interval);
            }
            else {
                minHeap.poll();
                minHeap.offer(interval);
            }
        }
        return minHeap.size();
    }
}
