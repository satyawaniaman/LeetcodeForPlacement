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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode curr=dummy;
        Map<Integer,ListNode> map=new HashMap<>();
        int currSum=0;
        while(curr!=null){
            //add the sum to currSum
            currSum+=curr.val;
            //check if it is present in the map or not if not then move to next and put sum and curr address
            if(map.containsKey(currSum)){
                // take temp sum variable to store from curr and until its value reaches to the curr sum which is 
                //same as the other value in the map ,delete it from the map and move ahead 
                //then connect the linked list from dummy next to curr next
                //move the curr pointer to the next of the  previous same value 
                curr=map.get(currSum).next;
                int tempSum=currSum+curr.val;
                while(tempSum!=currSum){
                    map.remove(tempSum);
                    curr=curr.next;
                    tempSum+=curr.val;
                }
                //after deleting it just add the new connection
                map.get(currSum).next=curr.next;

            }else{
                map.put(currSum,curr);
            }
            curr=curr.next;
        }
        return dummy.next;
    }
}