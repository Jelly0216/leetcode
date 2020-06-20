import java.util.*;

public class RandomizedCollection381 {
    List<Integer> list;
    Map<Integer, Set<Integer>> map;
    Random rand = new Random();
    /** Initialize your data structure here. */

    public RandomizedCollection381() {
        this.list = new ArrayList<Integer>();
        this.map = new HashMap<Integer, Set<Integer>>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, new LinkedHashSet<Integer>());
        }
        map.get(val).add(list.size());
        list.add(val);
        return map.get(val).size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).size() == 0) {
            return false;
        }
        int index = map.get(val).iterator().next();
        map.get(val).remove(index);
        int lastEle = list.get(list.size() - 1);
        list.set(index, lastEle);
        map.get(lastEle).add(index);
        map.get(lastEle).remove(list.size() - 1);
        list.remove(list.size() - 1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}