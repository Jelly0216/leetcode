import java.util.*;

public class RemoveSubFoldersfromtheFilesystem1233 {
    private final Node root = new Node();
    public List<String> removeSubfolders(String[] folder) {
        if (folder == null || folder.length == 0) {
            return new ArrayList<>();
        }
        for (int i = 0; i < folder.length; i++) {
            add(folder[i], i);
        }

        return helper(folder);
    }


    private static class Node {
        private Map<Character, Node> map;
        private int index;
        Node() {
            this.map = new HashMap<>();
            this.index = -1;
        }
    }

    private void add(String str, int index) {
        Node node = root;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!node.map.containsKey(ch)) {
                node.map.put(ch, new Node());
            }
            node = node.map.get(ch);
        }
        node.index = index;
    }

    private List<String> helper(String[] folder) {
        List<String> res = new ArrayList<>();
        Deque<Node> q = new ArrayDeque<>();
        Node node = root;
        q.offer(node);
        while (!q.isEmpty()) {
            node = q.poll();
            if (node.index >= 0) {
                res.add(folder[node.index]);
            }
            if (!node.map.containsKey('/') || node.index < 0) {
                for (Node next : node.map.values()) {
                    q.offer(next);
                }
            }
        }
        return res;
    }
}
