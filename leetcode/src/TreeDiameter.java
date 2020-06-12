import java.util.*;

public class TreeDiameter {
    public int treeDiameter(int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            int v1 = edge[0];
            int v2 = edge[1];
            if (!map.containsKey(v1)) {
                map.put(v1, new ArrayList<>());
            }
            map.get(v1).add(v2);

            if (!map.containsKey(v2)) {
                map.put(v2, new ArrayList<>());
            }
            map.get(v2).add(v1);
        }
        Set<Integer> visited = new HashSet<>();
        int[] far = helper(edges[0][0], visited, map);
        int[] res = helper(far[0], visited, map);
        return res[1];
    }

    private int[] helper(int st, Set<Integer> visited, Map<Integer, List<Integer>> map) {
        visited.add(st);
        int dist = 0;
        int node = st;
        for (int next : map.get(st)) {
            if (!visited.contains(next)) {
                int[] values = helper(next, visited, map);
                if (dist <values[1] + 1) {
                    dist = values[1] + 1;
                    node = values[0];
                }
            }
        }
        visited.remove(st);
        return new int[]{node, dist};
    }
}
