public class ReorderList143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = getMid(head);
        ListNode head2 = mid.next;
        mid.next = null;
        merge(head, reverse(head2));
    }

    private ListNode getMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

    private void merge(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (h1 != null && h2 != null) {
            curr.next = h1;
            h1 = h1.next;
            curr.next.next = h2;
            h2 = h2.next;
            curr = curr.next.next;
        }
        if (h1 != null) {
            curr.next = h1;
        }
        else if (h2 != null) {
            curr.next = h2;
        }
    }
}
