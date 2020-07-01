public class WordSearchII212 {
    private final Node root = new Node();
    private final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<String> findWords(char[][] board, String[] words) {
        if (board.length == 0 || board[0].length == 0) {
            return new ArrayList<>();
        }
        buildTrie(words);
        int m = board.length;
        int n = board[0].length;
        Set<String> res = new HashSet<>();
        boolean[][] visited = new boolean[m][n];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Node node = root;
                helper(board, i, j, sb, res, visited, node);
            }
        }
        return new ArrayList<>(res);
    }

    private void helper(char[][] board, int i, int j, StringBuilder sb, Set<String> res, boolean[][] visited, Node node) {
        if (!isValid(i, j, board.length, board[0].length) || visited[i][j]) {
            return;
        }
        char ch = board[i][j];
        if (!node.map.containsKey(ch)) {
            return;
        }
        sb.append(ch);
        node = node.map.get(ch);
        if (node.isWord) {
            res.add(sb.toString());
        }
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int r = i + dir[0];
            int c = j + dir[1];
            helper(board, r, c, sb, res, visited, node);
        }
        visited[i][j] = false;
        sb.deleteCharAt(sb.length() - 1);

    }

    private void buildTrie(String[] words) {
        for (String word : words) {
            addWord(word);
        }
    }

    private void addWord(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.map.containsKey(ch)) {
                node.map.put(ch, new Node());
            }
            node = node.map.get(ch);
        }
        node.isWord = true;
    }

    private static class Node {
        Map<Character, Node> map;
        boolean isWord;
        Node() {
            this.map = new HashMap<>();
        }
    }

    private boolean isValid(int i, int j, int r, int c) {
        return i >= 0 && i < r && j >= 0 && j < c;
    }
}
