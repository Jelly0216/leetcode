import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrisonCellsAfterNDays957 {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<String, Integer> map = new HashMap<>();
        int n = cells.length;
        while (N > 0) {
            int[] cells1 = new int[n];
            String str = Arrays.toString(cells);
            map.put(str, N--);
            for (int i = 1; i < n - 1; i++) {
                cells1[i] = cells[i - 1] == cells[i + 1] ? 1: 0;
            }
            cells = cells1;
            str = Arrays.toString(cells);
            if (map.containsKey(str)) {
                N %= map.get(str) - N;
            }
        }
        return cells;
    }
}
