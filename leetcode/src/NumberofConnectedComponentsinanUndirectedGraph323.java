import java.util.*;
//dfs
public class NumberofConnectedComponentsinanUndirectedGraph323 {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            map.get(x).add(y);
            map.get(y).add(x);
        }
        Set<Integer> visited = new HashSet<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                helper(i, visited, map);
                res++;
            }
        }
        return res;
    }

    private void helper(int node, Set<Integer> visited, Map<Integer, List<Integer>> map) {
        if (visited.contains(node)) {
            return;
        }
        visited.add(node);
        for (int nei : map.get(node)) {
            helper(nei, visited, map);
        }
    }
}
