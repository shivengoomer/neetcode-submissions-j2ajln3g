/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1=l1;
        ListNode t2=l2;
        int cr=0;
        ListNode dummy= new ListNode(0);
        ListNode ans=dummy;
        while(t1!=null || t2!=null || cr!=0){
            int d1=(t1!=null) ? t1.val : 0;
            int d2=(t2!=null) ? t2.val : 0;
            int sum=cr+d1+d2;
            ans.next = new ListNode(sum%10);
            cr=sum/10;
            ans=ans.next;
            t1=(t1!=null)? t1.next : null;
            t2=(t2!=null)? t2.next : null;
        }
        ans.next=null;
        return dummy.next;
    }
}
