public class AddTwoNumbersII445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        while (l1 != null) {
            stack1.offerFirst(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.offerFirst(l2.val);
            l2 = l2.next;
        }
        ListNode curr = new ListNode(0);
        int sum = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty()) {
                sum += stack1.pollFirst();
            }
            if (!stack2.isEmpty()) {
                sum += stack2.pollFirst();
            }
            curr.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = curr;
            curr = head;
            sum /= 10;
        }
        return curr.val == 0 ? curr.next : curr;
    }
}
