public class SwapNodesinPairs24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = swapPairs(next.next);
        head.next = newHead;
        next.next = head;
        return next;
    }
}
