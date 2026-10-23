
class Solution {
    ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        head = reverse(head);

        if (n == 1) {
            head = head.next;
        } else {
            ListNode curr = head;

            for (int i = 0; i < n - 2; i++) {
                curr = curr.next;
            }

            curr.next = curr.next.next;
        }

        return reverse(head);
    }
}
