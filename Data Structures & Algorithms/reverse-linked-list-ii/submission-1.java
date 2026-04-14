class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = dummy;

        for(int i = 1; i < left; i++){
            curr = curr.next;
        }

        ListNode temp = curr.next; 
        ListNode tail = temp;     
        ListNode prev = null;
        ListNode next = null;
        for(int i = 0; i <= right - left; i++){
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }

        curr.next = prev;
        tail.next = next;

        return dummy.next;
    }
}
