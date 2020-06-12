import org.w3c.dom.Node;

public class InsertintoaSortedCircularLinkedList708 {
    public Node insert(Node head, int insertVal) {
        if (head == null) {
            Node newNode = new Node(insertVal);
            newNode.next = newNode;
            return newNode;
        }

        Node prev = head;
        Node curr = head.next;

        do{

            if (prev.val <= insertVal &&insertVal <= curr.val) {
                prev.next = new Node(insertVal, curr);
                return head;
            }
            else if (prev.val > curr.val) {
                if (insertVal >= prev.val || insertVal <= curr.val) {
                    prev.next = new Node(insertVal, curr);
                    return head;
                }
            }
            prev = curr;
            curr = curr.next;
        } while (prev != head);
        prev.next= new Node(insertVal, curr);
        return head;
    }


}
