public class DesignSearchAutocompleteSystem642 {
    Node root;
    Node curr;
    String input = "";
    Map<String, Integer> freq;
    public DesignSearchAutocompleteSystem642(String[] sentences, int[] times) {
        this.freq = new HashMap<>();
        for (int i = 0; i < sentences.length; i++) {
            freq.put(sentences[i], times[i]);
        }
        this.root = new Node();
        for (String key : freq.keySet()) {
            add(root, key);
        }
        this.curr = root;
    }

    public List<String> input(char c) {
        List<String> res = new ArrayList();
        if (c == '#') {
            Integer count = freq.get(input);
            if (count == null) {
                freq.put(input, 1);
            }
            else {
                freq.put(input, count + 1);
            }
            add(root, input);
            input = "";
            curr = root;
        }
        else {
            input += c;
            if (!curr.contains(c)) {
                curr.addChild(c);
            }
            curr = curr.children.get(c);
            res = getSentences(curr);
        }
        return res;
    }

    private List<String> getSentences(Node node) {
        List<String> res = new ArrayList<>();
        if (node.count.size() == 0) {
            return res;
        }
        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                if (e1.getValue() == e2.getValue()) {
                    return e1.getKey().compareTo(e2.getKey());
                }
                return e1.getValue() < e2.getValue() ? 1 : -1;
            }
        });
        for (Map.Entry<String, Integer> entry : node.count.entrySet()) {
            maxHeap.offer(entry);
        }
        int k = 3;
        while (!maxHeap.isEmpty() && k > 0) {
            res.add(maxHeap.poll().getKey());
            k--;
        }
        return res;
    }

    private void add(Node node, String sentence) {
        for (char ch : sentence.toCharArray()) {
            if (!node.contains(ch)) {
                node.addChild(ch);
            }
            node = node.children.get(ch);
            node.addCount(sentence, freq.get(sentence));
        }
    }


    private static class Node {
        Map<Character, Node> children;
        Map<String, Integer> count;

        Node() {
            this.children = new HashMap<>();
            this.count = new HashMap<>();
        }

        private boolean contains(char ch) {
            return children.containsKey(ch);
        }

        private void addChild(char ch) {
            children.put(ch, new Node());
        }

        private void addCount(String str, int freq) {
            count.put(str, freq);
        }
    }
}
