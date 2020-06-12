/*
*
* Used map to count the number of each age
* for each age a and each age b
* if a != b, it will make countA * countB times request from a to b
* if a == b, it will make countA * (countA - 1) times request from a to other as not include itself.
*
* */


import java.util.HashMap;
import java.util.Map;

public class FriendsOfAppropriateAges825 {
    public int numFriendRequests(int[] ages) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int age : ages) {
            map.put(age, map.getOrDefault(age, 0) + 1);
        }
        int res = 0;
        for (int a : map.keySet()) {
            for (int b : map.keySet()) {
                if (request(a, b)) {
                    res += map.get(a) * (map.get(b) - (a == b ? 1 : 0));
                }
            }
        }
        return res;
    }

    private boolean request(int a, int b) {
        return !(b <= 0.5 * a + 7 || b > a || (a < 100 && b > 100));
    }
}
