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
    public boolean isCritical(ListNode prev,ListNode curr){
        return (curr.val>prev.val && curr.val>curr.next.val )||(curr.val<prev.val && curr.val<curr.next.val);
    }
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if(head==null){
            return new int[]{-1,-1};
        }
        ListNode prev=head;
        ListNode curr=head.next;
        if(curr==null || curr.next==null){
            return new int[] {-1,-1};
        }
        int count=0;
        int idx=1;
        int first=-1;
        int last=-1;
        int maxDis=Integer.MIN_VALUE;
        int minDis=Integer.MAX_VALUE;
        while(curr.next!=null){
            if(isCritical(prev,curr)){
                count++;
                if(count==1){
                    first=idx;
                    last=idx;
                }else{
                    minDis=Math.min(minDis,idx-last);
                    last=idx;
                }
            }
            idx++;
            curr=curr.next;
            prev=prev.next;
        }
        if(count==0 || count==1){
            return new int[] {-1,-1};
        }
        maxDis=Math.max(maxDis,last-first);
        return new int[] {minDis,maxDis};
    }
}