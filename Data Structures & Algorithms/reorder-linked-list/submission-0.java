class Solution {
    public void reorderList(ListNode head) {

        if(head==null || head.next==null) return;

        // 1. Find middle
        ListNode slow = head;
        ListNode fast= head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode nextHalf = slow.next;
        slow.next = null;

        ListNode curr = nextHalf;
        ListNode prev = null;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        nextHalf = prev;

        ListNode first = head;
        ListNode second = nextHalf;

        while(second != null){
            ListNode t1 = first.next;
            ListNode t2 = second.next;

            first.next = second;
            second.next = t1;

            first = t1;
            second = t2;
        }
    }
}
