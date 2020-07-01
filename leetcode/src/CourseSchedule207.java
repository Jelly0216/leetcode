import java.util.*;

public class CourseSchedule207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return false;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int curr = prerequisite[0];
            int prev = prerequisite[1];
            map.get(prev).add(curr);
        }
        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        int[] incoming = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int course : map.get(i)) {
                incoming[course]++;
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (incoming[i] == 0) {
                q.offer(i);
            }
        }
        int num = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            list.add(curr);
            num++;
            for (int next : map.get(curr)) {
                incoming[next]--;
                if (incoming[next] == 0) {
                    q.offer(next);
                }
            }
        }
        return num == numCourses;
    }
}
