public class AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int remainder = 0;
        while (l1 != null || l2 != null || remainder > 0) {
            if (l1 != null) {
                remainder += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                remainder += l2.val;
                l2 = l2.next;
            }
            curr.next = new ListNode(remainder % 10);
            remainder /= 10;
            curr = curr.next;
        }
        return dummy.next;
    }
}
