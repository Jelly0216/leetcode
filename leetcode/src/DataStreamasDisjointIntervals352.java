import java.util.TreeMap;

/*
    use treemap to store the mapping of start point and interval
    the key = start, value = interval
    case0: if map already contains, just return
    case1: if input == lower.end + 1 && input == higher.start - 1: lower.end = higher.end
    case2: if input <= lower.end + 1: lower.end = Math.max(lower.end, input);
    case3: if input == higher.start - 1: higher.start = input
    otherwise: add new interval to map
 */
public class DataStreamasDisjointIntervals352 {
    private TreeMap<Integer, Interval> map;
    /** Initialize your data structure here. */
    public DataStreamasDisjointIntervals352() {
        this.map = new TreeMap<>();
    }

    public void addNum(int val) {
        if (map.containsKey(val)) {
            return;
        }
        Integer lower = map.lowerKey(val);
        Integer higher = map.higherKey(val);
        if (lower != null && higher != null && map.get(lower).end + 1 == val && higher - 1 == val) {
            map.get(lower).end = map.get(higher).end;
            map.remove(higher);
        }
        else if (lower != null && map.get(lower).end  + 1 >= val) {
            map.get(lower).end = Math.max(map.get(lower).end, val);
        }
        else if (higher != null && higher - 1 == val) {
            map.put(val, new Interval(val, map.get(higher).end));
            map.remove(higher);
        }
        else {
            map.put(val, new Interval(val, val));
        }
    }

    public int[][] getIntervals() {
        int[][] res = new int[map.size()][2];
        int index = 0;
        for (Interval interval : map.values()) {
            res[index][0] = interval.start;
            res[index][1] = interval.end;
            index++;
        }
        return res;
    }

    private class Interval {
        int start;
        int end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}
