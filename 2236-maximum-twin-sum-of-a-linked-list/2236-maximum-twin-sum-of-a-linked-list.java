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
    public ListNode midPoint(ListNode head){
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        ListNode next=null;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public int pairSum(ListNode head) {
        ListNode l1=head;
        ListNode mid=midPoint(head);
        ListNode l2=mid.next;
        mid.next=null;
        l2=reverse(l2);
        int result=Integer.MIN_VALUE;
        while(l1!=null && l2!=null){
            result=Math.max(l1.val + l2.val,result);
            l1=l1.next;
            l2=l2.next;
        }
        return result;
    }
}