public class MinimumHeightTrees310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (edges.length == 0 || edges[0].length == 0) {
            return new ArrayList<>(Arrays.asList());
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            int one = edge[0];
            int two = edge[1];
            if (!map.containsKey(one)) {
                map.put(one, new HashSet<>());
            }
            map.get(one).add(two);
            if (!map.containsKey(two)) {
                map.put(two, new HashSet<>());
            }
            map.get(two).add(one);
        }
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (map.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int j = map.get(i).iterator().next();
                map.get(j).remove(i);
                if (map.get(j).size() == 1) {
                    newLeaves.add(j);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
