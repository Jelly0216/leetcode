public class JumpGameIII1306 {
    public boolean canReach(int[] arr, int start) {
        Deque<Integer> q = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(start);
        visited.add(start);
        while (!q.isEmpty()) {
            int currIndex = q.poll();
            if (arr[currIndex] == 0) {
                return true;
            }
            int nextIndex = currIndex + arr[currIndex];
            if (nextIndex < arr.length) {
                if (visited.add(nextIndex)) {
                    q.offer(nextIndex);
                }
            }

            nextIndex = currIndex - arr[currIndex];
            if (nextIndex >= 0) {
                if (visited.add(nextIndex)) {
                    q.offer(nextIndex);
                }
            }
        }
        return false;
    }
}
