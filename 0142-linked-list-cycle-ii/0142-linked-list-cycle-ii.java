/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null) return null;
        ListNode temp=head;
        ListNode fast=head;
        ListNode slow=head;
        ListNode ans=null;
        int ct=0;
       while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                do{
                    slow=slow.next;
                    ct++;
                }while(slow!=fast);
                break;
            }
        }
        if(ct==0) return null;
        while(ct>0){
            temp=temp.next;
            ct--;
        }
        ListNode temp2=head;
        while(temp!=temp2){
            temp=temp.next;
            temp2=temp2.next;
        }
        return temp;
    }
}