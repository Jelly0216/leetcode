public class InsertInterval57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int index = 0;
        int n = intervals.length;
        int start = newInterval[0];
        int end = newInterval[1];
        while (index < n && intervals[index][0] < start) {
            res.add(intervals[index++]);
        }
        if (res.isEmpty() || res.get(res.size() - 1)[1] < start) {
            res.add(newInterval);
        }
        else {
            int[] interval = res.get(res.size() - 1);
            interval[1] = Math.max(interval[1], end);
            //res.add(interval);
        }

        while (index < n) {
            int[] interval = intervals[index++];
            if (interval[0] > res.get(res.size() - 1)[1]) {
                res.add(interval);
            }
            else {
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], interval[1]);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
