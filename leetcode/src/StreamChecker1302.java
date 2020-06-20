import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class StreamChecker1302 {
    private Node root;
    private List<Character> list;
    public StreamChecker1302(String[] words) {
        this.root = new Node();
        this.list = new ArrayList<>();
        for (String word : words) {
            add(word);
        }
    }

    public boolean query(char letter) {
        list.add(letter);
        Node node = root;
        for (int i = list.size() - 1; i >= 0; i--) {
            char ch = list.get(i);
            if (!node.map.containsKey(ch)) {
                return false;
            }
            node = node.map.get(ch);
            if (node.isWord) {
                return true;
            }

        }
        return false;
    }

    private static class Node {
        Map<Character, Node> map;
        boolean isWord;
        Node() {
            this.map = new HashMap<>();
        }
    }

    private void add(String word) {
        Node node = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            char ch = word.charAt(i);
            if (!node.map.containsKey(ch)) {
                node.map.put(ch, new Node());
            }
            node = node.map.get(ch);
        }
        node.isWord = true;
    }

}