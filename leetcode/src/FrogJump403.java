/*
Used a map to store as the memo
the key is the the stone number in the array
the value is a set which stores the previous step that can jump to this stone
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrogJump403 {
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int stone : stones) {
            map.put(stone, new HashSet<>());
        }
        map.get(0).add(0);
        for (int i = 0; i < stones.length; i++) {
            for (int j : map.get(stones[i])) {
                for (int k = j - 1; k <= j + 1; k++) {
                    if (k > 0 && map.containsKey(stones[i] + k)) {
                        map.get(stones[i] + k).add(k);
                    }
                }
            }
        }
        return map.get(stones[stones.length - 1]).size() > 0;
    }
}
