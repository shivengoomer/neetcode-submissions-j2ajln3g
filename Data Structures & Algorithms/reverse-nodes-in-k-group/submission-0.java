class Solution {

    ListNode reverse(ListNode node, int k){
        ListNode curr = node, prev = null, next = null;

        while(k > 0){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;   // IMPORTANT
            k--;
        }
        return prev; // new head
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        if(head == null || k == 1) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode start = dummy;
        ListNode curr = head;
        int count = 0;
        while(curr != null){
            count++;
            if(count == k){

                ListNode nextGroup = curr.next;
                ListNode newHead = reverse(start.next, k);
                ListNode oldHead = start.next;
                start.next = newHead;
                oldHead.next = nextGroup;
                start = oldHead;
                curr = nextGroup;

                count = 0;
            }
            else{
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}
