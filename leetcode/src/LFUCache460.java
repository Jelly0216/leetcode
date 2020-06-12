import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

class LFUCache460 {
    private Map<Integer, Integer> val;
    private Map<Integer, Integer> count;
    private Map<Integer, LinkedHashSet<Integer>> list;
    private int cap;
    private int min;
    public LFUCache460(int capacity) {
        this.val = new HashMap<>();
        this.count = new HashMap<>();
        this.list = new HashMap<>();
        this.cap = capacity;
        this.min = 0;
    }

    public int get(int key) {
        if (!val.containsKey(key)) {
            return -1;
        }
        int num = count.get(key);
        int value = val.get(key);
        remove(key, num);
        append(key, value, num + 1);
        if (num == min && list.get(min).size() == 0) {
            min++;
        }
        return value;
    }

    public void put(int key, int value) {
        if (cap <= 0) {
            return;
        }
        if (val.containsKey(key)) {
            int num = count.get(key);
            remove(key, num);
            append(key, value, num + 1);
            if (num == min && list.get(min).size() == 0) {
                min++;
            }
        }
        else if (val.size() < cap) {
            append(key, value, 1);
            min = 1;
        }
        else {
            int oldKey = list.get(min).iterator().next();
            remove(oldKey, min);
            append(key, value, 1);
            min = 1;
        }
    }

    private void remove(int key, int num) {
        val.remove(key);
        count.remove(key);
        list.get(num).remove(key);
    }

    private void append(int key, int value, int num) {
        val.put(key, value);
        count.put(key, num);
        if (!list.containsKey(num)) {
            list.put(num, new LinkedHashSet<>());
        }
        list.get(num).add(key);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */