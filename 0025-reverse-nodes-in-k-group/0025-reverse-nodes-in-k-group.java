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
    public ListNode reverse(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        ListNode nextNode=head;
        while(curr!=null){
            nextNode=nextNode.next;
            curr.next=prev;
            prev=curr;
            curr=nextNode;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode preTail=null;
        ListNode currHead=head;
        ListNode currTail=head;
        ListNode nextHead=null;
        while(currHead!=null){
            int count=1;
            while(currTail.next!=null && count<k){
                currTail=currTail.next;
                count++;
            }
            if(count!=k){
                break;
            }
            nextHead=currTail.next;//set next head
            currTail.next=null;//detach rhs of curr ll
            if(preTail!=null){
                preTail.next=null;
            }
            currTail=reverse(currHead);
            if(preTail!=null){
                preTail.next=currTail;
            }else{
                head=currTail;//this is the first LL then store the currhead as head
            }
            currHead.next=nextHead;
            //update the references
            preTail=currHead;
            currHead=nextHead;
            currTail=nextHead;

        }
        return head;
    }
}