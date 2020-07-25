public class FindDuplicateFileinSystem609 {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String path : paths) {
            String[] values = path.split(" ");
            for (int i = 1; i < values.length; i++) {
                String[] content = values[i].split("\\(");
                content[1] = content[1].replace(")", "");
                if (!map.containsKey(content[1])) {
                    map.put(content[1], new ArrayList<>());
                }
                map.get(content[1]).add(values[0] + "/" + content[0]);
            }
        }
        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                res.add(map.get(key));
            }
        }
        return res;
    }
}
