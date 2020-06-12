public class MinimumAreaRectangle939 {
    public int minAreaRect(int[][] points) {
        Map<Integer, List<Integer>> rows = new TreeMap<>();
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            if (!rows.containsKey(x)) {
                rows.put(x, new ArrayList<>());
            }
            rows.get(x).add(y);
        }
        int res = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap();
        for (int x : rows.keySet()) {
            List<Integer> row = rows.get(x);
            Collections.sort(row);
            for (int i = 0; i < row.size(); i++) {
                for (int j = i + 1; j < row.size(); j++) {
                    int y1 = row.get(i);
                    int y2 = row.get(j);
                    int code = 40001 * y1 + y2;
                    if (map.containsKey(code)) {
                        res = Math.min(res, (x - map.get(code)) * (y2 - y1));
                    }
                    map.put(code, x);
                }
            }
        }
        return res < Integer.MAX_VALUE ? res : 0;
    }
}
