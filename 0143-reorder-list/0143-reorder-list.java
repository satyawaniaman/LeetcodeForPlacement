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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null)return;
        //find the middle node
        ListNode fast=head,slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //reverse the second half 
        ListNode secondHalf=slow.next;
        slow.next=null;
        ListNode prev=null;
        while(secondHalf!=null){
            ListNode temp=secondHalf.next;
            secondHalf.next=prev;
            prev=secondHalf;
            secondHalf=temp;
        }
        //merge two halves
        ListNode firstHalf=head;
        while(prev!=null){
            ListNode temp1=firstHalf.next;
            ListNode temp2=prev.next;
            firstHalf.next=prev;
            prev.next=temp1;
            firstHalf=temp1;
            prev=temp2;
        }

    }
}