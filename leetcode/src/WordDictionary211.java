public class WordDictionary211 {
    private Node root;
    /** Initialize your data structure here. */
    public WordDictionary211() {
        this.root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new Node());
            }
            node = node.children.get(ch);
        }
        node.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return helper(word, 0, root);
    }

    private boolean helper(String str, int index, Node node) {
        if (node == null) {
            return false;
        }
        if (index == str.length()) {
            if (node.isWord) {
                return true;
            }
            return false;
        }

        if (str.charAt(index) == '.') {
            for (Node next : node.children.values()) {
                if (helper(str, index + 1, next)) {
                    return true;
                }
            }
        }
        else {
            if (helper(str, index + 1, node.children.get(str.charAt(index)))) {
                return true;
            }
        }

        return false;
    }

    private static class Node {
        Map<Character, Node> children;
        boolean isWord;
        Node() {
            this.children = new HashMap<>();
        }
    }
}
