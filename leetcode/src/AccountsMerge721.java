public class AccountsMerge721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, String> users = new HashMap<>();
        for (List<String> account : accounts) {
            String username = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String curr = account.get(i);
                users.put(curr, username);
                if (!graph.containsKey(curr)) {
                    graph.put(curr, new HashSet<>());
                }
                if (i == 1) {
                    continue;
                }
                String prev = account.get(i - 1);
                graph.get(curr).add(prev);
                graph.get(prev).add(curr);
            }
        }
        Set<String> visited = new HashSet<>();
        List<List<String>> res = new ArrayList<>();
        for (String key : graph.keySet()) {
            if (visited.add(key)) {
                List<String> curr = new ArrayList<>();
                helper(key, graph, visited, curr);
                Collections.sort(curr);
                curr.add(0, users.get(key));
                res.add(curr);
            }
        }
        return res;
    }

    private void helper(String email, Map<String, Set<String>> graph, Set<String> visited, List<String> curr) {
        curr.add(email);
        for (String next : graph.get(email)) {
            if (visited.add(next)) {
                helper(next, graph, visited, curr);
            }
        }
    }
}
