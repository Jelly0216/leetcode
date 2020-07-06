public class BusRoutes815 {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int route : routes[i]) {
                if (!map.containsKey(route)) {
                    map.put(route, new HashSet<>());
                }
                map.get(route).add(i);
            }
        }

        Set<Integer> visited = new HashSet<>();
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{S, 0});
        visited.add(S);
        boolean[] taken = new boolean[routes.length];
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int stop = curr[0];
            int numBus = curr[1];
            if (stop == T) {
                return numBus;
            }
            for (int next : map.get(stop)) {
                if (taken[next]) {
                    continue;
                }
                for (int j : routes[next]) {
                    if (!visited.contains(j)) {
                        visited.add(j);
                        q.offer(new int[]{j, numBus + 1});
                    }
                }
                taken[next] = true;
            }
        }
        return -1;
    }
}
