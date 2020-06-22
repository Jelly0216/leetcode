public class KnightDialer935 {
    private final int[][] dirs = new int[][]{{4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0}, {}, {1, 7, 0}, {6, 2}, {1, 3}, {4, 2}};
    public int knightDialer(int N) {
        int count = 0;
        int[][] M = new int[N][10];
        Arrays.fill(M[0], 1);
        for (int i = 0; i < 10; i++) {
            count += helper(i, N - 1, M);
        }
        return count;
    }

    private int helper(int pos, int hops, int[][] M) {
        if (M[hops][pos] != 0) {
            return M[hops][pos];
        }
        int count = 0;
        for (int next : dirs[pos]) {
            count += helper(next, hops - 1, M);
        }
        M[hops][pos] = count;
        return count;
    }
}
