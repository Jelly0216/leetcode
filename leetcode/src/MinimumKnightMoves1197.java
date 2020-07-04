import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class MinimumKnightMoves1197 {
    static final int[][] option = new int[][] {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        Set<Coordinate> visited = new HashSet<>();
        Queue<Coordinate> q = new ArrayDeque<>();
        Coordinate initial = new Coordinate(0, 0);
        q.offer(initial);
        visited.add(initial);
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Coordinate curr = q.poll();
                if (curr.x == x && curr.y == y) {
                    return res;
                }
                for (int j = 0; j < option.length; j++) {
                    int r = curr.x + option[j][0];
                    int c = curr.y + option[j][1];
                    Coordinate candidate = new Coordinate(r, c);
                    if (!visited.contains(candidate) && r >= -1 && c >= -1) {
                        visited.add(candidate);
                        q.offer(candidate);
                    }
                }
            }
            res++;
        }
        return res;
    }

    private static class Coordinate {
        int x;
        int y;
        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Coordinate)) {
                return false;
            }
            Coordinate another = (Coordinate) obj;
            return this.x == another.x && this.y == another.y;
        }
        @Override
        public int hashCode() {
            return x * 31  + y;
        }
    }
}
