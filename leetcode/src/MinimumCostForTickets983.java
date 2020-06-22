import java.util.HashSet;

public class MinimumCostForTickets983 {
    //
    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> set = new HashSet<>();
        int[] M = new int[366];
        for (int day : days) {
            set.add(day);
        }
        for (int i = 1; i < 366; i++) {
            if (set.contains(i)) {
                M[i] = Math.min(M[i - 1] + costs[0], M[Math.max(0, i - 7)] + costs[1]);
                M[i] = Math.min(M[i], M[Math.max(0, i - 30)] + costs[2]);
            }
            else {
                M[i] = M[i - 1];
            }
        }

        return M[365];
    }
}
