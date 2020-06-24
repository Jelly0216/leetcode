import java.util.*;

/*
1. use dfs travese the graph and count the level of each node. If there is a cycle, the value from child should be
equal the value of parent because it is the cycle.

int each level:
case 1: if the neighbor is parent, continue for other neighbors
case 2: if the levels[nei] == 0 which means the nei has not been visited, dfs it and get the value from this nei
case 3: if it has been visited, get the value from array and compare to return the min value

if the curr level value is parent level + 1 which means there is no cycle. Just add it to res
 */
public class CriticalConnectionsinaNetwork1192 {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (List<Integer> connection : connections) {
            int node1 = connection.get(0);
            int node2 = connection.get(1);
            if (!map.containsKey(node1)) {
                map.put(node1, new ArrayList<>());
            }
            map.get(node1).add(node2);
            if (!map.containsKey(node2)) {
                map.put(node2, new ArrayList<>());
            }
            map.get(node2).add(node1);
        }
        List<List<Integer>> res = new ArrayList<>();
        int[] levels = new int[n];
        helper(0, -1, 0, levels, res, map);
        return res;
    }

    private int helper(int curr, int parent, int level, int[] levels, List<List<Integer>> res, Map<Integer, List<Integer>> map) {
        levels[curr] = level + 1;
        for (int nei : map.get(curr)) {
            if (nei == parent) {
                continue;
            }
            else if (levels[nei] == 0) {
                int neiLevel = helper(nei, curr, level + 1, levels, res, map);
                levels[curr] = Math.min(levels[curr], neiLevel);
            }
            else {
                levels[curr] = Math.min(levels[curr], levels[nei]);
            }
        }

        if (levels[curr] == level + 1 && curr != 0) {
            res.add(Arrays.asList(curr, parent));
        }

        return levels[curr];
    }
}
