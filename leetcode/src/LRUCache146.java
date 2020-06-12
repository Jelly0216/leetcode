import java.util.HashMap;
import java.util.Map;

public class LRUCache146 {
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int cap;
    public LRUCache146(int capacity) {
        this.map = new HashMap<>();
        this.cap = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        append(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = null;
        if (map.containsKey(key)) {
            node = map.get(key);
            remove(node);
            node.value = value;
        }
        else if (map.size() < cap) {
            node = new Node(key, value);
        }
        else {
            node = head;
            remove(node);
            node = new Node(key, value);
        }

        append(node);
    }

    private void remove(Node node) {
        map.remove(node.key);
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node == head) {
            head = head.next;
        }
        if (node == tail) {
            tail = tail.prev;
        }
        node.next = node.prev = null;
    }

    private void append(Node node) {
        map.put(node.key, node);
        if (head == null) {
            head = tail = node;
        }
        else {
            tail.next = node;
            node.prev = tail;
            tail = tail.next;
        }
    }

    private class Node {
        Node prev;
        Node next;
        int value;
        int key;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
