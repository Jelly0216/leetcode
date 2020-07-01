import java.util.*;

public class SearchSuggestionsSystem1268 {
    public List<List<String>> SearchSuggestionsSystem1268(String[] products, String searchWord) {
        Arrays.sort(products);
        final Node root = new Node();
        for (String product : products) {
            addWord(product, root);
        }
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            res.add(new ArrayList<>());
        }
        getWord(searchWord, res, root);
        return res;
    }

    private void addWord(String str, Node root) {
        Node node = root;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new Node());
            }
            node = node.children.get(ch);
            if (node.words.size() < 3) {
                node.words.add(str);
            }
        }
    }

    private static class Node {
        Map<Character, Node> children;
        List<String> words;
        Node() {
            this.children = new HashMap<>();
            this.words = new ArrayList<>();
        }
    }

    private void getWord(String word, List<List<String>> res, Node root) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            node = node.children.get(ch);
            if (node != null) {
                res.get(i).addAll(node.words);
            }
            else {
                break;
            }
        }
    }
}
