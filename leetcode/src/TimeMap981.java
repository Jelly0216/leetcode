import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMap981 {
    private Map<String, TreeMap<Integer, String>> map;
    /** Initialize your data structure here. */
    public TimeMap981() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new TreeMap<Integer, String>());
        }
        map.get(key).put(timestamp, value);;
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        TreeMap<Integer, String> treeMap = map.get(key);
        Integer time = treeMap.floorKey(timestamp);
        return time == null ? "" : treeMap.get(time);
    }
}
