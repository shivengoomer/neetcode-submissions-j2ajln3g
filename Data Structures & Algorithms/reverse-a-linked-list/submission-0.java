class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode curr = head;
        ListNode prev = null;
        ListNode next = curr.next;
        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null) next = next.next;
        }
        return prev;
    }
}
