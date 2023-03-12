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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head=null;
        ListNode temp=head;
        for(int i=0;i<lists.length;i++){
            ListNode now=lists[i];
            ListNode temp2=now;
            while(temp2!=null){
                if(head==null){
                    head=temp2;
                    temp=head;
                }
                else{
                    temp.next=temp2;
                    temp=temp2;
                }
                temp2=temp2.next;
            }
        }
        temp=head;
        while(temp!=null){
            // pq.add(temp);
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
        System.out.println();
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        temp=head;
        while(temp!=null){
            pq.add(temp);
            temp=temp.next;
        }
        ListNode ans=null;
        temp=ans;
        while(!pq.isEmpty()){
            ListNode v=new ListNode(pq.poll().val);
            if(ans==null){
                ans=v;
                temp=ans;
            }
            else{
                temp.next=v;
                temp=v;
            }
        }
        return ans;
    }
}