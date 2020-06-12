

import java.util.HashMap;
import java.util.Map;

public class CopyListwithRandomPointer138 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Map<Node, Node> map = new HashMap<>();
        Node newHead = new Node(head.val);
        Node curr = newHead;
        map.put(head, newHead);
        while (head != null) {
            if (head.next != null) {
                if (!map.containsKey(head.next)) {
                    map.put(head.next, new Node(head.next.val));
                }
                curr.next = map.get(head.next);
            }

            if (head.random != null) {
                if (!map.containsKey(head.random)) {
                    map.put(head.random, new Node(head.random.val));
                }
                curr.random = map.get(head.random);
            }
            curr = curr.next;
            head = head.next;
        }
        return newHead;
    }

    private class Node {
        int val;
        Node next;
        Node random;
        Node(int val) {
            this.val = val;
        }
    }
}
