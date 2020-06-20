import java.util.*;

class RandomizedSet380 {
    private List<Integer> list;
    private Map<Integer, Integer> map;
    private Random rand;
    /** Initialize your data structure here. */
    public RandomizedSet380() {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
        this.rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        int temp = list.get(list.size() - 1);
        list.set(index, temp);
        map.put(temp, index);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

