public class PyramidTransitionMatrix756 {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, Set<Character>> map = new HashMap<>();
        for (String s : allowed) {
            String prev = s.substring(0, 2);
            if (!map.containsKey(prev)) {
                map.put(prev, new HashSet<>());
            }
            map.get(prev).add(s.charAt(2));
        }
        return helper(bottom, "", map, 1);
    }

    private boolean helper(String row, String nextRow, Map<String, Set<Character>> map, int i) {
        if (row.length() == 1) {
            return true;
        }
        if (nextRow.length() + 1 == row.length()) {
            return helper(nextRow, "", map, 1);
        }
        for (char c : map.getOrDefault(row.substring(i - 1, i + 1), new HashSet<>())) {
            if (helper(row, nextRow + c, map, i + 1)) {
                return true;
            }
        }
        return false;
    }
}
