import java.util.*;

public class PossibleBipartition886 {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        if (dislikes.length == 0 || dislikes[0].length == 0) {
            return true;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, Integer> visited = new HashMap<>();
        for (int i = 1; i <= N; ++i)
            map.put(i, new ArrayList<>());
        for (int[] dislike : dislikes) {
            int person1 = dislike[0];
            int person2 = dislike[1];

            map.get(person1).add(person2);
            map.get(person2).add(person1);
        }
        for (int i = 1; i <= N; i++) {
            if (!helper(map, i, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean helper(Map<Integer, List<Integer>> map, int node, Map<Integer, Integer> visited) {
        if (visited.containsKey(node)) {
            return true;
        }
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(node);
        visited.put(node, 0);
        while (!q.isEmpty()) {
            int curr = q.poll();
            int currColor = visited.get(curr);
            int neiColor = currColor == 1 ? 0 : 1;
            for (int nei : map.get(curr)) {
                if (!visited.containsKey(nei)) {
                    visited.put(nei, neiColor);
                    q.offer(nei);
                }
                else if (visited.get(nei) != neiColor) {
                    return false;
                }
            }
        }
        return true;
    }
}
