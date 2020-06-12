/*
use dfs to traverse the graph and create a map to store the mapping between the original
node and its copy.
 */


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph133 {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        Map<Node, Node> map = new HashMap<>();
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        helper(node, map);
        return newNode;
    }

    private void helper(Node node, Map<Node, Node> map) {
        Node curr = map.get(node);
        for (Node nei : node.neighbors) {
            if (!map.containsKey(nei)) {
                map.put(nei, new Node(nei.val));
                helper(nei, map);
            }
            curr.neighbors.add(map.get(nei));
        }
    }

    private class Node {
        int val;
        List<Node> neighbors;
        Node(int val) {
            this.val = val;
        }
    }
}
