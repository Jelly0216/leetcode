public class ConvertBinarySearchTreetoSortedDoublyLinkedList426 {
    private Node last;
    private Node first;
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        helper(root);
        first.left = last;
        last.right = first;
        return first;
    }

    private void helper(Node node) {
        if (node == null) {
            return;
        }
        helper(node.left);
        if (last != null) {
            node.left = last;
            last.right = node;
        }
        else {
            first = node;
        }
        last = node;
        helper(node.right);
    }

    private class Node {
        Node left;
        Node right;
        int val;
    }
}
